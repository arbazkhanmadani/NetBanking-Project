package com.arbaz.model;
import com.arbaz.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;


public class DepositModel {
	Connection con = ConnectionProvider.getConnectivity();
	double balance = 0;
	double deposit;
	String depositor;
	boolean flag = false;
	String accountNumber;

	public boolean validateDeposit(AdminLoginDto dto) {

		PreparedStatement ps = null;
		depositor = dto.getDepositor();
		deposit = dto.getAmount();
		accountNumber = dto.getAccountnumber();

		try {
			ps = con.prepareStatement("select balance from accountbalance where accountnumber=?");
			ps.setString(1, dto.getAccountnumber());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble("balance");
			}
			

			flag = deposit(accountNumber, deposit, balance, depositor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private boolean deposit(String accountNumber, double depositamount, double balance, String depositor) {
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("Update accountbalance set balance=? where accountnumber=?");
			ps.setDouble(1, depositamount + balance);
			ps.setString(2, accountNumber);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		ps = null;
		try {

			ps = con.prepareStatement(
					"insert into transactionhistory(accountnumber, transactiondate,RecieveAmount,TransactionId,RecievedFrom) values(?,?,?,?,?)");
			ps.setString(1, accountNumber);
			ps.setString(2, LocalDateTime.now() + "");
			ps.setDouble(3, depositamount);
			ps.setString(4, ("PSI" + (System.nanoTime())));
			ps.setString(5, depositor);
			int i = ps.executeUpdate();
			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

}
