package com.masai.main;

import java.util.Scanner;

public class Main {
	static Scanner sc=new Scanner(System.in);
	static AdminPage ap= new AdminPage();
	static SellerRegister se= new SellerRegister();
	static BuyerRegister byd= new BuyerRegister();
    public static void printResults() {
    	
        System.out.println("Press 1 :For Admin Page ");
        System.out.println("Press 2 :For Seller Page ");
        System.out.println("Press 3 :For Buyer Page ");
         
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
	                System.out.println("Press 3 for see daily dispute report");
	                System.out.println("Press 4 for see daily selling report");
	                System.out.println("Press 5 to solve dispute");
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
			                case 3:   ap.viewDisputeReport();
			                          printResults();
			                          break;
			                case 4:   ap.viewsellingReport();
			                            printResults();
			                            break;
			                case 5:   System.out.println("Write name of person whose dispute will be solved");
			                           String nd= sc.next();
			                           ap.solvedispute(nd);
			                           printResults();
			                           break;
			                 default: printResults();
			                          break;
		                }
                  
        	    }else{
        	    	System.out.println("Sorry!.....Wrong Password");
        	    	
        	    }
        	    printResults();
        	    break;
        case 2:
        	     System.out.println("Chosee options From the next operation");
        	     System.out.println("Press 1 For Register Seller");
        		System.out.println("Press 2 for Add Item on the Selling List");
        		System.out.println("Press 3 for Update Item on the Selling List"); 
        		System.out.println("Press 4 for Delete Item on the Selling List"); 
        		System.out.println("Press 5 for View sold Item on the Selling List"); 
        		System.out.println("Press 6 for Create a issue of dispute"); 
        	       int sNo=sc.nextInt();
        	      switch(sNo) {
        	      case 1:
	        	    	    System.out.println("Enter name of Seller");
			              	String n=sc.next();
			            	System.out.println("Enter email ");
			            	String e=sc.next();
			            	System.out.println("Enter password");
			            	String p=sc.next();
			            	
			            	se.registerSeller(n, e, p);
			            	
			            	printResults();
			            	break;
        	      case 2:
        	    	       boolean f1=true;
        	    	        while(f1){
        	    	        	System.out.println("Enter your sellerId");
            	    	        int sId=sc.nextInt();
            	    	        System.out.println("Enter your itemId");
            	    	        int iId=sc.nextInt();
            	    	        System.out.println("Enter your Property");
            	    	        String prop=sc.next();
            	    	        
            	    	        System.out.println("Price of property");
            	    	        int price=sc.nextInt();
            	    	        System.out.println("Quntity of property");
            	    	        int quntity=sc.nextInt();
            	    	        System.out.println("Enter Location");
            	    	        String loc=sc.next();
            	    	        
            	    	        se.itemRegister(sId, iId,prop, price, quntity, loc);
            	    	        
            	    	        boolean f=true;
            	    	        while(f) {
            	    	        	System.out.println("Want to add more property? Press 1"
                	    	        		+ "For Exit Press 0");
                	    	        int s=sc.nextInt();
                	    	        if(s==0) {
                	    	        	f1=false;
                	    	        	f=false;
                	    	        }else if(s==1) {
                	    	        	f1=true;
                	    	        	f=false;
                	    	        }else {
                	    	        	System.out.println("Sorry Wrong Input.............!"
                	    	        			+ "Try Again........!");
                	    	        	f=true;
                	    	        }
            	    	        }
            	    	        
            	    	        
    
        	    	        }
        	    	        printResults();
        	    	        break;
        	    	        
        	      case 3: 
        	    	       boolean f3=true;
                            while(f3) {
                            	 System.out.println("Enter the property");
               	              String pro=sc.next();
               	              System.out.println("Enter the price");
               	              int pri=sc.nextInt();
               	              System.out.println("Enter the quntity");
               	              int pr=sc.nextInt();
               	              System.out.println("Enter item id where to update");
               	              int itId=sc.nextInt();
               	              se.updateItem(pro, pri, pr, itId);
               	             System.out.println("Update more? Press 1 for yes for exit 0");
               	             int chck=sc.nextInt();
               	             if(chck==1) {
               	            	 f3=true;
               	             }else f3=false;
                            }
        	             printResults();
        	              break;
        	      case 4:
        	    	 boolean f4=true;
        	    	  while(f4) {
        	    		  System.out.println("Enter the Item id to delete from selling list");
        	    	      int iNO=sc.nextInt();
        	    	      se.removeItem(iNO);
        	    	      
        	    	      System.out.println("Delete more? "
        	    	      		+ "Press 1 for yes"
        	    	      		+ "Press 0 for exit");
        	    	      int nD=sc.nextInt();
        	    	      if(nD!=1) {
        	    	    	 f4=false;
        	    	      }else {
        	    	    	  f4=true;
        	    	      }
        	    	     
        	    	      
        	    	  }
        	    	  printResults();
        	    	  break;
        	          
        	       case 5: 
        	        	 System.out.println(" Total sold item");
        	        	   se.showSoldItem();
        	        	   printResults();
        	        	   break;
        	       case 6: 
        	    	        System.out.println("Enter your name");
			      	         String na=sc.next();
			      	         System.out.println("Enter your issue");
			      	         String iss= sc.next();
			      	        		 byd.createDispute(na, iss);
			      	        		 printResults();
      	                         break; 	   
        	    default:System.out.println("Please choose correct option....!");
        	    	    printResults();
        	            break;
        	      }
        	
        	
        	
        case 3:
        	System.out.println("Press 1 for Regiester Buyer");
        	System.out.println("Press 2 for view the buying list by category");
        	System.out.println("Press 3 for Purchase the item");
        	System.out.println("Press 4 for show Buyer list with item");
        	System.out.println("Press 5 for Create a issue of dispute"); 
        	int bNo=sc.nextInt();
        	switch(bNo) {
        	 case 1:
        		    System.out.println("Enter name of Buyer");
		 	    	String name=sc.next();
		 	    	System.out.println("Enter email ");
		 	    	String email=sc.next();
		 	    	System.out.println("Enter password");
		 	    	String pass=sc.next();
		 	    	
		 	    	byd.registerBuyer(name, email, pass);
		 	    	break;
        	 case 2: System.out.println("Enter the type of property");
        	          String cate=sc.next();
        	          
        	          byd.showList(cate);
        	          printResults();
        	          break;
        	 case 3: System.out.println("Enter the Buyer id");
        	         int byid=sc.nextInt();
        	         System.out.println("Enter the item id");
        	         int Itid=sc.nextInt();
        	         byd.buyItem(byid, Itid);
        	         printResults();
        	         break;
        	 case 4: byd.showbuyers();
        	          printResults();
        	          break;
        		 
        	 case 5: System.out.println("Enter your name");
        	         String na=sc.next();
        	         System.out.println("Enter your issue");
        	         String iss= sc.next();
        	        		 byd.createDispute(na, iss);
        	        		 printResults();
        	        break;		 
        	 default: System.out.println("Please choose correct option....!");
        		      printResults();
        	           break;
        	}
                  
        	
	    	        break;
         default: System.out.println("Oops ! You need to choose correct option................");
                   break;
                   
         
        
        }
 
        
        }
       
        
        
   
	public static void main(String[] args) {
		System.out.println("Welcome to Automated Auction System App");
		System.out.println("========================================");
		System.out.println("****************************************");
		System.out.println("========================================");
         	printResults();
	
		System.out.println("Thank you for using the App");

	}
}


