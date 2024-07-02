package com.arbaz.ctl;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.AccountOpenDto;



@WebServlet("/AccountOpeningCtl1")
public class AccountOpeningCtl1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();

		session.setAttribute("fname", request.getParameter("fname"));
		session.setAttribute("mname", request.getParameter("mname"));
		session.setAttribute("lname", request.getParameter("lname"));
		session.setAttribute("gname", request.getParameter("gname"));
		session.setAttribute("gender", request.getParameter("gender"));
		session.setAttribute("age", request.getParameter("age"));
		session.setAttribute("mobile", request.getParameter("mobile"));
		session.setAttribute("email", request.getParameter("email"));
		session.setAttribute("country", request.getParameter("country"));
		session.setAttribute("state", request.getParameter("state"));
		session.setAttribute("city", request.getParameter("city"));
		session.setAttribute("street", request.getParameter("street"));
		session.setAttribute("pincode", request.getParameter("pincode"));

		AccountOpenDto d = new AccountOpenDto();
		
		d.setFname(session.getAttribute("fname")+"");
		d.setMname(session.getAttribute("mname")+"");
		d.setLname(session.getAttribute("lname").toString());
		d.setGname(session.getAttribute("gname").toString());
		d.setGender(session.getAttribute("gender").toString());
		d.setAge(session.getAttribute("age").toString());
		d.setMobile(session.getAttribute("mobile").toString());
		d.setEmail(session.getAttribute("email").toString());
		d.setCountry(session.getAttribute("country").toString());
		d.setState(session.getAttribute("state").toString());
		d.setCity(session.getAttribute("city").toString());
		d.setStreet(session.getAttribute("street").toString());
		d.setPincode(session.getAttribute("pincode").toString());
		session.setAttribute("d", d);
		request.getRequestDispatcher("AccountOpeningForm2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
