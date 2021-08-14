package webapp.data.dao;

import webapp.data.domain.Course;
import webapp.data.domain.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CoursesDao {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private DataSource dataSource;

    private final Logger logger = Logger.getLogger("CoursesDao Log");


    public CoursesDao(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<Course> getAll() {
        List<Course> courses = new ArrayList<>();

        try {
            getAllCourses(courses);
        } catch (SQLException ex) {
            logError(ex);
        } finally {
            close(connection,statement,resultSet);
        }

        return courses;
    }

    private void getAllCourses(List<Course> courses) throws SQLException {
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
            logError(e);
            } finally {
            close(connection,statement,resultSet);
        }

        return course;

    }

    public void addCourse(String courseName, int instructorId) {

        try {
            addNewCourse(courseName, instructorId);
        }catch (Exception e){
            logError(e);
        } finally {
            close(connection,statement,null);
        }

    }

    private void addNewCourse(String courseName, int instructorId) throws SQLException {
        connection=dataSource.getConnection();

        String sql = "insert into courses "+"(name,instructor_id)"+
                "values (?,?)";

        statement = connection.prepareStatement(sql);
        statement.setString(1,courseName);
        statement.setInt(2,instructorId);
        statement.execute();
    }

    public List<Course> getInstructorCourses(int id){


        List<Course> courses = new ArrayList<>();
        try {
            findInstructorCourses(id, courses);
        } catch (SQLException ex) {
            logError(ex);
        } finally {
            close(connection,statement,resultSet);
        }

        return courses;

    }

    private void findInstructorCourses(int id, List<Course> courses) throws SQLException {
        connection=dataSource.getConnection();

        String sql = "SELECT * FROM courses WHERE instructor_id=?";

        statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        resultSet=statement.executeQuery();

        while(resultSet.next()){

            int courseId = resultSet.getInt("id");
            String courseName = resultSet.getString("name");

            Course tmp = new Course.CourseBuilder().id(courseId).name(courseName).build();

            courses.add(tmp);
        }
    }

    public void addStudentToCourse(String sId, int courseId) {

        try {
            addNewStudents(sId, courseId);
        }catch (Exception e){
            logError(e);
        } finally {
            close(connection,statement,null);
        }

    }

    private void addNewStudents(String sId, int courseId) throws SQLException {
        connection=dataSource.getConnection();

        String sql = "insert into student_marks "+"(student_id,course_id)"+
                "values (?,?)";

        statement = connection.prepareStatement(sql);
        statement.setString(1,sId);
        statement.setInt(2,courseId);
        statement.execute();
    }


    public void updateCourse(Course course) {

        try {

            submitUpdates(course);

        } catch (Exception e){
            logError(e);
        } finally {
            close(connection,statement,resultSet);
        }


    }

    private void submitUpdates(Course course) throws SQLException {
        connection=dataSource.getConnection();

        String sql ="UPDATE courses "+"SET name=?, instructor_id=? "+
                "WHERE id=?";

        statement=connection.prepareStatement(sql);

        statement.setString(1, course.getName());
        statement.setInt(2, course.getInstructorId());
        statement.setInt(3, course.getId());
        statement.executeUpdate();
    }

    public void deleteCourse(String id) {

        try {
            delete(id);
        } catch (Exception e){
            logError(e);
        } finally {
            close(connection,statement,null);
        }

    }

    private void delete(String id) throws SQLException {
        int courseId = Integer.parseInt(id);

        connection = dataSource.getConnection();

        String sql = "delete from courses where id=?";

        statement=connection.prepareStatement(sql);

        statement.setInt(1,courseId);

        statement.execute();
    }

    public List<User> getPossibleStudents(int id) {

        List<User> users=new ArrayList<>();
        try {
            findStudents(id, users);
        } catch (SQLException ex) {
            logError(ex);
        } finally {
            close(connection,statement,resultSet);
        }
        return users;
    }

    private void findStudents(int id, List<User> users) throws SQLException {
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

        statement.setInt(1, id);

        resultSet=statement.executeQuery();

        while(resultSet.next()) {

            int Sid = resultSet.getInt("id");
            String fName = resultSet.getString("first_name");
            String lName = resultSet.getString("last_name");
            String email = resultSet.getString("email");
            User user = new User.UserBuilder().id(Sid).email(email).fName(fName).lName(lName).build();
            users.add(user);
        }
    }

    public void removeStudentFromCourse(String studentId, int courseId) {

        try {
            removeStudents(studentId, courseId);
        } catch (Exception e){
           logError(e);
        } finally {
            close(connection,statement,null);
        }


    }

    private void removeStudents(String studentId, int courseId) throws SQLException {
        connection = dataSource.getConnection();

        String sql = "delete from student_marks where student_id=? and course_id=?";

        statement=connection.prepareStatement(sql);

        statement.setString(1,studentId);
        statement.setInt(2,courseId);

        statement.execute();
    }


    private void close(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if (resultSet !=null){
                resultSet.close();
            }

            if (connection != null){
                connection.close();
            }

            if(statement!=null){
                statement.close();
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }



    private void logError (Exception e){
        logger.log(Level.SEVERE,e.getMessage());
    }


}
