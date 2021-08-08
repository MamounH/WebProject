package webapp.login;

import webapp.data.Role;
import webapp.data.domain.User;
import webapp.data.dao.UsersDao;
import webapp.security_config.PasswordHash;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {

	private UsersDao usersDao;

	@Resource(name="jdbc/project")
	private DataSource dataSource;


	@Override
	public void init() throws ServletException {
		super.init();
		usersDao = new UsersDao(dataSource, new PasswordHash());
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,res);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");


		User user = usersDao.VerifyUser(email,password);
		System.out.println(" from servlet user role is "+ user.getRole());

		if (user.getRole().equals(Role.NOT_USER)){
			req.setAttribute("errorM","Invalid User");
			req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,res);
			req.getSession().setAttribute("role",user.getRole());
		}
		else if (user.getRole().equals(Role.STUDENT)){
			req.getSession().setAttribute("id",user.getId());
			req.getSession().setAttribute("role",user.getRole());
			req.getSession().setAttribute("name",email);
			res.sendRedirect("/StudentCourses.do");
		}
		else if (user.getRole().equals(Role.INSTRUCTOR)){
		req.getSession().setAttribute("id",user.getId());
		req.getSession().setAttribute("name",email);
			req.getSession().setAttribute("role",user.getRole());
			res.sendRedirect("/Instructor/Courses.do");

		} else if (user.getRole().equals(Role.ADMIN)){
			req.getSession().setAttribute("id",user.getId());
			req.getSession().setAttribute("name",email);
			req.getSession().setAttribute("role",user.getRole());
			res.sendRedirect("/Admin/Users.do");
		}




	}





}
