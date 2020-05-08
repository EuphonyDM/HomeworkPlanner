import javax.swing.table.*;

public class MyTable extends AbstractTableModel
{
  HomeworkPlanner hp;
  
  public MyTable(HomeworkPlanner x)
  {
    hp=x;
  }
  
  public String getValueAt(int row,int col) //row is homework, col: 0=row, 1=name, 2=date
  {
    if(col==0)
      return Integer.toString(row);
    else if(col==1)
      return hp.getArray()[row].getName();
    else if(col==2)
      return hp.getArray()[row].getDate().getDate(0);
    else
      throw new RuntimeException("invalid col number (must be 0-2)");
  }
  
  public String getColumnName(int col) 
  {
    if(col==0)
      return " ";
    else if(col==1)
      return "NAME";
    else if(col==2)
      return ("DATE");
    else
      throw new RuntimeException("invalid col number (must be 0-2)");
  }
  
  public int getColumnCount()
  {
    return 3;
  }
  
  public int getRowCount()
  {
    return hp.getArray().length;
  }
  
  public boolean isCellEditable(int row, int col)
  { 
    return false; 
  }
}