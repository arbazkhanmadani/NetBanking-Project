package com.arbaz.ctl;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.AccountOpenDto;
import com.arbaz.model.AdminLoginModel;


@WebServlet("/AccountOpeningCtl3")
public class AccountOpeningCtl3 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		HttpSession session= request.getSession();
		
		session.setAttribute("debitcard", request.getParameter("debitcard"));
		session.setAttribute("netbanking", request.getParameter("netbanking"));
		session.setAttribute("creditcard", request.getParameter("creditcard"));
		session.setAttribute("cheque", request.getParameter("cheque"));
		session.setAttribute("agree", request.getParameter("agree"));
		

		AccountOpenDto d=  (AccountOpenDto) session.getAttribute("d");
		d.setDebit(session.getAttribute("debitcard").toString());
		d.setCredit(session.getAttribute("creditcard").toString());
		d.setNet(session.getAttribute("netbanking").toString());
		d.setCheque(session.getAttribute("cheque").toString());
		d.setAgree(session.getAttribute("agree").toString());
		
		AdminLoginModel model= new AdminLoginModel();
		boolean flag= model.openNewAccount(d);
		request.setAttribute("msg", "account opened successfully");
		
		session.removeAttribute("fname");
		session.removeAttribute("mname");
		session.removeAttribute("fname");
		session.removeAttribute("gname");
		session.removeAttribute("gender");
		session.removeAttribute("age");
		session.removeAttribute("mobile");
		session.removeAttribute("email");
		session.removeAttribute("country");
		session.removeAttribute("state");
		session.removeAttribute("city");
		session.removeAttribute("street");
		session.removeAttribute("pincode");
		session.removeAttribute("accounttype");
		session.removeAttribute("occupation");
		session.removeAttribute("marriage");
		session.removeAttribute("dob");
		session.removeAttribute("ac");
		session.removeAttribute("pc");
		session.removeAttribute("photo");
		session.removeAttribute("identity");
		session.removeAttribute("sign");
		session.removeAttribute("debitcard");
		session.removeAttribute("netbanking");
		session.removeAttribute("creditcard");
		session.removeAttribute("cheque");
		session.removeAttribute("agree");
		
		request.getRequestDispatcher("AdminLoginAction.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
