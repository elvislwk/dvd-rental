package eDVD;

public class DVD
{
  private String title;
  private String genre;
  private double charge;
  
  public DVD() {}
  
  public DVD(String t, String g, double c)
  {
    title = t;
    genre = g;
    charge = c;
  }
  
  public void setTitle(String t) {title = t;}
  public String getTitle() {return title;}
  public void setGenre(String g) {genre = g;}
  public String getGenre() {return genre;}
  public void setCharge(double c) {charge = c;}
  public double getCharge() {return charge;}
  
  public String toString()
  {
    return "Title:" + title + "\tGenre:" + genre + "\tCharge:" + charge;
  }
}