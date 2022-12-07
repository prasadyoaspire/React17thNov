package com.ecom.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ecom.dto.Product;
import com.ecom.util.DBUtil;

public class ProductDao {

	public Product getProductDetails(int productId) {
		
		Product product = null;

		try (Connection con = DBUtil.getDBConnection()) {

			String sql = "select * from product_tbl where product_id=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	public void addProduct(Product product) {

		try (Connection con = DBUtil.getDBConnection()) {
			
			String sql = "insert into product_tbl values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, product.getProductId());
			ps.setString(2, product.getProductName());
			ps.setFloat(3, product.getProductPrice());
			ps.setDate(4, Date.valueOf(product.getCreatedOn()));
			
			ps.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
