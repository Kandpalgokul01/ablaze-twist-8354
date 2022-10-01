package com.masai.dao;

import java.util.List;

import com.masai.bean.Seller;
import com.masai.bean.SellingList;
import com.masai.exceptions.SellerException;

public interface SellerDao {
	public String registerSeller(Seller seller);
	
	
	public String addItem(int sellerid,int itemId,String property,int price,int quntity,String location) throws  SellerException;
	
	
	public String updateItem(String prop,int price,int quntity,int itemId) throws SellerException;
    
	public String removeItem(int itemid) throws SellerException;

	
	public List<SellingList> viewSolditemDetail() throws SellerException;
	public  void updateQuntity(int itemid) throws SellerException;
	public  void updateStatus(int itemid) throws SellerException;
}
