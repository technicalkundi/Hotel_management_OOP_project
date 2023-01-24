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
public class Deprtments extends JFrame implements ActionListener{
    JTable table;
    JButton back;
    Deprtments(){
        setLayout(null);
         
         
         JLabel roo = new JLabel("Departments");
         roo.setBounds(180, 10, 100, 20);
         add(roo);
         
         JLabel avi = new JLabel("Budget");
         avi.setBounds(370, 10, 100, 20);
         add(avi);
         
         
        
         back =new JButton("back");
         back.setBounds(280,400,120,30);
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
             ResultSet rs=conn.s.executeQuery("select * from department");
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
         }catch(Exception e)
         {
             e.printStackTrace();
         }
         
        getContentPane().setBackground(Color.white);
        setBounds(400,200,700,480);
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
       new Deprtments();
    }
}

