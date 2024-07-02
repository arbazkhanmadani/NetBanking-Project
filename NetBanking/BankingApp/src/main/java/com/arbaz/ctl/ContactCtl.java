package com.arbaz.ctl;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.ContactDto;
import com.arbaz.model.ContactMessageModel;

@WebServlet("/ContactCtl")
public class ContactCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String name = fname + " " + lname;
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String message = request.getParameter("message");

		ContactDto dto = new ContactDto();
		dto.setName(name);
		dto.setEmail(email);
		dto.setMobile(mobile);
		dto.setMessage(message);

		ContactMessageModel model = new ContactMessageModel();
		boolean flag = model.validateContactMessage(dto);
		
		if (flag) {
			HttpSession session= request.getSession();
			session.setAttribute("success",
					"Your message has been registered successfully, please wait for our response.");
			response.sendRedirect("ContactUs.jsp");
		} else {

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
