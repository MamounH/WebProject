/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-08 21:26:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.Admin.users;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Users_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(4);
    _jspx_dependants.put("/WEB-INF/Admin/users/../../common/NavigationBar/AdminNavigation.jspf", Long.valueOf(1628449786330L));
    _jspx_dependants.put("/WEB-INF/Admin/users/../../common/header.jspf", Long.valueOf(1628443454737L));
    _jspx_dependants.put("/WEB-INF/Admin/users/../../common/../common/css/navStyle.css", Long.valueOf(1628443454666L));
    _jspx_dependants.put("/WEB-INF/Admin/users/../../common/footer.jspf", Long.valueOf(1628441669219L));
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');
      out.write("<style>\r\n");
      out.write("@import url(\"//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css\");\r\n");
      out.write("\r\n");
      out.write(".navbar-icon-top .navbar-nav .nav-link > .fa {\r\n");
      out.write("    position: relative;\r\n");
      out.write("    width: 36px;\r\n");
      out.write("    font-size: 24px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-icon-top .navbar-nav .nav-link > .fa > .badge {\r\n");
      out.write("    font-size: 0.75rem;\r\n");
      out.write("    position: absolute;\r\n");
      out.write("    right: 0;\r\n");
      out.write("    font-family: sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-icon-top .navbar-nav .nav-link > .fa {\r\n");
      out.write("    top: 3px;\r\n");
      out.write("    line-height: 12px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".navbar-icon-top .navbar-nav .nav-link > .fa > .badge {\r\n");
      out.write("    top: -10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media (min-width: 576px) {\r\n");
      out.write("    .navbar-icon-top.navbar-expand-sm .navbar-nav .nav-link {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        display: table-cell;\r\n");
      out.write("        height: 70px;\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("        padding-top: 0;\r\n");
      out.write("        padding-bottom: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-sm .navbar-nav .nav-link > .fa {\r\n");
      out.write("        display: block;\r\n");
      out.write("        width: 48px;\r\n");
      out.write("        margin: 2px auto 4px auto;\r\n");
      out.write("        top: 0;\r\n");
      out.write("        line-height: 24px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-sm .navbar-nav .nav-link > .fa > .badge {\r\n");
      out.write("        top: -7px;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media (min-width: 768px) {\r\n");
      out.write("    .navbar-icon-top.navbar-expand-md .navbar-nav .nav-link {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        display: table-cell;\r\n");
      out.write("        height: 70px;\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("        padding-top: 0;\r\n");
      out.write("        padding-bottom: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-md .navbar-nav .nav-link > .fa {\r\n");
      out.write("        display: block;\r\n");
      out.write("        width: 48px;\r\n");
      out.write("        margin: 2px auto 4px auto;\r\n");
      out.write("        top: 0;\r\n");
      out.write("        line-height: 24px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-md .navbar-nav .nav-link > .fa > .badge {\r\n");
      out.write("        top: -7px;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media (min-width: 992px) {\r\n");
      out.write("    .navbar-icon-top.navbar-expand-lg .navbar-nav .nav-link {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        display: table-cell;\r\n");
      out.write("        height: 70px;\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("        padding-top: 0;\r\n");
      out.write("        padding-bottom: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-lg .navbar-nav .nav-link > .fa {\r\n");
      out.write("        display: block;\r\n");
      out.write("        width: 48px;\r\n");
      out.write("        margin: 2px auto 4px auto;\r\n");
      out.write("        top: 0;\r\n");
      out.write("        line-height: 24px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-lg .navbar-nav .nav-link > .fa > .badge {\r\n");
      out.write("        top: -7px;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media (min-width: 1200px) {\r\n");
      out.write("    .navbar-icon-top.navbar-expand-xl .navbar-nav .nav-link {\r\n");
      out.write("        text-align: center;\r\n");
      out.write("        display: table-cell;\r\n");
      out.write("        height: 70px;\r\n");
      out.write("        vertical-align: middle;\r\n");
      out.write("        padding-top: 0;\r\n");
      out.write("        padding-bottom: 0;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-xl .navbar-nav .nav-link > .fa {\r\n");
      out.write("        display: block;\r\n");
      out.write("        width: 48px;\r\n");
      out.write("        margin: 2px auto 4px auto;\r\n");
      out.write("        top: 0;\r\n");
      out.write("        line-height: 24px;\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    .navbar-icon-top.navbar-expand-xl .navbar-nav .nav-link > .fa > .badge {\r\n");
      out.write("        top: -7px;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <link href=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("    <script src=\"//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("    <script src=\"//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <title>Atypon University</title>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write('\r');
      out.write('\n');
      out.write("<nav class=\"navbar navbar-icon-top navbar-expand-lg navbar-dark bg-dark\">\r\n");
      out.write("    <div class=\"logo\">\r\n");
      out.write("        <img src=\"https://raw.githubusercontent.com/MamounH/Logo/main/220px-Atypon.png\" class=\"img img-responsive center-block\"/>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("        <ul class=\"navbar-nav mr-auto\">\r\n");
      out.write("            <li class=\"nav-item active\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/Admin/Users.do\">\r\n");
      out.write("                    <i class=\"fa fa-user-circle\"></i>\r\n");
      out.write("                    Users\r\n");
      out.write("                    <span class=\"sr-only\">(current)</span>\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"/Admin/courses.do\">\r\n");
      out.write("                    <i class=\"fa fa-university\">\r\n");
      out.write("                    </i>\r\n");
      out.write("                    Courses\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("\r\n");
      out.write("            <li class=\"nav-item\">\r\n");
      out.write("                <a class=\"nav-link\" href=\"https://github.com/MamounH\">\r\n");
      out.write("                    <i class=\"fa fa-github\">\r\n");
      out.write("                    </i>\r\n");
      out.write("                    GitHub\r\n");
      out.write("                </a>\r\n");
      out.write("            </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("\r\n");
      out.write("            <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("\r\n");
      out.write("                <li class=\"nav-item\">\r\n");
      out.write("                    <a class=\"nav-link\" href=\"/logout.do\">\r\n");
      out.write("                        <i class=\"fa fa-sign-out\">\r\n");
      out.write("                        </i>\r\n");
      out.write("                        Logout\r\n");
      out.write("                    </a>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<style> .table-wrapper {\r\n");
      out.write("    max-height: 450px;\r\n");
      out.write("    overflow: scroll;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"container\">\r\n");
      out.write("\r\n");
      out.write("    <div class=\"table-wrapper\">\r\n");
      out.write("    <table class = \"table table-striped table-hover table-condensed\">\r\n");
      out.write("\r\n");
      out.write("        <thead>\r\n");
      out.write("        <th>ID</th>\r\n");
      out.write("        <th>First Name</th>\r\n");
      out.write("        <th>Last Name</th>\r\n");
      out.write("        <th>Email</th>\r\n");
      out.write("        <th>Role</th>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        <tr>\r\n");
      out.write("            ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("    </table>\r\n");
      out.write("    </div>\r\n");
      out.write("    <a class=\"btn btn-success\" href=\"/Admin/AddUser.do\">Add New User</a>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"webjars/jquery/1.9.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"webjars/bootstrap/3.3.6/js/bootstrap.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /WEB-INF/Admin/users/Users.jsp(26,12) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/WEB-INF/Admin/users/Users.jsp(26,12) '${list}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${list}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    // /WEB-INF/Admin/users/Users.jsp(26,12) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("user");
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\r\n");
          out.write("            <input type=\"hidden\" name=\"id\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">\r\n");
          out.write("            </td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.fName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.lName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.email}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("            <td>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.role}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</td>\r\n");
          out.write("                <td><a class=\"btn btn-info\" href=\"/Admin/UpdateUser.do?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\">Update User</a></td>\r\n");
          out.write("                <td><a class=\"btn btn-danger\" href=\"/Admin/DeleteUser.do?id=");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${user.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\"\r\n");
          out.write("                       onclick=\"if (!(confirm('are you sure you want to delete this student'))) return false\"\r\n");
          out.write("                >Delete User</a></td>\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("\r\n");
          out.write("        </tr>\r\n");
          out.write("        ");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }
}
