package com.arbaz.model;
import com.arbaz.dto.*;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class AdminLoginModel {
	Connection con = ConnectionProvider.getConnectivity();
	private String accountNumber = null;

	// ADMIN PASSWORD VALIDATION
	public boolean validateAdminLogin(AdminLoginDto dto) {
		PreparedStatement ps = null;
		boolean flag = false;
		try {
			ps = con.prepareStatement(
					"select adminId, AdminPassword, adminSecurityquestion,adminsecurityanswer from adminlogin where adminId=? and AdminPassword=? and adminSecurityQuestion=? and AdminSecurityanswer=?");
			ps.setString(1, dto.getAdminName());
			ps.setString(2, dto.getAdminpassword());
			ps.setString(3, dto.getSecurityquestion());
			ps.setString(4, dto.getSecurityanswer());
			ResultSet rs = ps.executeQuery();
			flag = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	// ADMIN PASSWORD CHECK PRIOR TO SECURITY QUESTION UPDATE
	public boolean changePasswordValidation(AdminLoginDto dto) {
		boolean flag = false;
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement(
					"select adminid,adminpassword from adminlogin where adminid=? and adminpassword=?");
			ps.setString(1, dto.getAdminName());
			ps.setString(2, dto.getAdminpassword());
			ResultSet rs = ps.executeQuery();
			flag = rs.next();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean updateSecurityQuestion(AdminLoginDto dto) {
		boolean flag = false;
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement(
					"update adminlogin set adminsecurityquestion=? ,adminsecurityanswer=? where adminid=?");
			ps.setString(1, dto.getSecurityquestion());
			ps.setString(2, dto.getSecurityanswer());
			ps.setString(3, dto.getAdminName());
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(flag);
		return flag;
	}

	public boolean openNewAccount(AccountOpenDto dto) {
		boolean flag = false;
		long acn = 7000220000l;
		long value = 0;
		PreparedStatement ps = null;
		FileInputStream fis1 = null;
		FileInputStream fis2 = null;
		FileInputStream fis3 = null;

		try {
			PreparedStatement p = con.prepareStatement("select max(Customernumber) from accountholderdetails");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				value = r.getLong(1);
			}
			r.close();
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			ps = con.prepareStatement(
					"insert into accountHolderdetails(name,nominee,gender,agerange,mobilenumber,emailid,country,state,city,streetname,pincode,accounttype,monthlyincome,occupation,marritalstatus,dateofbirth,aadharnumber,pancard,photo,identitycard,signature,debitcard,internetbanking,creditcard,chequebook,accountnumber) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

			String name = null;
			if (dto.getLname() == null) {
				name = dto.getFname() + " " + dto.getLname();
			} else {
				name = dto.getFname() + " " + dto.getMname() + " " + dto.getLname();
			}
			ps.setString(1, name);
			ps.setString(2, dto.getGname());
			ps.setString(3, dto.getGender());
			ps.setString(4, dto.getAge());
			ps.setString(5, dto.getMobile());
			ps.setString(6, dto.getEmail());
			ps.setString(7, dto.getCountry());
			ps.setString(8, dto.getState());
			ps.setString(9, dto.getCity());
			ps.setString(10, dto.getStreet());
			ps.setString(11, dto.getPincode());
			ps.setString(12, dto.getAccounttype());
			ps.setString(13, dto.getIncome());
			ps.setString(14, dto.getOccupation());
			ps.setString(15, dto.getMarriage());

			ps.setString(16, dto.getDob());
			ps.setString(17, dto.getAadhar());
			ps.setString(18, dto.getPan());
			System.out.println(dto.getAadhar());
			System.out.println(dto.getIdentity());
			System.out.println(dto.getSign());

			File f1 = new File("E:/Pendrive Data/bulendra s/BULENDRA/" + dto.getPhoto());
			File f2 = new File("E:/Pendrive Data/bulendra s/BULENDRA/" + dto.getIdentity());
			File f3 = new File("E:/Pendrive Data/bulendra s/BULENDRA/" + dto.getSign());

			fis1 = new FileInputStream(f1);
			fis2 = new FileInputStream(f2);
			fis3 = new FileInputStream(f3);

			ps.setBinaryStream(19, fis1);
			ps.setBinaryStream(20, fis2);
			ps.setBinaryStream(21, fis3);

			ps.setString(22, dto.getDebit());
			ps.setString(23, dto.getNet());
			ps.setString(24, dto.getCredit());
			ps.setString(25, dto.getCheque());
			acn = acn + value;
			accountNumber = "IPB" + acn;
			ps.setString(26, accountNumber);

			int i = ps.executeUpdate();
			System.out.println(i);
			if (i == 1) {
				flag = true;
				// insertintoaccountbalance(accountNumber);
				insertIntoUserLogin(accountNumber);
				insertIntoAccountBalance(accountNumber);
			} else {
				flag = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	private void insertIntoAccountBalance(String accountNumber2) {
		PreparedStatement ps = null;
		try {
			ps = con.prepareStatement("insert into accountbalance(AccountNumber) value(?)");
			ps.setString(1, accountNumber2);
			ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void insertIntoUserLogin(String accountNumber2) {
		PreparedStatement ps = null;

		try {
			ps = con.prepareStatement("insert into userlogin(Accountnumber,Mpinnumber) value(?,?)");
			ps.setString(1, accountNumber);
			ps.setInt(2, (int) (Math.random() * 1000000));
			ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean validateWithdrawal(AdminLoginDto dto) {
		boolean flag = true;
		PreparedStatement ps = null;
		String name = null;
		try {
			ps = con.prepareStatement("select name from accountholderdetails where accountnumber=?");
			ps.setString(1, dto.getFromAccountNumber());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				name = rs.getString("name");
			}
			if (name.equalsIgnoreCase(dto.getWithdrawal())) {
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
