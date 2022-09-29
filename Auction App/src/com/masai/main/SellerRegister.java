package com.masai.main;


import com.masai.bean.Seller;
import com.masai.dao.SellerDao;
import com.masai.dao.SellerImpl;

public class SellerRegister {

	public void registerSeller(String name,String email, String password) {
	    SellerDao byd=new SellerImpl();
	    
	    Seller seller=new Seller(name,email,password);
	    seller.setName(name);
	    seller.setEmail(email);
	   
	    seller.setPassword(password);
	    String result=byd.registerSeller(seller);
	    System.out.println(result);
	}


}
