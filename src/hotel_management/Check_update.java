/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
/**
 *
 * @author aaaa
 */
public class Check_update extends JFrame implements ActionListener{
    Choice ccustomer;
    JTextField tfroom,tfname,tfcheck,tfmount,tfpend;
    JButton check,update,back;
    Check_update()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("UPdate Status");
         text.setFont(new Font("Tahoma",Font.PLAIN,20));
        text.setBounds(90, 20, 200, 30);
        text.setForeground(Color.BLUE);
        add(text);
        
        ccustomer =new Choice() ;
        ccustomer.setBounds(200,80,150,25);
        add(ccustomer);
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select *from customer");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        
          
        JLabel lblroom=new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);
        
        tfroom =new JTextField();
        tfroom.setBounds(200,120,150,25);
        add(tfroom);
        
         JLabel name=new JLabel("name");
        name.setBounds(30, 160, 100, 20);
        add(name);
        
         tfname =new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
         JLabel lblcheck=new JLabel("Checkin Time");
        lblcheck.setBounds(30, 200, 100, 20);
        add(lblcheck);
        
         tfcheck =new JTextField();
        tfcheck.setBounds(200,200,150,25);
        add(tfcheck);
        
        JLabel amount=new JLabel("Amount Paid");
        amount.setBounds(30, 240, 100, 20);
        add(amount);
        
         tfmount =new JTextField();
        tfmount.setBounds(200,240,150,25);
        add(tfmount);
        
         JLabel pending=new JLabel("Amount Pending");
        pending.setBounds(30, 280, 100, 20);
        add(pending);
        
         tfpend =new JTextField();
        tfpend.setBounds(200,280,150,25);
        add(tfpend);
        
        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(30,340,100,30);
        check.addActionListener(this);
        add(check);
        
         update=new JButton("Update");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(150,340,100,30);
        add(update);
        
         back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(270,340,100,30);
        add(back);
        

        JLabel lblid=new JLabel("customer ID");
        lblid.setBounds(30, 80, 100, 20);
        add(lblid);
        
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image=new JLabel(il);
        image.setBounds(400,50,500,300);
        add(image);
        
        setBounds(300,200,980,500);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String id=ccustomer.getSelectedItem();
        String query="select*from customer where number ='"+id+"'";
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                tfroom.setText(rs.getString("room"));
                tfname.setText(rs.getString("name"));
                tfcheck.setText(rs.getString("checkintime"));
                tfmount.setText(rs.getString("deposite"));
                
            }
            ResultSet rs2=c.s.executeQuery("select*from room");
        }catch(Exception e)
        {
          e.printStackTrace();
        }
    }
    
    public static void main(String [] arg)
    {
        new Check_update();
    }
    
}
