package webapp.data.dao;


import webapp.data.domain.CourseMarks;
import webapp.data.domain.Student;
import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    private DataSource dataSource;

    public StudentDAO(DataSource dataSource){
        this.dataSource=dataSource;
    }

    public List<CourseMarks> getStudentMarks(int id){


        List<CourseMarks> studentMarks = new ArrayList<>();
        try {
            connection=dataSource.getConnection();

            String sql = "SELECT * FROM `student_marks` AS m" +
                    " JOIN `courses` AS c" +
                    " ON m.course_id = c.id" +
                    " JOIN users u ON u.id = c.instructor_id" +
                    " WHERE m.student_id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            resultSet=statement.executeQuery();

            while(resultSet.next()){

                String mark = resultSet.getString("mark");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                String courseName = resultSet.getString("name");
                String instructorFullName= fName+" "+lName;
                CourseMarks tmp = new CourseMarks.CourseMarksBuilder().mark(mark).courseInstructor(instructorFullName)
                .courseName(courseName).build();
                studentMarks.add(tmp);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }

        return studentMarks;

    }


    public List<Student> getEnrolledStudents(int id) {


        List<Student> students = new ArrayList<>();


        try {
            connection=dataSource.getConnection();

            String sql = "SELECT * FROM `student_marks` AS u" +
                    " LEFT JOIN `users` AS s" +
                    " ON u.student_id = s.id" +
                    " WHERE u.course_id=?";

            statement = connection.prepareStatement(sql);
            statement.setInt(1,id);

            resultSet=statement.executeQuery();

            while(resultSet.next()){

                int studentId = resultSet.getInt("student_id");
                String grade = resultSet.getString("mark");
                String fName = resultSet.getString("first_name");
                String lName = resultSet.getString("last_name");
                String email = resultSet.getString("email");
                String fullName= fName+" "+lName;
                Student tmp = new Student(studentId,fullName,email,grade);
                students.add(tmp);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            close(connection,statement,resultSet);
        }


        return students;


    }


    public void updateMark(int id, int courseId,String mark) {

        try {

            connection=dataSource.getConnection();
            String sql = "update student_marks "+"set mark=? "+
                    "where student_id=? AND course_id=?";

            statement=connection.prepareStatement(sql);


            statement.setString(1,mark);
            statement.setInt(2,id);
            statement.setInt(3,courseId);

            statement.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            close(connection,statement,null);
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
