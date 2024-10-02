package it2c.bas.hbs;

import static it2c.bas.hbs.config.connectDB;
import static java.time.Clock.system;
import java.util.Scanner;

public class MAIN {

   
  public void addGuest(){
       Scanner sc = new Scanner (System.in);
     config conf = new config();
   
         System.out.print("Guest first name: ");
         String fname = sc.next();
         System.out.print("Guest last name: ");
         String lname = sc.next();
         System.out.print("Enter contact number: ");
         String cnum = sc.next();
         System.out.print("Enter Email: ");
         String email = sc.next();
         
      String sql = "INSERT INTO Guest(g_fname, g_lname, g_cnum, g_email)"
         + "VALUES (?, ?, ?, ?)";
        
       conf.addRecord(sql, fname, lname, cnum, email);
}


public static void main(String[] args) {
  
         connectDB();
         Scanner sc = new Scanner(System.in);
         String op = null;
  
        do{

        System.out.println("WELCOME TO BOOKIING SYSTEM");
        System.out.println("-------------------------------------");
        System.out.println("1. ADD");
        System.out.println("2. VIEW");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. EXIT");
        System.out.println("-------------------------------------");

        System.out.print("Enter Action: ");
        int option = sc.nextInt();

        while(option > 5){
            System.out.print("Invalid Action. Try Again: ");
            option = sc.nextInt();
         
        } switch(option){

            case 1:
                 MAIN demo = new MAIN();
                 demo.addGuest();
            break;
    }     System.out.println("Do you want to continue?(Y/N): ");
            op=sc.next();
        }while(op.equals("Y")|| op.equals("y"));

    }
}
    
    
