package webapp.controllers.instructor;

import webapp.data.dao.StudentDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Instructor/CourseMarks")
public class CourseMarksServlet extends HttpServlet {



    private StudentDAO studentDAO;

    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDAO = new StudentDAO(dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("courseId"));
        req.getSession().setAttribute("courseId",id);
        req.setAttribute("list", studentDAO.getEnrolledStudents(id));
        req.getRequestDispatcher("/WEB-INF/Instructor/EnrolledStudents.jsp").forward(req,res);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        String[] studentId= request.getParameterValues("id");
        String[] marks =request.getParameterValues("mark");
        int courseId = (int) request.getSession().getAttribute("courseId");

        updateMarks(studentId, marks, courseId);

        response.sendRedirect("/Instructor/CourseMarks?courseId="+courseId);
    }

    private void updateMarks(String[] studentId, String[] marks, int courseId) {

        for (int i = 0; i< studentId.length; i++){

            int id = Integer.parseInt(studentId[i]);
            String mark = marks[i];
            if (!mark.isBlank()){
            studentDAO.updateMark(id, courseId,mark);
            }
        }

    }
}
