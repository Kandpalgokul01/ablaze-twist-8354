package com.masai.main;


import java.util.List;

import com.masai.bean.Seller;
import com.masai.bean.SellingList;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerImpl;
import com.masai.exceptions.SellerException;

public class SellerRegister {
	static SellerDao syd=new SellerImpl();
	public void registerSeller(String name,String email, String password) {
	    
	    
	    Seller seller=new Seller(name,email,password);
	    seller.setName(name);
	    seller.setEmail(email);
	   
	    seller.setPassword(password);
	    String result=syd.registerSeller(seller);
	    System.out.println(result);
	}
	
	public void itemRegister(int sellerid,int itemId,String property,int price,int quntity,String location) {
		
		try {
			String result =syd.addItem(sellerid, itemId,property, price, quntity, location);
			System.out.println(result);
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
		
	}
	
	public  void updateItem(String prop,int price,int quntity,int itemId) {
		
		
		try {
			String Result=syd.updateItem(prop, price, quntity, itemId);
			System.out.println(Result);
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	public void removeItem(int num) {
		
		
		try {
			String result =syd.removeItem(num);
			System.out.println(result);
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
	}
	
	public void showSoldItem() {
		
		try {
			List<SellingList> list= syd.viewSolditemDetail();
			list.forEach(s-> System.out.println(s));
		} catch (SellerException e) {
			
			System.out.println(e.getMessage());
		}
	}
	


}
