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


  private void viewGuest() {
        String cqry = "SELECT * FROM Guest";
        String[] Headers = {"ID", "First Name", "Last Name", "Contact Number", "Email"};
        String[] Columns = {"g_id", "g_fname", "g_lname", "g_cnum", "g_email"};
        config conf = new config();
        conf.viewRecords(cqry, Headers, Columns);
    }
  
  private void updateGuest(){
  
      Scanner sc = new Scanner(System.in);
        System.out.print("Enter guest ID ");
        int id = sc.nextInt();
  
         System.out.print("Enter the new first name: ");
         String ufname = sc.next();
         System.out.print("Enter the new last name: ");
         String ulname = sc.next();
         System.out.print("Enter the new contact number: ");
         String ucnum = sc.next();
         System.out.print("Enter the new Email: ");
         String uemail = sc.next();
         
         String qry = "UPDATE Guest SET g_fname = ?, g_lname = ?, g_cnum = ? , g_email = ? WHERE g_id = ?";
         config conf = new config();
         conf.updateRecord(qry, ufname, ulname, ucnum, uemail, id);
  }
 
  private void deleteGuest(){
         Scanner sc = new Scanner(System.in);
         System.out.print("Enter guest ID to delete: ");
         int id = sc.nextInt();

         String sqlDelete = "DELETE FROM Guest WHERE g_id = ?";
         config conf = new config();
         conf.deleteRecord(sqlDelete, id);
  }
  
  
  
public static void main(String[] args) {
  
        connectDB();
        Scanner sc = new Scanner(System.in);
        String op = null;
        MAIN guest = new MAIN();
     
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
                 guest.addGuest();
            break;
          
            case 2:
                 guest.viewGuest();
            break;
          
            case 3:
                guest.viewGuest();
                guest.updateGuest();
            break;
           
            case 4:
                guest.viewGuest();
                guest.deleteGuest();
            break;
            
            case 5:
                System.exit(0);
                break;
            
    }     System.out.print("Do you want to continue?(Y/N): ");
            op=sc.next();
        }while(op.equals("Y")|| op.equals("y"));
         System.out.println("THANK YOU MY LOVE");
    }
}
    
