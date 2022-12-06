package jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class PreparedStatementDemo {

	public static void main(String[] args) {

		// String driverName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/batch14db";
		String username = "batch14";
		String password = "batch14";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter productId:");
		int productId = sc.nextInt();
		System.out.println("Enter product Name:");
		String productName = sc.next();
		System.out.println("Enter product price:");
		float productPrice = sc.nextFloat();
		System.out.println("Enter product date:(yyyy-MM-dd)");
		String dateString = sc.next();
		
		//convert string date to LocalDate 
		LocalDate productDate = LocalDate.parse(dateString);
		
		sc.close();

		try (Connection con = DriverManager.getConnection(url, username, password);) {

			String sql = "insert into product_tbl values(?,?,?,?)";

			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			ps.setString(2, productName);
			ps.setFloat(3, productPrice);
			ps.setDate(4, Date.valueOf(productDate));

			ps.executeUpdate();
			System.out.println("Product Saved.");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
