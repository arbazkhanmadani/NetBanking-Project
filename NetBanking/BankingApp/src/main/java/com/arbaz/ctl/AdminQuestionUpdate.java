package com.arbaz.ctl;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.*;
import com.arbaz.model.*;
@WebServlet("/AdminQuestionUpdate")
public class AdminQuestionUpdate extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String question = request.getParameter("securityquestion");
		String answer = request.getParameter("securityanswer");
		String adminid = request.getParameter("uid");

		AdminLoginDto dto = new AdminLoginDto();
		dto.setSecurityquestion(question);
		dto.setSecurityanswer(answer);
		dto.setAdminName(adminid);

		AdminLoginModel model = new AdminLoginModel();
		boolean flag = model.updateSecurityQuestion(dto);
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("valid", "Changed successfully");
			session.setMaxInactiveInterval(60);
			response.sendRedirect("AdminLoginView.jsp");

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
