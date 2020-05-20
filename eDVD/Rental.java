package eDVD;

public class Rental extends DVD
{
  private int rentalNo;
  private DVD dvd = new DVD();
  private String startDate;
  private String endDate;
  
  public Rental() {}
  public Rental(int rn, DVD d, String sd, String ed)
  {
    rentalNo = rn;
    dvd = d;
    startDate = sd;
    endDate = ed;
  }
  
  public void setRentalNo(int rn) {rentalNo = rn;}
  public int getRentalNo() {return rentalNo;}
  public void setDvd(DVD d) {dvd = d;}
  public DVD getDvd() {return dvd;}
  public void setStartDate(String sd) {startDate = sd;}
  public String getStartDate() {return startDate;}
  public void setEndDate(String ed) {endDate = ed;}
  public String getEndDate() {return endDate;}
  
  public String toString()
  {
    return  "\nRental No.:" + rentalNo + "\t" + dvd + "\t" + startDate + " to " + endDate;
  }
}
  