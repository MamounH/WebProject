package webapp.data.dao;

import webapp.data.Role;
import webapp.data.domain.User;
import webapp.security_config.IPasswordHash;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersDao {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private DataSource dataSource;
    private IPasswordHash passwordHash;

    public UsersDao(DataSource dataSource){
        this.dataSource=dataSource;
    }


    public UsersDao(DataSource dataSource, IPasswordHash passwordHash){
        this.dataSource=dataSource;
        this.passwordHash=passwordHash;
    }



    public List<User> getAll(){

        List<User> users=new ArrayList<>();

        try {

            connection=dataSource.getConnection();

            String sql = "SELECT * FROM `users`";

            statement = connection.prepareStatement(sql);

            resultSet=statement.executeQuery();

            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String email = resultSet.getString("email");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                String role = resultSet.getString("role");

                User user = new User.UserBuilder().id(id).fName(fName)
                        .lName(lName).email(email).role(Role.valueOf(role)).build();

                users.add(user);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }


        return users;
    }

    public List<User> getUsersByRole(Role role){

        List<User> users=new ArrayList<>();

        try {

            connection=dataSource.getConnection();

            String sql = "SELECT * FROM `users` WHERE role=?";


            statement = connection.prepareStatement(sql);

            statement.setString(1,role.toString());

            resultSet=statement.executeQuery();

            while(resultSet.next()) {

                int id = resultSet.getInt("id");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                User user = new User.UserBuilder().id(id).fName(fName).lName(lName).build();
                users.add(user);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }
        return users;
    }

    public User getUser(String id) {

        User user = new User.UserBuilder().build();
        try {

            connection=dataSource.getConnection();

            String sql = "select * from users where id=?";

            statement = connection.prepareStatement(sql);

            statement.setString(1,id);

            resultSet=statement.executeQuery();

            if (resultSet.next()){

                int uId = resultSet.getInt("id");
                String firstName = resultSet.getString("first_name");
                String lastName= resultSet.getString("last_name");
                String email = resultSet.getString("email");
                user = new User.UserBuilder().id(uId).fName(firstName).lName(lastName)
                        .email(email).build();

            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

        return user;
    }

    public void addUser(User user){


        try {

            user = configureUserPassword(user);
            connection=dataSource.getConnection();

            String sql = "insert into users "+"(email,password,salt,first_name,last_name,role)"+
                    "values (?,?,?,?,?,?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1,user.getEmail());
            statement.setString(2,user.getPassword());
            statement.setString(3,user.getSalt());
            statement.setString(4,user.getfName());
            statement.setString(5,user.getlName());
            statement.setString(6,String.valueOf(user.getRole()));

            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,null);
        }

    }

    private User configureUserPassword(User user) {

        byte[] byteSalt = passwordHash.getSalt();
        byte[] byteDigestPassword = passwordHash.getSaltedHash(user.getPassword(),byteSalt);
        String strDigestPassword= passwordHash.toHex(byteDigestPassword);
        String strSalt = passwordHash.toHex(byteSalt);

        return new User.UserBuilder().id(user.getId()).fName(user.getfName()).lName(user.getlName()).
                email(user.getEmail()).role(user.getRole()).password(strDigestPassword).salt(strSalt).build();
    }


    public void updateUser(User user) {

        try {

            connection=dataSource.getConnection();

            String sql ="UPDATE users "+"SET first_name=?, last_name=?, email=? "+
                    "WHERE id=?";

            statement=connection.prepareStatement(sql);

            statement.setString(1,user.getfName());
            statement.setString(2,user.getlName());
            statement.setString(3,user.getEmail());
            statement.setInt(4,user.getId());
            statement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

    }


    public User VerifyUser(String email, String password){

        User user = new User.UserBuilder().build();
        try {

            connection=dataSource.getConnection();

            String sql = "SELECT * FROM `users` WHERE email=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1,email);

            resultSet=statement.executeQuery();

            while(resultSet.next()){

                int id = resultSet.getInt("id");
                String storedPassword = resultSet.getString("password");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                String role = resultSet.getString("role");
                String salt = resultSet.getString("salt");

                byte[] byteSalt = passwordHash.fromHex(salt);
                byte[] loginPassword = passwordHash.getSaltedHash(password, byteSalt);
                byte[] savedPassword = passwordHash.fromHex(storedPassword);
                boolean isMatched = Arrays.equals(loginPassword,savedPassword);

                if (isMatched){
                    user = new User.UserBuilder().id(id).fName(fName).lName(lName).role(Role.valueOf(role))
                            .build();
                    return user;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

        user.setRole(Role.NOT_USER);
        return user;

    }

    public void deleteUser(String id) {

        try {

            connection=dataSource.getConnection();

            String sql = "delete from users where id=?";

            statement = connection.prepareStatement(sql);
            statement.setString(1,id);
            statement.executeUpdate();


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

    }

    private void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet !=null){
                resultSet.close();
            }

            if (connection != null){
                connection.close(); // put it back in pool
            }

            if(statement!=null){
                statement.close();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
