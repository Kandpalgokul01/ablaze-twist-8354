package com.masai.main;

import com.masai.bean.Buyer;
import com.masai.dao.BuyerImpl;
import com.masai.dao.Buyerdao;

public class BuyerRegister {

	public void registerBuyer(String name,String email, String password) {
		
		
		
	    Buyerdao byd=new BuyerImpl();
	    
	    Buyer buyer=new Buyer(name,email,password);
	    buyer.setName(name);
	    buyer.setEmail(email);
	   
	    buyer.setPassword(password);
	    String result=byd.registerBuyer(buyer);
	    System.out.println(result);
	    
	}
	
	
	
}
