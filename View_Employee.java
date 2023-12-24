package emp_system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import net.proteanit.sql.DbUtils;

public class View_Employee  extends JFrame implements  ActionListener{
    
    JTable table;
    Choice cemployeeId;
    JButton search,print,update,back;

    View_Employee(){
        
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel searchlbl= new JLabel("search by employee id");
        searchlbl.setBounds(20,20,170,20);
        searchlbl.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        add(searchlbl);
        
        cemployeeId= new Choice();
        cemployeeId.setBounds(200,20,150,20);
        add(cemployeeId);
        
         try{
          Conn c = new Conn();
          java.sql.ResultSet rs =c.s.executeQuery("select * from employee");    
          while (rs.next()){
              cemployeeId.add(rs.getString("empid"));
          }
          
         }catch (Exception e){
         e.printStackTrace();
      }
        table=new JTable();
        
        try{
          Conn c = new Conn();
            java.sql.ResultSet rs =c.s.executeQuery("select * from employee");
          table.setModel(DbUtils.resultSetToTableModel(rs));
          
         }catch (Exception e){
         e.printStackTrace();
      }
        JScrollPane jsp =new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);
        
        search =new JButton ("Search");
        search.setBounds(20,70,80,20);
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.addActionListener(this);
        add(search);
        
        print=new JButton ("Print");
        print.setBounds(120,70,80,20);
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.addActionListener(this);
        add(print);
        
        update =new JButton ("Update");
        update.setBounds(220,70,80,20);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.addActionListener(this);
        add(update);
        
        back=new JButton ("Back");
        back.setBounds(320,70,80,20);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== search){
            String query = "select * from employee where empid= '"+cemployeeId.getSelectedItem()+"'";
            try{
                Conn c= new Conn();
                java.sql.ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
              
            }catch (Exception ex){
                ex.printStackTrace();              
            }
            
        }else if(e.getSource()==print){
            try{
               table.print();
            }catch(Exception ex){
                ex.printStackTrace();
           }
        
        }else if (e.getSource()==update){
            setVisible(false);
            new Update_Employee(cemployeeId.getSelectedItem());
            
        }else if (e.getSource()== back){
            setVisible(false);
            new Home();
        }
    } 
    
    public static void main(String args[]){
      
        new View_Employee();
    }

    
   
}
