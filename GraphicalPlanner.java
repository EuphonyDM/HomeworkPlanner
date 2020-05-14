import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GraphicalPlanner implements ActionListener
{
  //PlannerIO io;
  HomeworkPlanner hp;
  JFrame frame;
  JTable assignments;
  JScrollPane scrollpane;
  
  public static void main(String[] args)
  {
    String u=(String)JOptionPane.showInputDialog(null,"Enter username:","Username",1,null,null,null);
    if(u!=null)
      new GraphicalPlanner(u);
  }
  
  public GraphicalPlanner(String u)
  {
    hp=new HomeworkPlanner(u);
    
    frame=new JFrame(u);
    
    JPanel panel=new JPanel();
    panel.setBounds(0,0,100,400);
    panel.setBackground(new Color(150,150,150));
    
    JButton helpButton=new JButton("Help");
    helpButton.setBounds(10,10,80,40);
    helpButton.addActionListener(this);
    helpButton.setActionCommand("help");
    frame.add(helpButton);
    
    JButton addButton=new JButton("Add");
    addButton.setBounds(10,90,80,40);
    addButton.addActionListener(this);
    addButton.setActionCommand("add");
    frame.add(addButton);
    
    JButton removeButton=new JButton("Remove");
    removeButton.setBounds(10,170,80,40);
    removeButton.addActionListener(this);
    removeButton.setActionCommand("remove");
    frame.add(removeButton);
    
    JButton saveButton=new JButton("Save");
    saveButton.setBounds(10,250,80,40);
    saveButton.addActionListener(this);
    saveButton.setActionCommand("save");
    frame.add(saveButton);
    
    JButton quitButton=new JButton("Quit");
    quitButton.setBounds(10,330,80,40);
    quitButton.addActionListener(this);
    quitButton.setActionCommand("quit");
    frame.add(quitButton);
    
//    JLabel label=new JLabel("Assignments: ");
//    label.setBounds(125,0,500,35);
//    frame.add(label);
    
    
    assignments=new JTable(new MyTable(hp));
    //assignments.setBounds(100,50,500,350);
    //assignments.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    assignments.getColumn(assignments.getColumnName(0)).setPreferredWidth(50);
    assignments.getColumn(assignments.getColumnName(1)).setPreferredWidth(350);
    assignments.getColumn(assignments.getColumnName(2)).setPreferredWidth(100);
    //frame.add(assignments);
    scrollpane = new JScrollPane(assignments);
    scrollpane.setBounds(100,0,500,400);
    frame.add(scrollpane);
    
    frame.add(panel);
    frame.setSize(600,400);
    frame.setLayout(null);
    frame.setVisible(true);
  }
  
  public void actionPerformed(ActionEvent e)
  {
    if (e.getActionCommand().equals("help"))
    {
      System.out.println("helping");
      
      JOptionPane.showMessageDialog(frame, "Add: Create a new assignment\nRemove: Remove an assignment\n"+
                                           "Save: Saves the list of assignments\nQuit: Quits the application");
    }
    else if (e.getActionCommand().equals("add"))
    {
      System.out.println("adding");
      
      String n=(String)JOptionPane.showInputDialog(frame,"Enter assignment name:","Add",1,null,null,null);
      if(n!=null){
        String dateString=(String)JOptionPane.showInputDialog(frame,"Enter assignment date:\n(mm/dd/yy)","Add",1,null,null,null);
        if(dateString!=null){
          Date d=Date.parseDate(dateString);
          
          hp.add(new Homework(n,d));
          //hp.save();
          assignments.revalidate();
          //updateDisplay();
        }
      }
    }
    else if (e.getActionCommand().equals("remove"))
    {
      System.out.println("removing");
      if(hp.getArray().length>0){
        String[] nums=new String[hp.getArray().length];
        for(int i=0;i<nums.length;i++)
          nums[i]=""+i;
        
        String intString=(String)JOptionPane.showInputDialog(frame,"Which assignment do you want to remove?","Remove",JOptionPane.QUESTION_MESSAGE,null,nums,nums[0]);
        if(intString!=null){
          int x=Integer.parseInt(intString);
          
          hp.remove(x);
          //hp.save();
          assignments.revalidate();
        }
      }
    }
    else if (e.getActionCommand().equals("save"))
    {
      System.out.println("saving");
      
      hp.save();
      //assignments.repaint();
    }
    else if (e.getActionCommand().equals("quit"))
    {
      System.out.println("quitting");
      
      //save first
      //hp.save();
      
      System.exit(0);
    }
  }
  
}