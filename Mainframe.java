package emp_system;
 import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Mainframe extends JFrame implements ActionListener{
    Mainframe(){
         getContentPane().setBackground(Color.WHITE);
         setLayout(null);
          
         
         JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
         heading.setBounds(200,40,1200,60);
         heading.setFont(new Font("Tahoma", Font.BOLD, 40));
         heading.setForeground(Color.BLACK);
         add(heading);
         
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/emp1.jpg"));
         Image i2=i1.getImage().getScaledInstance(1100,700 ,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(50,100,1010,490);
         add(image);
         
         JButton click=new JButton("Click To Continue");
         click.setBounds(400,400,300,70);
         click.setFont(new Font("Tahoma", Font.BOLD, 20));
         click.setBackground(Color.WHITE);
         click.setForeground(Color.BLACK);
         click.addActionListener((ActionListener) this);
         image.add(click);
         
         
         setSize(1170,650);
         setLocation(200,50);
         setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Login();
    }
    public static void main(String args[]) {
        new Mainframe();
    }
}
