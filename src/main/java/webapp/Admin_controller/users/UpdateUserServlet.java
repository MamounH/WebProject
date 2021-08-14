package webapp.Admin_controller.users;

import webapp.data.domain.User;
import webapp.data.dao.UsersDao;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/UpdateUser.do")
public class UpdateUserServlet extends HttpServlet {


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
        String id = req.getParameter("id");
        User user = usersDao.getUser(id);
        req.setAttribute("user",user);
        req.getRequestDispatcher("/WEB-INF/Admin/users/UpdateUser.jsp").forward(req,res);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws  IOException {

        User user = getUser(req);
        usersDao.updateUser(user);
        res.sendRedirect("/Admin/Users.do");


    }

    private User getUser(HttpServletRequest req) {
        int id = Integer.parseInt(req.getParameter("id"));
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String email = req.getParameter("email");
        return new User.UserBuilder().id(id).fName(fName).lName(lName).email(email).build();
    }
}
