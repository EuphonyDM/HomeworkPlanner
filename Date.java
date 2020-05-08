public class Date
{
  int[] date; //[0] is year: 2000+val, [1] is month: 1=jan, 12=dec, [2] is day: 1-31(or whatever)
  
  //Data should be parsed before
  public Date(int year, int month, int day)
  {
    date = new int[]{year,month,day};
  }
  
  public Date(int[] d)
  {
    if(d.length==3)
      date = d;
    else
      throw new RuntimeException("Invalid Date Loaded");
  }
  
  public int getYear()
  {
    return date[0];
  }
  
  public String getYear(int v)// v = Verbosity: 0 - basic, 1 - short, 2 - long
  {                           // basic: 2/17/21, short: Feb 17, 2021, long: Febuary 17th, 2021
    if(v==1||v==2)
      return "20"+date[0];
    else
    {
      if(date[0]<10)
        return "0"+date[0];
      return ""+date[0];
    }
  }
  
  public int getMonth()
  {
    return date[1];
  }
  
  public String getMonth(int v)// v = Verbosity: 0 - basic, 1 - short, 2 - long
  {
    if(v==0){
      if(date[1]<10)
        return "0"+date[1];
      return ""+date[1];
    }
    else{
      int m=date[1];
      if(m==1){
        if(v==1)
          return "Jan";
        else
          return "January";
      }
      else if(m==2){
        if(v==1)
          return "Feb";
        else
          return "Febuary";
      }
      else if(m==3){
        if(v==1)
          return "Mar";
        else
          return "March";
      }
      else if(m==4){
        if(v==1)
          return "Apr";
        else
          return "April";
      }
      else if(m==5){
        if(v==1)
          return "May";
        else
          return "May";
      }
      else if(m==6){
        if(v==1)
          return "Jun";
        else
          return "June";
      }
      else if(m==7){
        if(v==1)
          return "Jul";
        else
          return "July";
      }
      else if(m==8){
        if(v==1)
          return "Aug";
        else
          return "August";
      }
      else if(m==9){
        if(v==1)
          return "Sep";
        else
          return "September";
      }
      else if(m==10){
        if(v==1)
          return "Oct";
        else
          return "October";
      }
      else if(m==11){
        if(v==1)
          return "Nov";
        else
          return "November";
      }
      else if(m==12){
        if(v==1)
          return "Dec";
        else
          return "December";
      }
      else
        throw new RuntimeException("Invalid month");
    }
  }
  
  public int getDay()
  {
    return date[2];
  }
  
  public String getDay(int v)// v = Verbosity: 0 - basic, 1 - short, 2 - long
  {
    if(v==2){
      String s = ""+date[2];
      int x=date[2];
      if(x==1)
        s+="st";
      else if(x==2)
        s+="nd";
      else if(x==3)
        s+="rd";
      else if(x>3&&x<21)
        s+="th";
      else if(x==21)
        s+="st";
      else if(x==22)
        s+="nd";
      else if(x==23)
        s+="rd";
      else if(x>23&&x<31)
        s+="th";
      else if(x==31)
        s+="st";
      else
        throw new RuntimeException("Invalid day");
      return s;
    }
    else{
      if(date[2]<10)
        return "0"+date[2];
      return ""+date[2];
    }
  }
  
  public int[] getDate()
  {
    return new int[]{date[0],date[1],date[2]};
  }
  
  public String getDate(int v)
  {
    if(v==0)
      return getMonth(0)+"/"+getDay(0)+"/"+getYear(0);
    else if(v==1)
      return getMonth(1)+" "+getDay(1)+", "+getYear(1);
    else if(v==2)
      return getMonth(2)+" "+getDay(2)+", "+getYear(2);
    else
      throw new RuntimeException("Invalid verbosity value");
  }
  
  public boolean equals(Date d)
  {
    if(getYear()!=d.getYear()) return false;
    if(getMonth()!=d.getMonth()) return false;
    if(getDay()!=d.getDay()) return false;
    return true;
  }
  
  public int compareTo(Date d)
  {
    if(getYear()>d.getYear()) return 1;
    else if(getYear()<d.getYear())return -1;
    else{
      if(getMonth()>d.getMonth()) return 1;
      else if(getMonth()<d.getMonth())return -1;
      else{
        if(getDay()>d.getDay()) return 1;
        else if(getDay()<d.getDay())return -1;
        else return 0;
      }
    }
  }
  
  public static Date parseDate(String s)// assumes mm*dd*yy
  {                                     // * can be anything
    int[] d = new int[3];
    d[1]=Integer.parseInt(s.substring(0,2));
    d[2]=Integer.parseInt(s.substring(3,5));
    d[0]=Integer.parseInt(s.substring(6,8));
    return new Date(d);
  }
  
  public static Date randomDate()
  {
    return new Date(2020+(int)(Math.random()*5),(int)(Math.random()*12)+1,(int)(Math.random()*31)+1);
  }
}