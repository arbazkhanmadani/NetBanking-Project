package com.arbaz.ctl;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({ "/AdminLoginFilter", "/AccountOpeningForm1.jsp", "/AccountOpeningForm2.jsp", "/AccountOpeningForm3.jsp",
		"/AdminLoginAction.jsp", "/AdminPermited.jsp", "/NewAccountHolder.jsp", "/DepositView.jsp",
		"/WithdrawalView.jsp", "/PassbookPrint.jsp", "/PassbookView.jsp","/AdminHeaderView.jsp","/WithdrawalVerify.jsp" })
public class AdminLoginFilter extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		String uid = (String) session.getAttribute("uid");
		if (uid == null) {
			res.sendRedirect("AdminLoginView.jsp");
		}
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
