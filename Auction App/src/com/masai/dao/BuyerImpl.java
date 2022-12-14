package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.masai.bean.Buyer;
import com.masai.bean.Buyerlist;
import com.masai.bean.SellingList;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.SellerException;
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

	@Override
	public  List<SellingList> viewbuyingList(String prop) throws SellerException {
		List<SellingList> list = new ArrayList<>();
		
	try(Connection conn= DButil.provideConnection()){
		
	PreparedStatement ps =conn.prepareStatement("select * from sellItem where property=?");
		 
	             ps.setString(1, prop);
                  ResultSet rs= ps.executeQuery();
                  
                  while(rs.next()) {
                	  int itemId= rs.getInt("itemId");
               	   String property=rs.getString("property");
               	   int price=rs.getInt("price");
               	   int quntity=rs.getInt("quntity");
               	   String location=rs.getString("location");
               	   int sellingId=rs.getInt("sellingId");
               	   String status= rs.getString("status");
               	   
               	   
               	   SellingList sl= new SellingList(itemId,property,price,quntity,location,sellingId,status);
                  list.add(sl);
                	  
                  }
                 if(list.size()==0) throw new SellerException("No Record Found");
		
	} catch (SQLException e) {
		
	     throw new SellerException(e.getMessage());
	}
		
		
		
		return list;
	}

	@Override
	public String buyItem(int buyerid, int itemid) throws SellerException, BuyerException {
		String msg= "Not inserted";
		
		try(Connection conn= DButil.provideConnection()){
		PreparedStatement ps1=	conn.prepareStatement("select * from buyer where bid=? ");
			ps1.setInt(1, buyerid);
			
			ResultSet rs =ps1.executeQuery();
			if(rs.next())
			{
				
					PreparedStatement ps2=	conn.prepareStatement("select * from  sellitem where itemid=?");
					ps2.setInt(1, itemid);
				    ResultSet rs1=	ps2.executeQuery();
				    SellerDao sd= new SellerImpl();
				     if(rs1.next()) 
				     {
				    	 if(rs1.getInt("quntity")>0) 
				    	 {
				    	   PreparedStatement ps3=	conn.prepareStatement("insert into buylist values(?,?)");
							ps3.setInt(1, buyerid);
							ps3.setInt(2, itemid);
							
							int x=ps3.executeUpdate();
							if(x>0) msg="Item Purchased";
						   sd.updateQuntity(itemid);
				         }else {
				        	 sd.updateStatus(itemid);
				         }
				   
				}else throw new BuyerException("Technical Error");
				
			}else throw new SellerException("Item not exist") ;
			
		} catch (SQLException e) {
			
		   throw new BuyerException(e.getMessage());
		
		}
		
		
		return msg;
	}

	@Override
	public List<Buyerlist> viewBuyerList()
			throws BuyerException {
		List<Buyerlist> list =new ArrayList<>();
		
		
		try(Connection conn= DButil.provideConnection()){
			
	PreparedStatement ps	=	conn.prepareStatement("select b.bid, b.name,b.email, s.property, s.price ,s.location  "
					+ " from  Buyer b INNER JOIN sellitem s INNER JOIN"
					+ " buylist bl ON b.bid = bl.buyerid AND s.itemid = bl.itemid");
			
	     ResultSet rs =ps.executeQuery();
	     while(rs.next()) {
	    	 
	    	 int buyId= rs.getInt("bid");
	    	String buyname= rs.getString("name");
	    	 String buyemail= rs.getString("email");
	    	 String sprop= rs.getString("property");
	    	 int sprice= rs.getInt("price");
	    	 String location= rs.getString("location");
	    	 
	    	 Buyerlist by= new Buyerlist(buyId,buyname,buyemail,sprop,sprice,location);
	    	 list.add(by);
//	    	 
	     }
	     if(list.size()==0) throw new BuyerException("No Record Found");
			
		} catch (SQLException e) {
			
			throw new BuyerException(e.getMessage());
		}
		
		return list;
	}

	@Override
	public void createDispute(String name, String issue) {
		
		
		
		try(Connection conn= DButil.provideConnection()){
			
		PreparedStatement ps =conn.prepareStatement("Insert into dispute values(?,?)");
		ps.setString(1, name);
		ps.setString(2, issue);
		  int x= ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}

	
	
	
}
