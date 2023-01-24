/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import net.proteanit.sql.*;


/**
 *
 * @author aaaa
 */
public class Search_room extends JFrame implements ActionListener{
    JTable table;
    JButton back,submit;
    JComboBox bedty;
    JCheckBox avalible;
      Search_room()  {
        setLayout(null);
         
         
         JLabel roo = new JLabel(" Search Room ");
         roo.setFont(new Font("Tahoma",Font.PLAIN,20));
         roo.setBounds(400, 30, 200, 30);
         add(roo);
         
         JLabel bedtype = new JLabel(" Bed Type ");
         bedtype.setFont(new Font("Tahoma",Font.PLAIN,20));
         bedtype.setBounds(50, 100, 100, 20);
         add(bedtype);
         
         bedty =new JComboBox(new String[]{"single","double bed","Traple bed","four bed"});
         bedty.setBounds(150,100,150,25);
         bedty.setBackground(Color.white);
         add(bedty);
         
         avalible =new JCheckBox("only Avilible Display");
         avalible.setBounds(650, 100, 150, 25);
          avalible.setBackground(Color.white);
         add(avalible);
         
         
         JLabel avi = new JLabel("Avilible");
         avi.setBounds(270, 160, 100, 20);
         add(avi);
         
         JLabel sta = new JLabel("Status");
         sta.setBounds(450, 160, 100, 20);
         add(sta);
         
         JLabel pri = new JLabel("price");
         pri.setBounds(670, 160, 100, 20);
         add(pri);
         
          JLabel bed = new JLabel("bed_type");
         bed.setBounds(870, 160, 100, 20);
         add(bed);
         
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
             ResultSet rs=conn.s.executeQuery("select * from room");
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
                String Query1 ="select *from room where bed_type='"+bedty.getSelectedItem()+"'";
                String Query2="select *from room where avlibility='Avilible'AND bed_type ='"+bedty.getSelectedItem()+"'";
                     Conn conn= new Conn();
                     ResultSet rs;
                     if(avalible.isSelected())
                     {
                         rs=conn.s.executeQuery(Query2);
                     }else 
                     {
                        rs=conn.s.executeQuery(Query1); 
                     }
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
       new Search_room();
    }
}

