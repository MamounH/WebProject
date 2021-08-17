package webapp.controllers.admin.courses;

import webapp.data.domain.Course;
import webapp.data.dao.CoursesDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/UpdateCourse.do")
public class UpdateCourseServlet extends HttpServlet {


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
        String id = req.getParameter("id");
        Course course = coursesDao.getCourse(id);
        req.setAttribute("course",course);
        req.getRequestDispatcher("/WEB-INF/Admin/courses/UpdateCourse.jsp").forward(req,res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException {

        Course course = getUpdatedCourse(req);
        coursesDao.updateCourse(course);
        res.sendRedirect("/Admin/courses.do");
    }

    private Course getUpdatedCourse(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int instructorId= Integer.parseInt(req.getParameter("Instructor_id"));
        return new Course.CourseBuilder().id(id).name(name).instructorId(instructorId).build();
    }


}
