package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertDemo {

	public static void main(String[] args) {

		// String driverName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/batch14db";
		String username = "batch14";
		String password = "batch14";

		try (Connection con = DriverManager.getConnection(url, username, password);) {
			// perform db operations
			String sql = "insert into product_tbl values(1005,'IPhoneX+',88000,'2022-12-06')";
			Statement st = con.createStatement();
			st.executeUpdate(sql); //insertion, updation and deletion - executeUpdate
			System.out.println("Product saved");
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
