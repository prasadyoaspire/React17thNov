package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectDemo {

	public static void main(String[] args) {

		// String driverName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/batch14db";
		String username = "batch14";
		String password = "batch14";

		try (Connection con = DriverManager.getConnection(url, username, password);) {
			// perform db operations
			String sql = "select * from product_tbl";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				int productId = rs.getInt(1);
				String productName = rs.getString("product_name");
				float productPrice = rs.getFloat(3);
				System.out.println(productId+ " "+productName+" "+productPrice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
