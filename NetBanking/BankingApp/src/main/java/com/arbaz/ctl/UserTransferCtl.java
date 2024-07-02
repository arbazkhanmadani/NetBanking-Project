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



@WebServlet("/UserTransferCtl")
public class UserTransferCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String accountNumber= request.getParameter("ac");
		double amount= Double.parseDouble(request.getParameter("amount"));
		
		UserLoginDto dto= new UserLoginDto();
		dto.setAccno(accountNumber);
		dto.setAmount(amount);
		HttpSession session= request.getSession();
		String selfaccountnumber=(String)session.getAttribute("userid");
		dto.setSelfAccountNumber(selfaccountnumber);
		UserLoginModel model= new UserLoginModel();
		boolean flag=model.transferAmount(dto);
		
		if (flag) {
			request.setAttribute("msg", "Transferred successfully");
			request.getRequestDispatcher("Transfer.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Transaction failed");
			request.getRequestDispatcher("Transfer.jsp").forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
