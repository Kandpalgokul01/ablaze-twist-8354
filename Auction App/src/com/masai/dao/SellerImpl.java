package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.bean.Seller;
import com.masai.bean.SellingList;
import com.masai.exceptions.SellerException;
import com.masai.utility.DButil;

public class SellerImpl implements SellerDao  {

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

	@Override
	public String addItem(int sellerid,int itemId,String property,int price,int quntity,String location) throws SellerException{
		String msg="Not Added";
		
		try(Connection conn= DButil.provideConnection()){
		PreparedStatement ps =conn.prepareStatement("select * from seller where sid=?");
		
		    ps.setInt(1, sellerid);
		    ResultSet rs=ps.executeQuery();
		    	    
		    if(rs.next()==true) {
		    	
		    
		    		PreparedStatement ps2=conn.prepareStatement("Insert into sellitem values(?,?,?,?,?,?,?)");
		    	    ps2.setInt(1, itemId);
		    	    ps2.setString(2, property);
		    	    ps2.setInt(3, price);
		    	    ps2.setInt(4, quntity);
		    	    
		    	    ps2.setString(5, location);
		    	    ps2.setInt(6, sellerid);
		    	    ps2.setString(7, "Available");

		    	   int x= ps2.executeUpdate();
		    	   
		    	   if(x>0) {
		    		msg="Item updated on the Selling item list";
		    	   }
		    	   
		    }else {
		    	throw new SellerException("Seller Record not found, To Add on selling list please add your correct selling id.....");
		    }
		    
			
			
		} catch (Exception e) {
			
			throw new SellerException(e.getMessage());
		}
		
		
		
		
		return msg;
	}

	@Override
	public String updateItem(String prop,int price,int quntity,int itemId) throws SellerException {
	    String msg="Not updated...........";
	    
	           
	    try(Connection conn=DButil.provideConnection()){
	    	PreparedStatement ps=conn.prepareStatement("update sellitem set property=?, price=?, quntity=?  where itemId=?");
	    	       
	                
	                ps.setString(1, prop);
	                ps.setInt(2, price);
	                ps.setInt(3, quntity);
	                ps.setInt(4, itemId);
	               int x= ps.executeUpdate();
	               if (x>0) msg= "Record updated succesfully";
	                
	    } catch (SQLException e) {
			
			throw new SellerException(e.getMessage());
		}
	    
	    
	    
	    
	    
		return msg;
	}

	@Override
	public String removeItem(int itemid) throws SellerException {
		String msg="Item not found";
		
		
		
	                   try (Connection conn= DButil.provideConnection()) {
							PreparedStatement  ps = conn.prepareStatement("delete from sellItem where itemid=?");
						     ps.setInt(1,itemid);
						  int x= ps.executeUpdate() ; 
						  
						  if(x>0) msg= "Record deleted succesfully";
						 
						  
						  
	                   } catch (SQLException e) {
							
							throw new SellerException(e.getMessage());
						}
		
		
		
		return msg;
	}

	@Override
	public List<SellingList> viewSolditemDetail() throws SellerException {
		List<SellingList> list= new ArrayList<>();
		
		try(Connection conn=DButil.provideConnection()){
		
		PreparedStatement ps	=conn.prepareStatement("select * from sellItem where status =?");
		ps.setString(1,"sold");
		ResultSet rs=	ps.executeQuery();
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
	public void updateQuntity(int itemid) throws SellerException {
		
		try(Connection conn=DButil.provideConnection()){
	    	PreparedStatement ps=conn.prepareStatement("update sellitem set quntity=quntity-1  where itemId=?");
	    	       
	                
	                
	                ps.setInt(1, itemid);
	               int x= ps.executeUpdate();
//	               if (x>0) msg= "Record updated succesfully";
	                
	    } catch (SQLException e) {
			
			throw new SellerException(e.getMessage());
		}
		
		
	}

	@Override
	public void updateStatus(int itemid) throws SellerException {
		
		try(Connection conn=DButil.provideConnection()){
	    	PreparedStatement ps=conn.prepareStatement("update sellitem set status=?  where itemId=?");
	    	       
	                
	                
	                ps.setString(1, "Sold");
	                ps.setInt(2, itemid);
	               int x= ps.executeUpdate();
//	               if (x>0) msg= "Record updated succesfully";
	                
	    } catch (SQLException e) {
			
			throw new SellerException(e.getMessage());
		}
		
		
	}

}
