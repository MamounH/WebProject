package webapp.Admin_controller.students;

import webapp.data.dao.CoursesDao;
import webapp.data.dao.StudentDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/RemoveStudents.do")
public class RemoveStudentServlet extends HttpServlet {

    private CoursesDao coursesDao;
    private StudentDAO studentDAO;

    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        coursesDao = new CoursesDao(dataSource);
        studentDAO= new StudentDAO(dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("courseId",id);

        request.setAttribute("list", studentDAO.getEnrolledStudents(id));
        request.getRequestDispatcher("/WEB-INF/Admin/courses/students/RemoveStudents.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {

        removeStudentsFromCourse(request);

        response.sendRedirect("/Admin/courses.do");
    }

    private void removeStudentsFromCourse(HttpServletRequest request) {
        int courseId = (int) request.getSession().getAttribute("courseId");
        String[] id = request.getParameterValues("id");

        for (String s : id) {
            coursesDao.removeStudentFromCourse(s, courseId);
        }
    }
}
