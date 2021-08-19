// package webapp.filter;


// import webapp.data.Role;

// import javax.servlet.*;
// import javax.servlet.annotation.WebFilter;
// import javax.servlet.http.HttpServletRequest;
// import java.io.IOException;

// @WebFilter(urlPatterns = "*.do")
// public class LoginFilter implements Filter {

//     private FilterConfig filterConfig = null;

//     @Override
//     public void init(FilterConfig filterConfig) throws ServletException {
//         this.filterConfig=filterConfig;
//     }

//     @Override
//     public void doFilter(ServletRequest serverReq, ServletResponse serverRes, FilterChain filterChain) throws IOException, ServletException {
//         HttpServletRequest request = (HttpServletRequest) serverReq;

//         Role role = (Role) request.getSession().getAttribute("role");

//         if (role == null){
//             forwardToLoginPage(serverReq,serverRes,request);
//         }
//         else {
//             handleUser(serverReq, serverRes, filterChain, request, role);
//         }
//     }

//     private void handleUser(ServletRequest serverReq, ServletResponse serverRes, FilterChain filterChain, HttpServletRequest request, Role role) throws ServletException, IOException {
//         switch (role) {
//             case STUDENT -> checkStudentPath(serverReq, serverRes, request, filterChain);
//             case INSTRUCTOR -> checkInstructorPath(serverReq, serverRes, request, filterChain);
//             case ADMIN -> forwardToRequestedPage(serverReq, serverRes, filterChain);
//             default -> forwardToLoginPage(serverReq, serverRes, request);
//         }
//     }

//     private void forwardToRequestedPage(ServletRequest serverReq, ServletResponse serverRes, FilterChain filterChain) throws IOException, ServletException {
//         filterChain.doFilter(serverReq, serverRes);
//     }

//     private void forwardToLoginPage(ServletRequest serverReq, ServletResponse serverRes, HttpServletRequest request) throws ServletException, IOException {
//         request.getRequestDispatcher("/login.do").forward(serverReq,serverRes);
//     }


//     private void checkInstructorPath(ServletRequest serverReq, ServletResponse serverRes, HttpServletRequest request,FilterChain filterChain) throws ServletException, IOException {
//         String path = request.getServletPath();
//         if (path.startsWith("/Admin/")){
//             request.getRequestDispatcher("/Instructor/Courses.do").forward(serverReq, serverRes);
//         }  else forwardToRequestedPage(serverReq,serverRes,filterChain);
//     }

//     private void checkStudentPath(ServletRequest serverReq, ServletResponse serverRes, HttpServletRequest request, FilterChain filterChain) throws ServletException, IOException {
//         String path = request.getServletPath();

//         if (path.startsWith("/Admin/") || path.startsWith("/Instructor/") ){
//             request.getRequestDispatcher("/StudentCourses.do").forward(serverReq, serverRes);
//         } else forwardToRequestedPage(serverReq, serverRes, filterChain);
//     }

//     @Override
//     public void destroy() {
//         this.filterConfig=null;
//     }
// }
