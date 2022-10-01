package com.masai.main;

import java.util.List;

import com.masai.bean.Buyer;
import com.masai.bean.Buyerlist;
import com.masai.bean.SellingList;
import com.masai.dao.BuyerImpl;
import com.masai.dao.Buyerdao;
import com.masai.exceptions.BuyerException;
import com.masai.exceptions.SellerException;

public class BuyerRegister {
	static Buyerdao byd=new BuyerImpl();
	public void registerBuyer(String name,String email, String password) {
		
		
		
	    
	    
	    Buyer buyer=new Buyer(name,email,password);
	    buyer.setName(name);
	    buyer.setEmail(email);
	   
	    buyer.setPassword(password);
	    String result=byd.registerBuyer(buyer);
	    System.out.println(result);
	    
	}
	
	
	public void showList(String cate) {
		
	try {
		List<SellingList> list=	byd.viewbuyingList(cate);
		list.forEach(s -> System.out.println(s));
	} catch (SellerException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
		
	}
	
	public void buyItem(int buyerid, int itemid) {
		
		try {
			String result= byd.buyItem(buyerid, itemid);
			System.out.println(result);
		} catch (SellerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
		    System.out.println(e.getMessage());
		}
		
	}
	
	public void showbuyers() {
		
		try {
			List<Buyerlist> list= byd.viewBuyerList();
			list.forEach(s-> System.out.println(s));
		} catch (BuyerException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	 public void createDispute(String name, String issue) {
		 
		 byd.createDispute(name, issue);
	       System.out.println("Issue Created Succesfully");
		 
	 }
	
	
}
