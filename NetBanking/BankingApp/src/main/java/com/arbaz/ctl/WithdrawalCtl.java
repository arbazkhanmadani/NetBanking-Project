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


@WebServlet("/WithdrawalCtl")
public class WithdrawalCtl extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String fromaccountnumber = (String) session.getAttribute("fromaccountnumber");
		;
		double amount = Double.parseDouble((String) request.getParameter("amount"));

		session.removeAttribute("fromaccountnumber");
		AdminLoginDto dto = new AdminLoginDto();
		dto.setFromAccountNumber(fromaccountnumber);
		dto.setAmount(amount);

		WithdrawalModel model = new WithdrawalModel();
		boolean flag = model.validateWithdrawal(dto);
		if (flag) {
			request.setAttribute("msg", "Amount withdrawal successfully");
			request.getRequestDispatcher("WithdrawalView.jsp").forward(request, response);
		} else {
			request.setAttribute("msg", "In sufficient amount");
			request.getRequestDispatcher("WithdrawalView.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
