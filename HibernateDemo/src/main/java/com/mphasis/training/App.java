package com.mphasis.training;

import java.util.Scanner;

import com.mphasis.training.daos.ProductDao;
import com.mphasis.training.entities.Product;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
        System.out.println( "Product app" );
        ProductDao pdao=new ProductDao();
        
        do {
        System.out.println("1.Add product 2.Update product 3.Delete Product 4.Retrive product 5.Retrive by cost 6.All Products"
        		+ " 7.exit");
        
        switch(sc.nextInt()) {
        
        case 1: System.out.println("Enter product id, product name, cost and quantity");
        		System.out.println("Enter Employee details");
        		Product p1=new Product();
            
            System.out.println("enter product id");
            p1.setPid(sc.nextInt());
            System.out.println("enter product name");
            p1.setPname(sc.next());
            System.out.println("enter cost");
            p1.setCost(sc.nextDouble());
            System.out.println("enter quantity");
           p1.setQty(sc.nextInt());
            try {
               pdao.insertProduct(p1);
               System.out.println("Product added ");
            } catch (Exception e) {
            	System.out.println(e.getMessage());
            	}
            break;
            
        case 2: System.out.println("Enter product id to update");
        		int pid=sc.nextInt();
        		Product pr=pdao.retrieveProductById(pid);
        		System.out.println(pr);
        		System.out.println("Which field u want to update 1.cost or 2.quantity");
        		int c=sc.nextInt();
        		
        		if(c==1) {
        			System.out.println("Enter cost");
        			
        			pr.setCost(sc.nextDouble());
        			pdao.updateProduct(pr);
        			System.out.println("Updated successfully");
        		}
        		else if(c==2)
        		{
        			System.out.println("Enter quantity");
        			pr.setQty(sc.nextInt());
        			pdao.updateProduct(pr);
        			System.out.println("Updated successfully");
        		}
        		else {
        			System.out.println("Invalid option");
        		}
        	break;
        case 3: System.out.println("Enter product id to delete");
                int id=sc.nextInt();
                pdao.deleteProduct(id);
                System.out.println("Product deleted...");
        	break;
        	
        case 4:
        	 System.out.println("Enter product id");
             int pid1=sc.nextInt();
             Product pr1=pdao.retrieveProductById(pid1);
              System.out.println(pr1);
     	break;
     	
        case 5:
       	 System.out.println("Enter product cost");
            double cost=sc.nextDouble();
            pdao.retrieveByCost(cost).forEach(p->System.out.println(p));
            
    	break;
     	
        case 6: System.out.println("List of products");
        		pdao.retrieveAll().forEach(p->System.out.println(p));
        		break;
        case 7:System.out.println("Thank you..");
        	System.exit(0);
        
        default:System.out.println("Invalid choice");
        }
    }while(true);
}
}
