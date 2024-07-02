package com.arbaz.ctl;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.*;
import com.arbaz.model.*;


@WebServlet("/UserLoginSecurityChangeCtl2")
public class UserLoginSecurityChangeCtl2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String accountnumber = (String) session.getAttribute("ac");
		
		UserLoginDto dto = new UserLoginDto();
		
		dto.setQuestion(question);
		dto.setAnswer(answer);
		dto.setAccno(accountnumber);
		session.removeAttribute("ac");

		UserLoginModel model = new UserLoginModel();
		
		boolean flag = model.updateQuestionAndAnswer(dto);
		if (flag) {
			request.setAttribute("msg", "Security question and answer updated successfully");
			request.getRequestDispatcher("UserLoginView.jsp").forward(request, response);

		} else {
			request.setAttribute("msg", "Problem in updateing question");
			request.getRequestDispatcher("UserLoginView.jsp").forward(request, response);

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
