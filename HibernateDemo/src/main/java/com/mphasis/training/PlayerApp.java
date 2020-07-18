package com.mphasis.training;


import java.util.Scanner;

import com.mphasis.training.daos.PlayerDao;

import com.mphasis.training.entities.Player;


public class PlayerApp {
	  public static void main( String[] args )
	  {
	Scanner sc=new Scanner(System.in);
    System.out.println( "Player app" );
    PlayerDao pdao=new PlayerDao();
    
    do {
    System.out.println("1.Get player by name \n2.Get player by gender \n3.Get player by contact\n 4.Retrive player by id\n"
    		+ " 5.Retrive by age \n6.All Players \n7.Get player by team name \n8.Get player by score\n 9.Get player by email\n "
    		+ " 10.exit");
    
    switch(sc.nextInt()) {
    
    case 1:  System.out.println("Enter player name");
    		String name=sc.next();
    		pdao.retrieveByName(name).forEach(p->System.out.println(p));
    		
        break;
        
    case 2:  System.out.println("Enter player gender");
    		String gender=sc.next();
    			pdao.retrieveByGender(gender).forEach(p->System.out.println(p));
    	break;
    case 3:  System.out.println("Enter player contact");
    		String contact=sc.next();
    		pdao.retrieveByContact(contact).forEach(p->System.out.println(p));
    		
    	break;
    	
    case 4:
    	 System.out.println("Enter palyer id");
         int pid1=sc.nextInt();
         Player pr1=pdao.retrievePlayerById(pid1);
          System.out.println(pr1);
 	break;
 	
    case 5:
   	 System.out.println("Enter player age");
        int age=sc.nextInt();
        pdao.retrieveByAge(age).forEach(p->System.out.println(p));
        
	break;
 	
    case 6: System.out.println("List of Players");
    		pdao.retrieveAll().forEach(p->System.out.println(p));
    		break;
    case 7: System.out.println("Enter player team name");
    		String teamname=sc.next();
    		pdao.retrieveByTeamName(teamname).forEach(p->System.out.println(p));
    	break;
    case 8: System.out.println("Enter player score");
    		long score=sc.nextLong();
    		pdao.retrieveByScore(score).forEach(p->System.out.println(p));
    	break;
    case 9:
   	 System.out.println("Enter palyer email");
     String email=sc.next();
     pdao.retrieveByEmail(email).forEach(p->System.out.println(p));
      
	break;
    case 10:System.out.println("Thank you..");
    	System.exit(0);
    
    default:System.out.println("Invalid choice");
    }
}while(true);
}
}