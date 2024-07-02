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


@WebServlet("/WithdrawalVerifyCtl")
public class WithdrawalVerifyCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fromaccountnumber =request.getParameter("fromaccountnumber");
		String withdrawal = request.getParameter("withdrawal");
		AdminLoginDto dto= new AdminLoginDto();
		dto.setFromAccountNumber(fromaccountnumber);
		dto.setWithdrawal(withdrawal);
		
		AdminLoginModel model= new AdminLoginModel();
		boolean flag=model.validateWithdrawal(dto);
		
		if (flag) {
			HttpSession session= request.getSession();
			session.setAttribute("fromaccountnumber", fromaccountnumber);
			request.setAttribute("fromaccountnumber", fromaccountnumber);
			request.getRequestDispatcher("WithdrawalVerify.jsp").forward(request, response);
		} else {
			request.setAttribute("invalidwithdrawal", "Withdrawal doesn't matches");
			response.sendRedirect("WithdrawalView.jsp");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
