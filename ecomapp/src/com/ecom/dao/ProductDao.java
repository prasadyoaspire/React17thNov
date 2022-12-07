package com.ecom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecom.dto.Product;

public class ProductDao {

	public Product getProductDetails(int productId) {

		// String driverName = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/batch14db";
		String username = "batch14";
		String password = "batch14";
		
		Product product = null;
		
		try (Connection con = DriverManager.getConnection(url, username, password);) {
			
			String sql = "select * from product_tbl where product_id = ? ";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int pId = rs.getInt(1);
				String pName = rs.getString(2);
				float pPrice = rs.getFloat(3);
				Date sDate = rs.getDate(4);
				
				product = new Product();
				product.setProductId(pId);
				product.setProductName(pName);
				product.setProductPrice(pPrice);
				product.setCreatedOn(sDate.toLocalDate());				
			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

}
