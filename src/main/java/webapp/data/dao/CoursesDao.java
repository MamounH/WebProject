package webapp.data.dao;

import webapp.data.domain.Course;
import webapp.data.domain.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CoursesDao {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private DataSource dataSource;



    public CoursesDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();

        try {
            connection=dataSource.getConnection();

            String sql = "SELECT * FROM courses AS c " +
                    "JOIN users AS u ON " +
                    "c.instructor_id=u.id";

            statement = connection.prepareStatement(sql);

            resultSet=statement.executeQuery();

            while(resultSet.next()){

                int courseId = resultSet.getInt("id");
                String courseName = resultSet.getString("name");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                int instructorId = resultSet.getInt("instructor_id");

                String instructorName=fName+" "+lName;
                Course tmp = new Course.CourseBuilder().id(courseId).name(courseName).instructorName(instructorName).
                        instructorId(instructorId).build();
                courses.add(tmp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

        return courses;
    }

    public Course getCourse(String id) {

        Course course = new Course.CourseBuilder().build();
        try {

            connection=dataSource.getConnection();

            String sql = "select * from courses where id=?";

            statement = connection.prepareStatement(sql);

            statement.setString(1,id);

            resultSet=statement.executeQuery();

            if (resultSet.next()){
                int courseID = resultSet.getInt("id");
                String courseName = resultSet.getString("name");
                int instructorId= resultSet.getInt("instructor_id");
                course=new Course.CourseBuilder().name(courseName).instructorId(instructorId).id(courseID).build();
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

        return course;

    }

    public void addCourse(String courseName, int instructorId) {

        try {
            connection=dataSource.getConnection();

            String sql = "insert into courses "+"(name,instructor_id)"+
                    "values (?,?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1,courseName);
            statement.setInt(2,instructorId);
            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,null);
        }

    }

    public List<Course> getInstructorCourses(int id){


        List<Course> courses = new ArrayList<>();
        try {
            connection=dataSource.getConnection();

            String sql = "SELECT * FROM courses WHERE instructor_id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            resultSet=statement.executeQuery();

            while(resultSet.next()){

                int courseId = resultSet.getInt("id");
                String courseName = resultSet.getString("name");

                Course tmp = new Course.CourseBuilder().id(courseId).name(courseName).build();

                courses.add(tmp);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

        return courses;

    }

    public void addStudentToCourse(String sId, int courseId) {

        try {
            connection=dataSource.getConnection();

            String sql = "insert into student_marks "+"(student_id,course_id)"+
                    "values (?,?)";

            statement = connection.prepareStatement(sql);
            statement.setString(1,sId);
            statement.setInt(2,courseId);
            statement.execute();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,null);
        }

    }


    public void updateCourse(Course course) {

        try {

            connection=dataSource.getConnection();

            String sql ="UPDATE courses "+"SET name=?, instructor_id=? "+
                    "WHERE id=?";

            statement=connection.prepareStatement(sql);

            statement.setString(1,course.getName());
            statement.setInt(2,course.getInstructorId());
            statement.setInt(3,course.getId());
            statement.executeUpdate();

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }


    }

    public void deleteCourse(String id) {

        try {
            int courseId = Integer.parseInt(id);

            connection = dataSource.getConnection();

            String sql = "delete from courses where id=?";

            statement=connection.prepareStatement(sql);

            statement.setInt(1,courseId);

            statement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,null);
        }

    }

    public List<User> getPossibleStudents(int id) {

        List<User> users=new ArrayList<>();
        try {

            connection=dataSource.getConnection();

            String sql =
                    "SELECT *" +
                    "FROM student_marks m " +
                    "JOIN users u ON u.id=m.student_id " +
                    "WHERE u.id NOT IN ( " +
                    "SELECT student_id " +
                    "from student_marks " +
                    "where course_id=?)";


            statement = connection.prepareStatement(sql);

            statement.setInt(1,id);

            resultSet=statement.executeQuery();

            while(resultSet.next()) {

                int Sid = resultSet.getInt("id");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                User user = new User.UserBuilder().id(Sid).email(email).fName(fName).lName(lName).build();
                users.add(user);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }
        return users;
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


    public void removeStudentFromCourse(String studentId, int courseId) {


        try {
            connection = dataSource.getConnection();

            String sql = "delete from student_marks where student_id=? and course_id=?";

            statement=connection.prepareStatement(sql);

            statement.setString(1,studentId);
            statement.setInt(2,courseId);

            statement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,null);
        }


    }



}
