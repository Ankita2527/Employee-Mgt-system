package emp_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Login extends JFrame  implements ActionListener {
 
    JTextField tfusername, tfpassword;
Login(){

    getContentPane().setBackground(Color.WHITE);
    setLayout(null);
    
    JLabel lblusername =new JLabel("Username");
    lblusername.setBounds(40,20,100,30);
    add(lblusername);
    
    tfusername= new  JTextField();
    tfusername.setBounds(150,20,150,30);
    add(tfusername);
    
    JLabel lblpassword = new JLabel("Password");
    lblpassword.setBounds(40,70,100,30);
    add(lblpassword);
    
    tfpassword= new  JTextField();
     tfpassword.setBounds(150,70,150,30);
     add(tfpassword);
    
         JButton login=new JButton("Login");
         login.setBounds(150,140,150,30);
         login.setFont(new Font("Tahoma", Font.PLAIN, 20));
         login.setBackground(Color.BLACK);
         login.setForeground(Color.WHITE);
         login.addActionListener(this);
         add(login);
         
         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.jpg"));
         Image i2=i1.getImage().getScaledInstance(250,200 ,Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image=new JLabel(i3);
         image.setBounds(320,20,170,200);
         add(image);
         
    setSize(600,300);
    setLocation(450,200);
    setVisible(true);
}
  @Override
    public void actionPerformed(ActionEvent ae) {
        try{
           String username=tfusername.getText();
           String password=tfpassword.getText();
           
            Conn c= new Conn();
            String query = "SELECT * FROM login WHERE username = '"+username+"' AND password = '"+password+"'";
            
            java.sql.ResultSet rs = c.s.executeQuery(query);
           if(rs.next()){
                JOptionPane.showMessageDialog(null, "Login Successful!");
               setVisible(false);
               new Home();
           }else{
               JOptionPane.showMessageDialog(null,"Invalid Username or Password");
               setVisible(false);
           }
             
            
        } catch (Exception e) {
            e.printStackTrace();
       }
      }
    
    public static void main(String args[]){
        new Login();
    }
    
}