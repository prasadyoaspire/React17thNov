package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo3 {

	public static void main(String[] args) {
		
		//String driverName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/batch14db";
		String username = "batch14";
		String password = "batch14";		

		try(Connection con = DriverManager.getConnection(url, username, password);) {					
			System.out.println("connected");

		} catch (SQLException e) {
			e.printStackTrace();
		} 	
	}

}
