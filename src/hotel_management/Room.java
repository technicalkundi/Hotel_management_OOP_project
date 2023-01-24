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
import net.proteanit.sql.*;


/**
 *
 * @author aaaa
 */
public class Room extends JFrame implements ActionListener{
    JTable table;
    JButton back;
      Room()  {
        setLayout(null);
         ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=il.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(500, 0, 600, 600);
         add(image);
         
         JLabel roo = new JLabel("Room Number");
         roo.setBounds(10, 10, 100, 20);
         add(roo);
         
         JLabel avi = new JLabel("Avilible");
         avi.setBounds(120, 10, 100, 20);
         add(avi);
         
         JLabel sta = new JLabel("Status");
         sta.setBounds(230, 10, 100, 20);
         add(sta);
         
         JLabel pri = new JLabel("price");
         pri.setBounds(330, 10, 100, 20);
         add(pri);
         
          JLabel bed = new JLabel("bed_type");
         bed.setBounds(430, 10, 100, 20);
         add(bed);
        
         back =new JButton("back");
         back.setBounds(200,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);
        
         table =new JTable();
         table.setBounds(0,40,500,400);
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
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] arg)  
    {
       new Room();
    }
}
