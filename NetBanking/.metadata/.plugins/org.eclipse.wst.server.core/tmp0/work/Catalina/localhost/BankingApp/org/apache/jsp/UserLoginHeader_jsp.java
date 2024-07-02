/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.65
 * Generated at: 2023-09-05 18:02:04 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class UserLoginHeader_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>User Login Header</title>\r\n");
      out.write("<link rel='stylesheet' type='text/css' media='screen'\r\n");
      out.write("	href='headerstyle.css'>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js\"\r\n");
      out.write("	integrity=\"sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script\r\n");
      out.write("	src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js\"\r\n");
      out.write("	integrity=\"sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk\"\r\n");
      out.write("	crossorigin=\"anonymous\"></script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	<center>\r\n");
      out.write("		<img alt=\"Logo\" src=\"Images/payall.png\" height=\"80px\" width=\"120px\">\r\n");
      out.write("		<ul class=\"nav-links\">\r\n");
      out.write("			<li class=\"center\"><a href=\"UserLoginAction.jsp\"><svg\r\n");
      out.write("						xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"\r\n");
      out.write("						fill=\"currentColor\" class=\"bi bi-house-heart\" viewBox=\"0 0 16 16\">\r\n");
      out.write("  <path\r\n");
      out.write("							d=\"M8 6.982C9.664 5.309 13.825 8.236 8 12 2.175 8.236 6.336 5.309 8 6.982Z\" />\r\n");
      out.write("  <path\r\n");
      out.write("							d=\"M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.707L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.646a.5.5 0 0 0 .708-.707L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z\" />\r\n");
      out.write("</svg></i>Home</a></li>\r\n");
      out.write("			<li class=\"center\"><a href=\"UserTransactionPassbook.jsp\"><svg\r\n");
      out.write("						xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"\r\n");
      out.write("						fill=\"currentColor\" class=\"bi bi-wallet-fill\" viewBox=\"0 0 16 16\">\r\n");
      out.write("  <path\r\n");
      out.write("							d=\"M1.5 2A1.5 1.5 0 0 0 0 3.5v2h6a.5.5 0 0 1 .5.5c0 .253.08.644.306.958.207.288.557.542 1.194.542.637 0 .987-.254 1.194-.542.226-.314.306-.705.306-.958a.5.5 0 0 1 .5-.5h6v-2A1.5 1.5 0 0 0 14.5 2h-13z\" />\r\n");
      out.write("  <path\r\n");
      out.write("							d=\"M16 6.5h-5.551a2.678 2.678 0 0 1-.443 1.042C9.613 8.088 8.963 8.5 8 8.5c-.963 0-1.613-.412-2.006-.958A2.679 2.679 0 0 1 5.551 6.5H0v6A1.5 1.5 0 0 0 1.5 14h13a1.5 1.5 0 0 0 1.5-1.5v-6z\" />\r\n");
      out.write("</svg>Transactions</a></li>\r\n");
      out.write("\r\n");
      out.write("			<li class=\"center\"><a href=\"Transfer.jsp\"><svg\r\n");
      out.write("						xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"\r\n");
      out.write("						fill=\"currentColor\" class=\"bi bi-person-lines-fill\"\r\n");
      out.write("						viewBox=\"0 0 16 16\">\r\n");
      out.write("  <path\r\n");
      out.write("							d=\"M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z\" />\r\n");
      out.write("</svg>Transfer</a></li>\r\n");
      out.write("\r\n");
      out.write("			<!-- <li class=\"center\"><a href=\"Favorite.jsp\"><svg\r\n");
      out.write("						xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"\r\n");
      out.write("						fill=\"currentColor\" class=\"bi bi-person-lines-fill\"\r\n");
      out.write("						viewBox=\"0 0 16 16\">\r\n");
      out.write("  <path\r\n");
      out.write("							d=\"M6 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm-5 6s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H1zM11 3.5a.5.5 0 0 1 .5-.5h4a.5.5 0 0 1 0 1h-4a.5.5 0 0 1-.5-.5zm.5 2.5a.5.5 0 0 0 0 1h4a.5.5 0 0 0 0-1h-4zm2 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2zm0 3a.5.5 0 0 0 0 1h2a.5.5 0 0 0 0-1h-2z\" />\r\n");
      out.write("</svg>Favourite</a></li> -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("			");

			String accountnumber = (String) session.getAttribute("userid");
			if (accountnumber != null) {
			
      out.write("\r\n");
      out.write("			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("			<h5 style=\"color: blue; float: right;\">\r\n");
      out.write("				");
      out.print(accountnumber);
      out.write("</h5>\r\n");
      out.write("			");

			}
			
      out.write("\r\n");
      out.write("			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n");
      out.write("			<h5>\r\n");
      out.write("				<script>\r\n");
      out.write("					function display_ct5() {\r\n");
      out.write("						var x = new Date()\r\n");
      out.write("						var ampm = x.getHours() >= 12 ? ' PM' : ' AM';\r\n");
      out.write("\r\n");
      out.write("						var x1 = x.getMonth() + 1 + \"-\" + x.getDate() + \"-\"\r\n");
      out.write("								+ x.getFullYear();\r\n");
      out.write("						x1 = \"\" + x.getHours() + \"H \" + \":\" + x.getMinutes()\r\n");
      out.write("								+ \"M \" + \":\" + x.getSeconds() + \"s \" + \"\" + \":\"\r\n");
      out.write("								+ ampm;\r\n");
      out.write("						document.getElementById('ct5').innerHTML = x1;\r\n");
      out.write("						display_c5();\r\n");
      out.write("					}\r\n");
      out.write("					function display_c5() {\r\n");
      out.write("						var refresh = 1000; // Refresh rate in milli seconds\r\n");
      out.write("						mytime = setTimeout('display_ct5()', refresh)\r\n");
      out.write("					}\r\n");
      out.write("					display_c5()\r\n");
      out.write("				</script>\r\n");
      out.write("				<span id='ct5' style=\"color: green;\"></span>\r\n");
      out.write("			</h5>\r\n");
      out.write("			<li class=\"center\"><a href=\"AdminLoginView.jsp\"><svg\r\n");
      out.write("						xmlns=\"http://www.w3.org/2000/svg\" width=\"16\" height=\"16\"\r\n");
      out.write("						fill=\"currentColor\" class=\"bi bi-file-person\" viewBox=\"0 0 16 16\">\r\n");
      out.write("  <path\r\n");
      out.write("							d=\"M12 1a1 1 0 0 1 1 1v10.755S12 11 8 11s-5 1.755-5 1.755V2a1 1 0 0 1 1-1h8zM4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4z\" />\r\n");
      out.write("  <path d=\"M8 10a3 3 0 1 0 0-6 3 3 0 0 0 0 6z\" />\r\n");
      out.write("</svg>\r\n");
      out.write("					<h5 style=\"color: red;\">Logout</h5></a></li>\r\n");
      out.write("		</ul>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	</center>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}