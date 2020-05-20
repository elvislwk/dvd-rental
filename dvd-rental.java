import eDVD.DVD;
import eDVD.Rental;
import eDVD.Customer;
import java.util.*; // used for Scanner and ArrayList

public class DVDRental
{
   public static void main(String[] args)
   {
      ArrayList dvdList = new ArrayList();
      ArrayList customerList = new ArrayList();
      initDvdList(dvdList);
      Customer rental = new Customer();
      int rentalNo = 1;
      Scanner input = new Scanner(System.in);
      int option;
      do
      {
         displayMenu();
         System.out.print("Enter option: ");
         option = input.nextInt();
         switch(option)
         {
            case 1 : registerCustomer(customerList);				
               break;
            case 2 : listCustomers(customerList);	
               break;
            case 3 : listDVDs(dvdList);				
               break;
            case 4 : rentDVD(customerList,dvdList,rental,rentalNo);			
               break;
            case 5 : checkRental(customerList,dvdList,rental);		
               break;
            case 6 : cancelRental(customerList, dvdList,rental,rentalNo);					
               break;
            case 0 : System.out.println("Exiting programme...");			
               break;
            default:System.out.println("Error: Invalid Input");
         }  
      }while (option!=0);
   }
   public static void initDvdList(ArrayList dvdList)
   {
      DVD d = null;
      d = new DVD("Batman Begins", "Action", 2.50);
      dvdList.add(d);
      
      d = new DVD("Men in Black", "Comedy", 2.00);
      dvdList.add(d);
      
      d = new DVD("Sound of Music", "Musical", 1.50);
      dvdList.add(d);
      
      d = new DVD("Party Time", "Karaoke", 4.00);
      dvdList.add(d);    
   }
   public static void displayMenu() 
   {
      System.out.println("----- DVD RENTAL SYSTEM ------");
      System.out.println("[1] Register Customer");
      System.out.println("[2] List Customers");
      System.out.println("[3] List DVDs");
      System.out.println("[4] Rent DVD");
      System.out.println("[5] Check Rental");
      System.out.println("[6] Cancel Rental");
      System.out.println("[0] Exit");		
      System.out.println("----------------------------------------");		
   }
   public static void registerCustomer(ArrayList customerList)
   {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter customer name : ");
      String name = input.next();
      System.out.print("Enter telephone no  : ");
      String tel = input.next();
   
      Customer c = new Customer(name, tel);
      customerList.add(c);
   }
   public static void listCustomers(ArrayList customerList)
   {
      System.out.println("No\tName\tTel");
      for(int i=0; i < customerList.size(); i++)
      {
         Customer c = (Customer) customerList.get(i);
         System.out.println((i+1) + "\t" + c.getName() + "\t" + c.getTel());
      }
   }
   public static void listDVDs(ArrayList dvdList)
   {
      System.out.println("No\tTitle\t\tGenre\tCharge");
      for(int i=0; i < dvdList.size(); i++)
      {
         DVD r = (DVD) dvdList.get(i);
         System.out.printf("%d\t%s\t%s\t$%.2f\n", (i+1), r.getTitle(), r.getGenre(), r.getCharge());
      }
   }
   public static void rentDVD(ArrayList customerList, ArrayList dvdList, Customer rental, int rentalNo)
   {
      Scanner input = new Scanner(System.in);     
      listCustomers(customerList);
      System.out.print("Select customer: ");
      int no = input.nextInt();
      rental = (Customer) customerList.get(no-1); 
      
      System.out.println("Available DVDs") ;    
      listDVDs(dvdList);
      System.out.print("Select DVD: ");
      int num = input.nextInt();
      
      DVD dvd = (DVD)dvdList.get(num-1);
      
      System.out.print("Enter start date (DD/MM/YYYY): ");
      String sd = input.next();
      
      System.out.print("Enter end date (DD/MM/YYYY): ");
      String ed = input.next();
      
      Rental r = new Rental(rentalNo, dvd, sd, ed);
      rentalNo++;
      
      rental.addRental(r);
      
      System.out.println("The rental has been processed succesfully.");
   }
   public static void checkRental(ArrayList customerList, ArrayList dvdList, Customer rental)
   {
      Scanner input = new Scanner(System.in);
      listCustomers(customerList);
      System.out.print("Select customer: ");
      int num = input.nextInt();
      rental = (Customer)customerList.get(num-1);
      System.out.println("Customer: " + rental.getName());
      System.out.println(rental.getRentalList());
   }
   public static void cancelRental(ArrayList customerList, ArrayList dvdList, Customer rental, int rentalNo)
   {
      Scanner input = new Scanner(System.in);
      listCustomers(customerList);
      System.out.print("Select customer: ");
      int num = input.nextInt();
      rental = (Customer)customerList.get(num-1);
      System.out.println("Customer: " + rental.getName());
      System.out.println(rental.getRentalList());
      System.out.print("Enter rental number to cancel: ");
      int no = input.nextInt();
      rental.removeRental(no-1);
      
      System.out.println("The rental has been cancelled.");
   }
   
}