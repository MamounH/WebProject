package webapp.controllers.student;

import webapp.data.dao.StudentDAO;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/StudentCourses")
public class StudentServlet extends HttpServlet {


    private StudentDAO studentDao;

    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        studentDao = new StudentDAO(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int id = (int) req.getSession().getAttribute("id");
        req.setAttribute("list", studentDao.getStudentMarks(id));
        req.getRequestDispatcher("/WEB-INF/Students/listStudentCourses.jsp").forward(req,res);
    }



}
