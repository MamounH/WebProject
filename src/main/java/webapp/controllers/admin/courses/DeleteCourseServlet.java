package webapp.controllers.admin.courses;

import webapp.data.dao.CoursesDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/DeleteCourse")
public class DeleteCourseServlet extends HttpServlet {

    private CoursesDao coursesDao;

    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        coursesDao = new CoursesDao(dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        coursesDao.deleteCourse(req.getParameter("id"));
        res.sendRedirect("/Admin/courses");
    }



}
