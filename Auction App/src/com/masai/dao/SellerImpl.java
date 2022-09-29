package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Seller;
import com.masai.utility.DButil;

public class SellerImpl implements SellerDao {

	@Override
	public String registerSeller(Seller seller) {
		String msg="Not Regiesterd..............!";
		
		
		
		try(Connection conn= DButil.provideConnection();) {
			PreparedStatement ps=conn.prepareStatement("insert into Seller (name,email,password) values(?,?,?)");
		
		         ps.setString(1,seller.getName());
		         ps.setString(2,seller.getEmail());
		         ps.setString(3, seller.getPassword());
		         
		         int x=ps.executeUpdate();
		         if(x>0) msg="Succesfully regiesterd Seller";
		} catch (SQLException e) {
			msg=e.getMessage();
		}
		return msg;
	}

}
