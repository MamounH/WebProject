package webapp.logout;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout.do")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res ) throws ServletException, IOException {
        req.getSession().invalidate(); // name in session will be deleted...

        req.getRequestDispatcher("/WEB-INF/pages/login.jsp").forward(req,res);
    }


}
