/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2021-08-19 09:17:38 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/WEB-INF/pages/../common/css/login.css", Long.valueOf(1628391201226L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
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

      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("div.main{\r\n");
      out.write("    background: #0264d6; /* Old browsers */\r\n");
      out.write("    background: -moz-radial-gradient(center, ellipse cover,  #0264d6 1%, #1c2b5a 100%); /* FF3.6+ */\r\n");
      out.write("    background: -webkit-gradient(radial, center center, 0px, center center, 100%, color-stop(1%,#0264d6), color-stop(100%,#1c2b5a)); /* Chrome,Safari4+ */\r\n");
      out.write("    background: -webkit-radial-gradient(center, ellipse cover,  #0264d6 1%,#1c2b5a 100%); /* Chrome10+,Safari5.1+ */\r\n");
      out.write("    background: -o-radial-gradient(center, ellipse cover,  #0264d6 1%,#1c2b5a 100%); /* Opera 12+ */\r\n");
      out.write("    background: -ms-radial-gradient(center, ellipse cover,  #0264d6 1%,#1c2b5a 100%); /* IE10+ */\r\n");
      out.write("    background: radial-gradient(ellipse at center,  #0264d6 1%,#1c2b5a 100%); /* W3C */\r\n");
      out.write("    filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#0264d6', endColorstr='#1c2b5a',GradientType=1 ); /* IE6-9 fallback on horizontal gradient */\r\n");
      out.write("    height:calc(100vh);\r\n");
      out.write("    width:100%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("[class*=\"fontawesome-\"]:before {\r\n");
      out.write("    font-family: 'FontAwesome', sans-serif;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("* {\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("    margin:0px auto;\r\n");
      out.write("\r\n");
      out.write("&:before,\r\n");
      out.write("&:after {\r\n");
      out.write("     box-sizing: border-box;\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("body {\r\n");
      out.write("\r\n");
      out.write("    color: #606468;\r\n");
      out.write("    font: 87.5%/1.5em 'Open Sans', sans-serif;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a {\r\n");
      out.write("    color: #eee;\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("a:hover {\r\n");
      out.write("    text-decoration: underline;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input {\r\n");
      out.write("    border: none;\r\n");
      out.write("    font-family: 'Open Sans', Arial, sans-serif;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    line-height: 1.5em;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    -webkit-appearance: none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("p {\r\n");
      out.write("    line-height: 1.5em;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".clearfix {\r\n");
      out.write("    *zoom: 1;\r\n");
      out.write("\r\n");
      out.write("&:before,\r\n");
      out.write("&:after {\r\n");
      out.write("     content: ' ';\r\n");
      out.write("     display: table;\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("&:after {\r\n");
      out.write("     clear: both;\r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".container {\r\n");
      out.write("    left: 50%;\r\n");
      out.write("    position: fixed;\r\n");
      out.write("    top: 50%;\r\n");
      out.write("    transform: translate(-50%, -50%);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login form{\r\n");
      out.write("    width: 250px;\r\n");
      out.write("}\r\n");
      out.write("#login, .logo{\r\n");
      out.write("    display:inline-block;\r\n");
      out.write("    width:40%;\r\n");
      out.write("}\r\n");
      out.write("#login{\r\n");
      out.write("    border-right:1px solid #fff;\r\n");
      out.write("    padding: 0px 22px;\r\n");
      out.write("    width: 59%;\r\n");
      out.write("}\r\n");
      out.write(".logo{\r\n");
      out.write("    color:#fff;\r\n");
      out.write("    font-size:50px;\r\n");
      out.write("    line-height: 125px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login form span.fa {\r\n");
      out.write("    background-color: #fff;\r\n");
      out.write("    border-radius: 3px 0px 0px 3px;\r\n");
      out.write("    color: #000;\r\n");
      out.write("    display: block;\r\n");
      out.write("    float: left;\r\n");
      out.write("    height: 50px;\r\n");
      out.write("    font-size:24px;\r\n");
      out.write("    line-height: 50px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("    width: 50px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login form input {\r\n");
      out.write("    height: 50px;\r\n");
      out.write("}\r\n");
      out.write("fieldset{\r\n");
      out.write("    padding:0;\r\n");
      out.write("    border:0;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("#login form input[type=\"text\"], input[type=\"password\"] {\r\n");
      out.write("    background-color: #fff;\r\n");
      out.write("    border-radius: 0px 3px 3px 0px;\r\n");
      out.write("    color: #000;\r\n");
      out.write("    margin-bottom: 1em;\r\n");
      out.write("    padding: 0 16px;\r\n");
      out.write("    width: 200px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login form input[type=\"submit\"] {\r\n");
      out.write("    border-radius: 3px;\r\n");
      out.write("    -moz-border-radius: 3px;\r\n");
      out.write("    -webkit-border-radius: 3px;\r\n");
      out.write("    background-color: #000000;\r\n");
      out.write("    color: #eee;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("    text-transform: uppercase;\r\n");
      out.write("    padding: 5px 10px;\r\n");
      out.write("    height: 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login form input[type=\"submit\"]:hover {\r\n");
      out.write("    background-color: #d44179;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login > p {\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#login > p span {\r\n");
      out.write("    padding-left: 5px;\r\n");
      out.write("}\r\n");
      out.write(".middle {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    width: 600px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>");
      out.write("\r\n");
      out.write("<link href=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("<script src=\"//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"logo\">Atypon University JenkinsTest\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <center>\r\n");
      out.write("            <div class=\"middle\">\r\n");
      out.write("                <div id=\"login\">\r\n");
      out.write("\r\n");
      out.write("                    <form action=\"/login\" method=\"post\">\r\n");
      out.write("\r\n");
      out.write("                                <p color=\"red\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${errorM}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("</p>\r\n");
      out.write("\r\n");
      out.write("                        <fieldset class=\"clearfix\">\r\n");
      out.write("\r\n");
      out.write("                            <p ><span class=\"fa fa-user\"></span><input type=\"text\" name=\"email\" Placeholder=\"Email\" required></p>\r\n");
      out.write("                            <p><span class=\"fa fa-lock\"></span><input type=\"password\" name=\"password\" Placeholder=\"Password\" required></p>\r\n");
      out.write("\r\n");
      out.write("                            <div>\r\n");
      out.write("                                <span style=\"width:50%; text-align:right;  display: inline-block;\"><input type=\"submit\" value=\"Sign In\"></span>\r\n");
      out.write("                            </div>\r\n");
      out.write("\r\n");
      out.write("                        </fieldset>\r\n");
      out.write("                        <div class=\"clearfix\"></div>\r\n");
      out.write("                    </form>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"logo\">\r\n");
      out.write("                    <img src=\"https://raw.githubusercontent.com/MamounH/Logo/main/AtyponLogo-RemovedBG.png\" class=\"img img-responsive img-circle center-block\"/>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </center>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
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
}
