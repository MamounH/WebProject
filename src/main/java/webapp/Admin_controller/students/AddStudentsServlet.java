package webapp.Admin_controller.students;

import webapp.data.dao.CoursesDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/AddStudent.do")
public class AddStudentsServlet extends HttpServlet {


    private CoursesDao coursesDao;

    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        coursesDao = new CoursesDao(dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        request.getSession().setAttribute("courseId",id);

        request.setAttribute("list", coursesDao.getPossibleStudents(id));
        request.getRequestDispatcher("/WEB-INF/Admin/courses/students/AddStudents.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int courseId = (int) request.getSession().getAttribute("courseId");
        String[] id = request.getParameterValues("id");

        for (int i = 0; i< id.length; i++){
            coursesDao.addStudentToCourse(id[i],courseId);
        }

        response.sendRedirect("/Admin/courses.do");
    }


}
