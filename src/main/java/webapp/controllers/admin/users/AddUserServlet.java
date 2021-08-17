package webapp.controllers.admin.users;

import webapp.data.Role;
import webapp.data.domain.User;
import webapp.data.dao.UsersDao;
import webapp.security_config.SHA512Hash;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.sql.DataSource;
import java.io.IOException;

@WebServlet(urlPatterns = "/Admin/AddUser.do")
public class AddUserServlet extends HttpServlet {

    private UsersDao usersDao;
    @Resource(name="jdbc/project")
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        super.init();
        usersDao = new UsersDao(dataSource, new SHA512Hash());
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Admin/users/AddUser.jsp").forward(request,response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    User user = getUser(request);
    usersDao.addUser(user);
     response.sendRedirect("/Admin/Users.do");

    }

    private User getUser(HttpServletRequest request) {
        String fName = request.getParameter("fName");
        String lName = request.getParameter("lName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        return new User.UserBuilder().fName(fName).lName(lName).email(email)
                        .password(password).role(Role.valueOf(role)).build();
    }
}
