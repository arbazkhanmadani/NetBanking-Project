package com.arbaz.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionProvider {

	private static Connection con;

	public static Connection getConnectivity() {
		ResourceBundle rb = ResourceBundle.getBundle("com.arbaz.bundle.resource");

		if (con == null) {
			try {
				Class.forName(rb.getString("driver"));
				con = DriverManager.getConnection(rb.getString("url"), rb.getString("uid"), rb.getString("pwd"));
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
