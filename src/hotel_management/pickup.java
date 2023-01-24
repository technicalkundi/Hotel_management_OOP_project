/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import net.proteanit.sql.*;


/**
 *
 * @author aaaa
 */
public class pickup extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    Choice bedty;
    JCheckBox avalible;
      pickup()  {
        setLayout(null);
         
         
         JLabel roo = new JLabel(" PICK UP SERVICES ");
         roo.setFont(new Font("Tahoma",Font.PLAIN,20 ));
         roo.setBounds(400, 30, 200, 30);
         add(roo);
         
         JLabel bedtype = new JLabel("Type of Car ");
         bedtype.setFont(new Font("Tahoma",Font.PLAIN,12));
         bedtype.setBounds(50, 100, 100, 20);
         add(bedtype);
         
          bedty =new Choice() ;
        bedty.setBounds(200,80,150,25);
        add(bedty);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select *from driver");
            while(rs.next())
            {
                bedty.add(rs.getString("car_company"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
         
         
         
         
         JLabel avi = new JLabel("name");
         avi.setBounds(70, 160, 100, 20);
         add(avi);
         
         JLabel sta = new JLabel("Age");
         sta.setBounds(240, 160, 100, 20);
         add(sta);
         
         JLabel pri = new JLabel("Gender");
         pri.setBounds(410, 160, 100, 20);
         add(pri);
         
          JLabel bed = new JLabel("Car_comapny");
         bed.setBounds(550, 160, 100, 20);
         add(bed);
         
         
          JLabel bed1 = new JLabel("Model");
         bed1.setBounds(690, 160, 100, 20);
         add(bed1);
         
         
          JLabel bed2 = new JLabel("Aviliblity");
         bed2.setBounds(870, 160, 100, 20);
         add(bed2);
         
         
         submit =new JButton("submit");
         submit.setBounds(500,520,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Tahoma",Font.PLAIN,16));
        submit.addActionListener(this);
        add(submit);
        
         back =new JButton("back");
         back.setBounds(200,520,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);
        
         table =new JTable();
         table.setBounds(0,200,1000,400);
         add(table);
         try
         {
             Conn conn=new Conn();
             ResultSet rs=conn.s.executeQuery("select * from driver");
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
        if(ae.getSource()==submit)
        {
            try
            {
                String Query ="select *from driver where car_company ='"+bedty.getSelectedItem()+"'";
                     Conn conn= new Conn();
                     ResultSet rs;
                        rs=conn.s.executeQuery(Query); 
                     
                     table.setModel(DbUtils.resultSetToTableModel(rs));
                                   
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] arg)  
    {
       new pickup();
    }
}

