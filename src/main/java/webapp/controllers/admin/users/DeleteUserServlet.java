package webapp.controllers.admin.users;

import webapp.data.dao.UsersDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/DeleteUser.do")
public class DeleteUserServlet extends HttpServlet {


    private UsersDao usersDao;
    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        usersDao = new UsersDao(dataSource);
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        usersDao.deleteUser(req.getParameter("id"));
        res.sendRedirect("/Admin/Users.do");
    }


}
