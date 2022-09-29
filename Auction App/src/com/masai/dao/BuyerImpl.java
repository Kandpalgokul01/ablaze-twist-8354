package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.masai.bean.Buyer;
import com.masai.utility.DButil;

public class BuyerImpl implements Buyerdao {

	@Override
	public String registerBuyer(Buyer buyer) {
		String msg="Not Registerd........!";
		
		Connection conn=DButil.provideConnection();
		try {
			PreparedStatement ps= conn.prepareStatement
					("insert into Buyer(name,email,password) values(?,?,?)");
			
			ps.setString(1,buyer.getName());
			ps.setString(2,buyer.getEmail());
			ps.setString(3, buyer.getPassword());
		int x=	ps.executeUpdate();
		if(x>0) msg="Buyer Registerd Succesfully";
		
			
		} catch (SQLException e) {
			
			msg=e.getMessage();
		}
		
		
		
		
		
		return msg;
	}

	
	
	
}
