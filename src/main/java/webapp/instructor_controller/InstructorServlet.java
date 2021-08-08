package webapp.instructor_controller;

import webapp.data.dao.CoursesDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Instructor/Courses.do")
public class InstructorServlet extends HttpServlet {


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

        int id = (int) req.getSession().getAttribute("id");
        req.setAttribute("list", coursesDao.getInstructorCourses(id));
        req.getRequestDispatcher("/WEB-INF/Instructor/InstructorCourses.jsp").forward(req,res);
    }



}
