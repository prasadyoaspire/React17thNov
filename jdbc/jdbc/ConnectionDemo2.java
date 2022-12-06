package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo2 {

	public static void main(String[] args) {

		String driverName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/batch14db";
		String username = "batch14";
		String password = "batch14";

		Connection con = null;

		try {
			// step1 : load the driver
			Class.forName(driverName);
			System.out.println("Driver laoded");

			// step2 : establish the connection
			con = DriverManager.getConnection(url, username, password);
			System.out.println("connected");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
					System.out.println("connection closed");
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
