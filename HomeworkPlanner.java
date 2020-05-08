import java.util.*;
import java.io.*;

public class HomeworkPlanner
{
  String username;
  ArrayList<Homework> assignments;
  
  public HomeworkPlanner(String u)
  {
    username=u;
    assignments=new ArrayList<Homework>();
    load();
  }
  
  public void load()
  {
    try{
      //planner=new HomeworkPlanner(username);
      BufferedReader in = new BufferedReader(new FileReader(username+".txt"));
      String line = in.readLine();
      while (line != null)
      {
        String n=line;
        line = in.readLine();
        Date d=Date.parseDate(line);
        assignments.add(new Homework(n,d));
        line = in.readLine();
      }
      in.close();
      //return planner;
    }
    catch(IOException e){
//      planner=new HomeworkPlanner(username);
//      return planner;
    }
  }
  
  public void save() 
  {
    try{
    PrintWriter out = new PrintWriter(new FileWriter(username+".txt"), true);
    Homework[] a=getArray();
    for(int i=0;i<a.length;i++){
      out.println(a[i].getName());
      out.println(a[i].getDate().getDate(0));
    }
    out.close();
    }
    catch(IOException e){
      System.out.println("invalid filename");
    }
  }
  
  public void add(Homework homework)
  {
    boolean added=false;
    for(int i=0;i<assignments.size();i++)
    {
      if(homework.compareTo(assignments.get(i))<=0){
        assignments.add(i,homework);
        added=true;
        break;
      }
    }
    if(!added)
      assignments.add(homework);
  }
  
  public Homework[] getArray()
  {
    Homework[] h=new Homework[assignments.size()];
    for(int i=0;i<assignments.size();i++)
      h[i]=assignments.get(i);
    return h;
  }
  
  public void remove(int i)
  {
    if(i>=assignments.size()||i<0)
      throw new RuntimeException("Invalid remove index");
    else
      assignments.remove(i);
  }
  
  public String toString()
  {
    String s="Homework: ";
    for(int i=0;i<assignments.size();i++){
      s+=("\n"+i+": "+assignments.get(i).toString());
    }
    return s;
  }
  
  public String getUsername()
  {
    return username;
  }
  
}