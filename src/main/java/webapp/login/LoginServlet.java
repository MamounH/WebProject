package webapp.login;

import webapp.data.domain.User;
import webapp.data.dao.UsersDao;
import webapp.security_config.SHA512Hash;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	private UsersDao usersDao;

	@Resource(name="jdbc/project")
	private DataSource dataSource;


	@Override
	public void init() throws ServletException {
		super.init();
		usersDao = new UsersDao(dataSource, new SHA512Hash());
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

		req.getSession().setAttribute("id",user.getId());
		req.getSession().setAttribute("role",user.getRole());


		switch (user.getRole()){
			case ADMIN-> res.sendRedirect("/Admin/Users");
			case INSTRUCTOR-> res.sendRedirect("/Instructor/Courses");
			case STUDENT->res.sendRedirect("/StudentCourses");
			default-> {
				req.setAttribute("errorM","Invalid User");
				req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,res);
			}

		}

	}





}
