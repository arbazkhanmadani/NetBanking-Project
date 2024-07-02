package com.arbaz.ctl;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.model.*;
import com.arbaz.dto.*;

@WebServlet("/AdminLoginCtl")
public class AdminLoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		String question = request.getParameter("securityquestion");
		String answer = request.getParameter("securityanswer");

		AdminLoginDto adto = new AdminLoginDto();
		adto.setAdminName(uid);
		adto.setAdminpassword(pwd);
		adto.setSecurityquestion(question);
		adto.setSecurityanswer(answer);

		AdminLoginModel model = new AdminLoginModel();
		boolean flag = model.validateAdminLogin(adto);
		if (flag) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(180);
			session.setAttribute("uid", uid);
			response.sendRedirect("AdminLoginAction.jsp");
		} else {
			request.setAttribute("error", "Invalid User");
			RequestDispatcher rd = request.getRequestDispatcher("AdminLoginView.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
