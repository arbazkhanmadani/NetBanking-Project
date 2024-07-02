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


@WebServlet("/SecurityQuestionChangeCtl")
public class SecurityQuestionChangeCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String uid = request.getParameter("adminId");
		String pwd = request.getParameter("adminpassword");
		
		request.setAttribute("uid", uid);
		response.sendRedirect("AdminQuestionUpdate.java");
		AdminLoginDto dto = new AdminLoginDto();
		dto.setAdminName(uid);
		dto.setAdminpassword(pwd);

		AdminLoginModel model = new AdminLoginModel();
		boolean flag = model.changePasswordValidation(dto);
		
		if (flag) {
			HttpSession session= request.getSession();
			session.setAttribute("uid", uid);
			session.setMaxInactiveInterval(60);
			response.sendRedirect("SecurityQuestionUpdate.jsp");
			
			} else {
			request.setAttribute("error", "Invalid User");
			RequestDispatcher rd= request.getRequestDispatcher("AdminLoginView.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
