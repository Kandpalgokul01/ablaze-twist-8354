package com.masai.bean;

public class Buyerlist {
  private int bid;
  private String name;
  private String email;
  private String property;
  private int price;
  private String location;
public Buyerlist(int bid, String name, String email, String property, int price,String location) {
	super();
	this.bid = bid;
	this.name = name;
	this.email = email;
	this.property = property;
	this.price=price;
	this.location = location;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public Buyerlist() {
	
}




public int getBid() {
	return bid;
}


public void setBid(int bid) {
	this.bid = bid;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}


public String getEmail() {
	return email;
}


public void setEmail(String email) {
	this.email = email;
}


public String getProperty() {
	return property;
}


public void setProperty(String property) {
	this.property = property;
}


public String getLocation() {
	return location;
}


public void setLocation(String location) {
	this.location = location;
}
@Override
public String toString() {
	return "Buyerlist [bid=" + bid + ", name=" + name + ", email=" + email + ", property=" + property + ", price="
			+ price + ", location=" + location + "]";
}



  
  
  
  
}

