package com.masai.main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
        System.out.println("For Seller 2 and Buyer 3 ");
         
        int No=sc.nextInt();
        switch(No) {
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
        
        }
 
        
        }
       
        
        
		

	}


