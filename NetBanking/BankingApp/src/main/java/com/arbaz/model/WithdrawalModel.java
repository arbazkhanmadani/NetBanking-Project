package com.arbaz.model;
import com.arbaz.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;



public class WithdrawalModel {
	Connection con = ConnectionProvider.getConnectivity();

	private String withdrawal;
	public boolean flag = false;
	private double withdraw;
	private String fromaccountNumber;
	private double balance;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public boolean validateWithdrawal(AdminLoginDto dto) {
		fromaccountNumber = dto.getFromAccountNumber();
		withdrawal = dto.getWithdrawal();
		withdraw = dto.getAmount();
		flag = validateAccountHolder(fromaccountNumber, withdrawal);
		if (flag) {
			this.balance = getWithdraworBalance(fromaccountNumber);
		}
		if (balance >= withdraw) {
			flag = updateAccountBalance(fromaccountNumber, balance, withdraw);
		} else {
			flag = false;
		}
		if (flag) {
			flag = updateWidtdrawalTransaction(fromaccountNumber, balance, withdraw);
		}
		return flag;
	}

	private boolean updateWidtdrawalTransaction(String fromaccountNumber2, double balance2, double withdraw2) {
		boolean update = false;
		ps = null;
		try {
			ps = con.prepareStatement(
					"insert into transactionhistory(AccountNumber,transactiondate,Transferamount,transactionid,sendto) values(?,?,?,?,?)");

			ps.setString(1, fromaccountNumber2);
			ps.setString(2, LocalDateTime.now() + "");
			ps.setDouble(3, withdraw2);
			ps.setString(4, ("PSI" + (System.nanoTime())));
			ps.setString(5, "self");
			int i = ps.executeUpdate();
			if (i > 0) {
				update = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			update = false;
		}
		return update;
	}

	private boolean updateAccountBalance(String fromaccountNumber2, double balance2, double withdraw2) {
		boolean check = false;
		ps = null;
		try {
			ps = con.prepareStatement("update accountbalance set balance=? where accountnumber=?");
			ps.setDouble(1, balance2 - withdraw2);
			ps.setString(2, fromaccountNumber2);
			int i = ps.executeUpdate();
			if (i > 0) {
				check = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			check = false;
		}
		return check;

	}

	private double getWithdraworBalance(String fromaccountNumber2) {
		double bal = 0;
		rs = null;
		try {
			ps = con.prepareStatement("select balance from accountbalance where accountnumber=?");
			ps.setString(1, fromaccountNumber2);
			rs = ps.executeQuery();
			while (rs.next()) {
				bal = rs.getDouble("balance");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bal;
	}

	private boolean validateAccountHolder(String fromAccountNumber2, String name) {
		boolean validuser = false;
		try {
			ps = con.prepareStatement("select accountnumber from accountholderdetails where accountnumber=?");
			ps.setString(1, fromAccountNumber2);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String ac = rs.getString("accountnumber");
				System.out.println(ac);
				if (ac.equalsIgnoreCase(fromAccountNumber2)) {
					validuser = true;
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			validuser = false;
		}

		return validuser;
	}

}