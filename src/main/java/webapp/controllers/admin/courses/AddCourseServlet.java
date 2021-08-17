package webapp.controllers.admin.courses;

import webapp.data.dao.CoursesDao;
import webapp.data.Role;
import webapp.data.dao.UsersDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/AddCourse.do")
public class AddCourseServlet extends HttpServlet {


    private UsersDao usersDao;
    private CoursesDao coursesDao;

    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        usersDao = new UsersDao(dataSource);
        coursesDao = new CoursesDao(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", usersDao.getUsersByRole(Role.INSTRUCTOR));
        request.getRequestDispatcher("/WEB-INF/Admin/courses/AddCourse.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String courseName = request.getParameter("name");
        int InstructorId = Integer.parseInt(request.getParameter("instructorID"));
        coursesDao.addCourse(courseName,InstructorId);
        response.sendRedirect("/Admin/courses.do");
    }


}
