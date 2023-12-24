package emp_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Home extends JFrame  implements ActionListener{
     JButton add,view,update,delete;
    
      Home(){
          
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/process1.png"));
         Image i2=i1.getImage().getScaledInstance(1100,700 ,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(50,100,1020,500);
         add(image);
          
         JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
         heading.setBounds(350,40,600,40);
         heading.setFont(new Font("Raleway", Font.BOLD, 30));
         heading.setForeground(Color.BLACK);
         image.add(heading);
         
         add= new JButton("Add Employee");
         add.setBounds(700,90,150,60);
         add.addActionListener(this);
         add.setBackground(Color.BLACK);
         add.setForeground(Color.WHITE);
         image.add(add);
         
         view= new JButton("View Employees");
         view.setBounds(870,90,150,60); 
         view.addActionListener(this);
         view.setBackground(Color.BLACK);
         view.setForeground(Color.WHITE);
         image.add(view);
         
         update= new JButton("Update Employee");
         update.setBounds(870,160,150,60);
         update.addActionListener(this);
         update.setBackground(Color.BLACK);
         update.setForeground(Color.WHITE);
         image.add(update);
         
         delete= new JButton("Delete Employee");
         delete.setBounds(700,160,150,60);
         delete.addActionListener(this);
         delete.setBackground(Color.BLACK);
         delete.setForeground(Color.WHITE);
         image.add(delete);
         
         
          setSize(1120,630);
          setLocation(250,100);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // Close the application when the frame is closed
    }
         @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==add){
           setVisible(false);
           new Add_Employee();
         
        } else if (e.getSource()==view){
        setVisible(false);
        new View_Employee();
         
        } else if(e.getSource()==update){
        setVisible(false);
        new Update_Employee("");
            
        }else if (e.getSource()== delete){
        setVisible(false);
        new Delete_Employee();
        }else{
             System.out.println("Unknown action");
        }
    }
    
    public static void main(String args[]) {
         new Home();
     }

}
