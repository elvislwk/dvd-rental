package eDVD;
import java.util.*;

public class Customer extends Rental
{
   private String name;
   private String tel;
   private ArrayList rentalList = new ArrayList();
   
   public Customer() {}
   public Customer(String n, String tl)
   {
      name = n;
      tel = tl;
   }
   
   public void setName(String n) {name = n;}
   public String getName() {
      return name;}
   public void setTel(String tl) {tel = tl;}
   public String getTel() {
      return tel;}
   
   public void addRental(Rental rental)
   {
      rentalList.add(rental);
   }
   
   public void removeRental(int i) {rentalList.remove(i);}
   
   public ArrayList getRentalList()
   {
      return rentalList;
   }
   
   public String toString()
   {
      return "Name:" + name + "\tTel No.: " + tel;
   } 
}
