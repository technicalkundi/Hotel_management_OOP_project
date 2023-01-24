/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import net.proteanit.sql.*;


/**
 *
 * @author aaaa
 */
public class Empoyee extends JFrame implements ActionListener{
    JTable table;
    JButton back;
      Empoyee()  {
        setLayout(null);
         
         
         JLabel roo = new JLabel("Name");
         roo.setBounds(10, 10, 100, 20);
         add(roo);
         
         JLabel avi = new JLabel("Age");
         avi.setBounds(170, 10, 100, 20);
         add(avi);
         
         JLabel sta = new JLabel("Gender");
         sta.setBounds(290, 10, 100, 20);
         add(sta);
         
         JLabel pri = new JLabel("Job");
         pri.setBounds(450, 10, 100, 20);
         add(pri);
         
          JLabel bed = new JLabel("SALARY");
         bed.setBounds(580, 10, 100, 20);
         add(bed);
         
          JLabel bed1 = new JLabel("PHONE NO");
         bed1.setBounds(720, 10, 100, 20);
         add(bed1);
         
          JLabel bed2 = new JLabel("Email");
         bed2.setBounds(880, 10, 100, 20);
         add(bed2);
         
        
         back =new JButton("back");
         back.setBounds(450,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);
        
         table =new JTable();
         table.setBounds(0,40,1000,400);
         add(table);
         try
         {
             Conn conn=new Conn();
             ResultSet rs=conn.s.executeQuery("select * from empyee1");
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         
        getContentPane().setBackground(Color.white);
        setBounds(300,200,1050,600);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] arg)  
    {
       new Empoyee();
    }
}
