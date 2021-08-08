package webapp.Admin_controller;

import webapp.data.dao.UsersDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/Users.do")
public class AdminServlet extends HttpServlet {


    private UsersDao usersDao;

    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        usersDao = new UsersDao(dataSource);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("list", usersDao.getAll());
        request.getRequestDispatcher("/WEB-INF/Admin/users/Users.jsp").forward(request,response);
    }



}
