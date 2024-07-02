package com.arbaz.model;
import com.arbaz.dto.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;



public class UserLoginModel {
	private String accountnumber = null;
	private int mpin = 0;
	private String question = null;
	private String answer = null;
	Boolean flag = false;
	Connection con = ConnectionProvider.getConnectivity();

	public boolean validateUserLogin(UserLoginDto dto) {
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("select * from userlogin where accountnumber=?");
			ps.setString(1, dto.getAccno());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				mpin = rs.getInt(2);
				question = rs.getString(3);
				answer = rs.getString(4);
			}
			if (mpin == dto.getMpin() && question.equalsIgnoreCase(dto.getQuestion())
					&& answer.equalsIgnoreCase(dto.getAnswer())) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		System.out.println(flag);
		return flag;
	}

	public boolean verifyValidUser(UserLoginDto dto) {
		boolean flag = false;

		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("select accountnumber, mpinnumber from userlogin where accountnumber=?");
			ps.setString(1, dto.getAccno());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				accountnumber = rs.getString("accountnumber");
				mpin = rs.getInt("mpinnumber");
			}
			if (mpin == dto.getMpin() && accountnumber.equalsIgnoreCase(accountnumber)) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	// Update question and answer as a security in user

	public boolean updateQuestionAndAnswer(UserLoginDto dto) {
		boolean flag = false;
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"update userlogin set securityquestion=? , securityanswer=? where accountnumber=?");
			ps.setString(1, dto.getQuestion());
			ps.setString(2, dto.getAnswer());
			ps.setString(3, dto.getAccno());
			int i = ps.executeUpdate();

			if (i > 0) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	// Method to check the valid account number for recipient
	public boolean transferAmount(UserLoginDto dto) {
		boolean flag = false;
		PreparedStatement ps = null;
		String accountNumber = dto.getAccno();
		String selfaccountnumber = dto.getSelfAccountNumber();
		try {
			ps = con.prepareStatement("select accountnumber from accountbalance where accountnumber=?");
			ps.setString(1, dto.getAccno());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if (rs.getString(1).equalsIgnoreCase(accountNumber)) {
					double balance = getAccountBalance(selfaccountnumber, dto.getAmount(), dto.getAccno());
					flag = true;
				} else {
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}

	// checking balance and deducting amount
	private double getAccountBalance(String accountnumber, double amount, String recipientaccountnumber) {
		PreparedStatement ps = null;
		PreparedStatement p = null;
		double balance = 0;
		try {
			ps = con.prepareStatement("select balance from accountbalance where accountNumber=?");
			ps.setString(1, accountnumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				balance = rs.getDouble("balance");
			}
			if (balance >= amount) {
				p = con.prepareStatement("update accountbalance set balance=? where accountnumber=?");
				p.setDouble(1, balance - amount);
				p.setString(2, accountnumber);
				p.executeUpdate();
				updateAccountBalance(recipientaccountnumber, amount, accountnumber);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return balance;
	}

	// Method to update account balance into recipient account
	private void updateAccountBalance(String raccountnumber, double balance, String selfaccountNumber) {
		PreparedStatement ps = null;
		PreparedStatement p = null;
		double bal = 0.0;
		try {
			ps = con.prepareStatement("Select balance from accountbalance where accountnumber=?");
			ps.setString(1, raccountnumber);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				bal = rs.getDouble("balance");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			p = con.prepareStatement("update accountbalance set balance=? where accountnumber=?");
			p.setDouble(1, bal + balance);
			p.setString(2, raccountnumber);
			p.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		int i = ((int) Math.random() * 100000000);
		String ti = "" + i + "";
		String td = LocalDateTime.now() + "";
		try {

			ps = null;
			ps = con.prepareStatement(
					"insert into transactionhistory(AccountNumber, transactiondate,TransferAmount,TransactionId,sendto) values(?,?,?,?,?)");
			ps.setString(1, selfaccountNumber);
			ps.setString(2, td);
			ps.setDouble(3, balance);
			ps.setString(4, ti);
			ps.setString(5, "*********" + raccountnumber.substring(7, 13));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ps = null;
			ps = con.prepareStatement(
					"insert into transactionhistory(AccountNumber, transactiondate,RecieveAmount,TransactionId,RecievedFrom) values(?,?,?,?,?)");
			ps.setString(1, raccountnumber);
			ps.setString(2, td);
			ps.setDouble(3, balance);
			ps.setString(4, ti);
			ps.setString(5, "*********" + selfaccountNumber.substring(7, 13));
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList transactionHistory(UserLoginDto dto) {
		ArrayList al = new ArrayList<>();
		PreparedStatement ps = null;
		UserLoginDto dt = new UserLoginDto();
		String trans = null;
		try {
			ps = con.prepareStatement("select * from transactionHistory where accountNumber=?");
			ps.setString(1, dto.getAccno());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				trans = rs.getString(1) + "|\t" + rs.getString(2) + "|\t" + rs.getString(3) + "|\t" + rs.getString(4)
						+ "|\t" + rs.getString(5) + "|\t" + rs.getString(6) + "|\t" + rs.getString(7) + "|\n";
				al.add(trans);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return al;
	}

	/*
	 * public boolean generatePdf(UserLoginDto dto) {
	 * 
	 * boolean flag = false; PreparedStatement ps = null; String fileName =
	 * "D:\\" + dto.getAccno() + ".pdf"; Document document = new Document(); int
	 * count=0; try { PdfWriter.getInstance(document, new
	 * FileOutputStream(fileName)); ps = con.
	 * prepareStatement("select * from transactionhistory where accountnumber='?'");
	 * ps.setString(1, dto.getAccno()); ResultSet rs = ps.executeQuery();
	 * document.open(); PdfPTable table = new PdfPTable(7);
	 * 
	 * table.addCell("Account Number"); table.addCell("Date");
	 * table.addCell("Withdrawal"); table.addCell("Deposit");
	 * table.addCell("Transaction Id"); table.addCell("Recieved From");
	 * table.addCell("Send to"); table.setHeaderRows(1); while (rs.next()) {
	 * table.addCell(rs.getString(1)); table.addCell(rs.getString(2));
	 * table.addCell(rs.getDouble(3) + ""); table.addCell(rs.getDouble(4) + "");
	 * table.addCell(rs.getString(5)); table.addCell(rs.getString(6));
	 * table.addCell(rs.getString(7)); count++; }
	 * 
	 * document.add(table); document.close();
	 * 
	 * } catch (Exception e) { e.printStackTrace(); }
	 * System.out.println("finsished"); if (count>0) { flag=true; } else {
	 * flag=false; } return flag; }
	 */
}
