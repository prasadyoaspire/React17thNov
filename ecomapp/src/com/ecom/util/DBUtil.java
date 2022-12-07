package com.ecom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	// String driverName = "org.postgresql.Driver";
	static final String URL = "jdbc:postgresql://localhost:5432/batch14db";
	static final String USERNAME = "batch14";
	static final String PASSWORD = "batch14";

	public static Connection getDBConnection() {
		Connection con = null;

		try {
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
