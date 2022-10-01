package com.masai.main;

import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
	static AdminPage ap= new AdminPage();
    public static void printResults() {
    	
        System.out.println("For Admin 1 and Seller 2 and Buyer 3 ");
         
        int No=sc.nextInt();
        switch(No) {
        case 1:
        	    System.out.println("Login Admin ");
        	    System.out.println("Enter Username");
        	    String username=sc.next();
        	    System.out.println("Enter Password");
        	   String password=sc.next();
        	   
        	    if(username.equals("Admin")&&password.equals("Admin@123")) 
        	    {
	        	System.out.println("Welcome Admin...........");
	        	    System.out.println("Press 1 for View the registered buyer list ");
	                System.out.println("Press 2 for View the registered Seller list");
	                 int aNo=sc.nextInt();
		                switch(aNo) 
		                {
		                   case 1:   ap.showBuyerList(); 
		                              printResults();
		                	        break;
		                
		                
			                case 2: 
			                         ap.showSellerList();
			                         printResults();
			                         break;
		                }
                  
        	    }else{
        	    	System.out.println("Sorry!.....Wrong Password");
        	    	
        	    }
        	    printResults();
        	    break;
        case 2:
        	
        	System.out.println("Enter name of Seller");
        	String n=sc.next();
        	System.out.println("Enter email ");
        	String e=sc.next();
        	System.out.println("Enter password");
        	String p=sc.next();
        	SellerRegister se= new SellerRegister();
        	se.registerSeller(n, e, p);
        	break;
        	
        	
        case 3:
        	System.out.println("Enter name of Buyer");
	    	String name=sc.next();
	    	System.out.println("Enter email ");
	    	String email=sc.next();
	    	System.out.println("Enter password");
	    	String pass=sc.next();
	    	BuyerRegister s= new BuyerRegister();
	    	s.registerBuyer(name, email, pass);
	    	
	    	break;
        	
        
        }
 
        
        }
       
        
        
   
	public static void main(String[] args) {
		System.out.println("Welcome to Automated Auction System App");
		System.out.println("========================================");
		System.out.println("****************************************");
		System.out.println("========================================");
         	printResults();
	
		

	}
}


