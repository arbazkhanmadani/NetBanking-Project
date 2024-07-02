package com.arbaz.ctl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.AccountOpenDto;


@WebServlet("/AccountOpeningCtl2")
public class AccountOpeningCtl2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	HttpSession session= request.getSession();
	session.setAttribute("accounttype", request.getParameter("accounttype"));
	session.setAttribute("income", request.getParameter("income"));
	session.setAttribute("occupation", request.getParameter("occupation"));
	session.setAttribute("marriage", request.getParameter("marriage"));
	session.setAttribute("dob", request.getParameter("dob"));
	session.setAttribute("ac", request.getParameter("ac"));
	session.setAttribute("pc", request.getParameter("pc"));
	session.setAttribute("photo", request.getParameter("photo"));
	session.setAttribute("identity", request.getParameter("identity"));
	session.setAttribute("sign", request.getParameter("sign"));	
	
	
	AccountOpenDto d= (AccountOpenDto) session.getAttribute("d");
	
	d.setAccounttype(session.getAttribute("accounttype").toString());
	d.setIncome(session.getAttribute("income").toString());
	d.setOccupation(session.getAttribute("occupation").toString());
	d.setMarriage(session.getAttribute("marriage").toString());
	d.setDob(session.getAttribute("dob").toString());
	d.setAadhar(session.getAttribute("ac").toString());
	d.setPan(session.getAttribute("pc").toString());
	d.setPhoto( session.getAttribute("photo").toString());
	
	d.setIdentity(session.getAttribute("identity").toString());
	d.setSign( session.getAttribute("sign").toString());
	
	System.out.println(session.getAttribute("photo"));
	session.setAttribute("d", d);
	request.getRequestDispatcher("AccountOpeningForm3.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
