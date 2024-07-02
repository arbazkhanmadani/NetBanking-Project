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




@WebServlet("/UserLoginSecurityChangeCtl1")
public class UserLoginSecurityChangeCtl1 extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String accountnumber= request.getParameter("ac");
			String mpin= request.getParameter("mpin");
			UserLoginDto dto= new UserLoginDto();
			dto.setAccno(accountnumber);
			dto.setMpin(Integer.parseInt(mpin));
			HttpSession session= request.getSession();
			session.setAttribute("ac", accountnumber);
			
			UserLoginModel model= new UserLoginModel();
			boolean flag= model.verifyValidUser(dto);
			if (flag) {
				request.setAttribute("msg", "Change your security question");
				request.getRequestDispatcher("UserLoginSecurityChangeView2.jsp").forward(request, response);;
			} else {
				request.setAttribute("msg", "Account number or mpin number is invalid");
				request.getRequestDispatcher("UserLoginSecurityChangeView1.jsp").forward(request, response);;
			}
			
		}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
