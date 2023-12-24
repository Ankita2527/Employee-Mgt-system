package emp_system;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JOptionPane;



public class Update_Employee extends JFrame implements ActionListener {
    
    JTextField tfname,tffname,tfemail,tfphone,tfaadhar,tfaddress,tfsalary,tfeducation,tfdesignation;
    JButton add,back;
    JLabel lblempid ;
    String empid;
   
    Update_Employee(String empid){
        this.empid=empid;
    
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel heading=new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("Times New Roman", Font.BOLD, 30));
        add(heading);
        
        // label for name
        JLabel labelnew=new JLabel("Name");
        labelnew.setBounds(50,150,150,30);
        labelnew.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labelnew);
        
        JLabel lblname=new JLabel();
        lblname.setBounds(170,150, 150,30);
        add(lblname);
        
        // label for fathersname
        JLabel labelfname=new JLabel("Father's Name");
        labelfname.setBounds(390,150,150,30);
        labelfname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labelfname);
        
        tffname=new JTextField();
        tffname.setBounds(590,150, 150,30);
        add(tffname);
        
        // label for dob
        JLabel labeldob=new JLabel("DOB");
        labeldob.setBounds(50,200,150,30);
        labeldob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labeldob);
        
        JLabel lbldob=new JLabel();
        lbldob.setBounds(170,200,150,30);
        add(lbldob);
        
        // label for salary
        JLabel labelsalary=new JLabel("Salary");
        labelsalary.setBounds(390,200,150,30);
        labelsalary.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labelsalary);
        
        tfsalary=new JTextField();
        tfsalary.setBounds(590,200,150,30);
        add(tfsalary);
        
        // label for address
        JLabel labeladdress=new JLabel("Address");
        labeladdress.setBounds(50,250,150,30);
        labeladdress.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labeladdress);
        
        tfaddress=new JTextField();
        tfaddress.setBounds(170,250,150,30);
        add(tfaddress);
        
        // label for phone no
        JLabel labelphone=new JLabel("Phone No");
        labelphone.setBounds(390,250,150,30);
        labelphone.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labelphone);
        
        tfphone=new JTextField();
        tfphone.setBounds(590,250,150,30);
        add(tfphone);
        
        // label for email
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(50,300,150,30);
        labelemail.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labelemail);
        
        tfemail=new JTextField();
        tfemail.setBounds(170,300,150,30);
        add(tfemail);
        
        //ComboBox for education
         JLabel labeledu=new JLabel("Education");
        labeledu.setBounds(390,300,150,30);
        labeledu.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labeledu);
        
        tfeducation=new JTextField();
        tfeducation.setBounds(590,300,150,30);
        add(tfeducation);
        
        //label for designation
        JLabel labeldesignation=new JLabel("Designation");
        labeldesignation.setBounds(50,350,150,30);
        labeldesignation.setFont(new Font("Times New Roman", Font.BOLD, 19));
        add(labeldesignation);
        
        tfdesignation=new JTextField();
        tfdesignation.setBounds(170,350,150,30);
        add(tfdesignation);
        
         // label for aadhar no
        JLabel labelaadhar=new JLabel("Aadhar No");
        labelaadhar.setBounds(390,350,150,30);
        labelaadhar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(labelaadhar);
        
        JLabel lblaadhar=new JLabel();
        lblaadhar.setBounds(590,350,150,30);
        add(lblaadhar);
        
        //label for empid
        JLabel labelempid=new JLabel("Employee Id");
        labelempid.setBounds(50,400,150,30);
        labelempid.setFont(new Font("Times New Roman", Font.BOLD, 19));
        add(labelempid);
        
        lblempid=new JLabel();
        lblempid.setBounds(170,400,150,30);
        lblempid.setFont(new Font("Times New Roman", Font.BOLD, 19));
        add(lblempid);
        
        try{
            Conn c= new Conn();
            String query = "select * from employee where empid= '"+empid+"'";
             java.sql.ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                tffname.setText(rs.getString("fname"));
                lbldob.setText(rs.getString("dob"));
                tfaddress.setText(rs.getString("adress"));
                tfsalary.setText(rs.getString("salary"));
                tfphone.setText(rs.getString("phone")); 
                tfemail.setText(rs.getString("email"));
                tfeducation.setText(rs.getString("education"));
                tfdesignation.setText(rs.getString("designation")); 
                lblaadhar.setText(rs.getString("aadhar")); 
                lblempid.setText(rs.getString("empid"));
             
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
        
        //buttons
        add= new JButton("Update Details");
        add.setBounds(250,500,150,60);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
         
        
        back= new JButton("Back");
        back.setBounds(450,500,150,60);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
           if (e.getSource()== add){
               String fname=tffname.getText();
               String salary=tfsalary.getText();
               String address=tfaddress.getText();
               String phone=tfphone.getText();
               String email=tfemail.getText();
               String education= tfeducation.getText();
               String designation=tfdesignation.getText();
           
               try{
                Conn conn=new Conn();
                String query="Update employee set fname ='"+fname+"',salary='"+salary+"', adress='"+address+"',phone= '"+phone+"',email ='"+email+"',education ='"+education+"',designation ='"+designation+"' where empid = '"+empid+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Updated successfuly");
                setVisible(false);
                new Home();
            } catch (Exception ex) {
                ex.printStackTrace();
                 JOptionPane.showMessageDialog(null, "Error updating  details to the database: " + ex.getMessage());
            }
               
           }else if (e.getSource()== back){
            setVisible(false);
            new Home();
           }
    }
    public static void main(String args[]){
    new Update_Employee("");
    }
}
