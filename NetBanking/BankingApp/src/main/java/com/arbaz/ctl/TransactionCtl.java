package com.arbaz.ctl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.*;
import com.arbaz.model.*;


@WebServlet("/TransactionCtl")
public class TransactionCtl extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		UserLoginDto dto= new UserLoginDto();
		HttpSession session=request.getSession();
		dto.setAccno((String)session.getAttribute("userid"));
		
		UserLoginModel model= new UserLoginModel();
		ArrayList<String> al= new ArrayList<String>();
		al=model.transactionHistory(dto);
		request.setAttribute("transactions", al);
		request.getRequestDispatcher("UserTransactions.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
