package com.arbaz.ctl;
import com.arbaz.dto.*;
import com.arbaz.model.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet("/UserLoginCtl")
public class UserLoginCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String accnumber = request.getParameter("ac");
		String mpin = request.getParameter("mpin");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		UserLoginDto dto = new UserLoginDto();
		dto.setAccno(accnumber);
		dto.setMpin(Integer.parseInt(mpin));
		dto.setQuestion(question);
		dto.setAnswer(answer);

		UserLoginModel model = new UserLoginModel();
		boolean flag = model.validateUserLogin(dto);
		if (flag) {
			HttpSession session = request.getSession();
			session.setAttribute("userid", accnumber);
			session.setMaxInactiveInterval(150);
			request.getRequestDispatcher("UserLoginAction.jsp").forward(request, response);

		} else {
			request.setAttribute("loginfail", "Wrong/Invalid credential");
			request.getRequestDispatcher("UserLoginView.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
