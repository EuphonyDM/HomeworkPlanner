public class Homework
{
  String name;
  Date date;
  
  public Homework(String n, Date d)
  {
    name=n;
    date=d;
  }
  
  public String getName()
  {
    return name;
  }
  
  public Date getDate()
  {
    return date;
  }
  
  public boolean equals(Homework h)
  {
    return getDate().equals(h.getDate());
  }
  
  public int compareTo(Homework h)
  {
    return getDate().compareTo(h.getDate());
  }
  
  public String toString()
  {
    return name+" - "+date.getDate(0);
  }
}