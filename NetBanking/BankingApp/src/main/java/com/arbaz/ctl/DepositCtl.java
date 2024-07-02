package com.arbaz.ctl;


import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.arbaz.dto.*;
import com.arbaz.model.*;

@WebServlet("/DepositCtl")
public class DepositCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String accountnumber = request.getParameter("accountnumber");
		double amount = Double.parseDouble(request.getParameter("amount"));
		String depositor = request.getParameter("depositor");

		AdminLoginDto dto = new AdminLoginDto();
		dto.setAccountnumber(accountnumber);
		dto.setAmount(amount);
		dto.setDepositor(depositor);

		DepositModel model = new DepositModel();
		boolean flag = model.validateDeposit(dto);
		if (flag) {
			request.setAttribute("msg", "Amount deposited successfully");
			request.getRequestDispatcher("DepositView.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "Problem in depositing amount");
			request.getRequestDispatcher("DepositView.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
