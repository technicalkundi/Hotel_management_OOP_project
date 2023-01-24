/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author aaaa
 */ 
public class Reception extends JFrame implements ActionListener {
    JButton newcut,rooms,dep,Allemp,cutinfo,Search,pic,checkout,log;
    Reception()
    {
        
        
        newcut=new JButton("New Customer");
        newcut.setBounds(10,30,200,30);
        newcut.setBackground(Color.BLACK);
        newcut.setForeground(Color.WHITE);
        newcut.addActionListener(this);
        add(newcut);
        
         rooms=new JButton("ROOMS");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(Color.BLACK);
        rooms.setForeground(Color.WHITE);
        rooms.addActionListener(this);
        add(rooms);
        
         dep=new JButton("Departments");
        dep.setBounds(10,110,200,30);
        dep.setBackground(Color.BLACK);
        dep.setForeground(Color.WHITE);
        dep.addActionListener(this);
        add(dep);
        
        Allemp=new JButton("ALL Employee");
        Allemp.setBounds(10,150,200,30);
        Allemp.setBackground(Color.BLACK);
        Allemp.setForeground(Color.WHITE);
        Allemp.addActionListener(this);
        add(Allemp);
        
        cutinfo=new JButton("Customer INFO");
        cutinfo.setBounds(10,190,200,30);
        cutinfo.setBackground(Color.BLACK);
        cutinfo.setForeground(Color.WHITE);
        cutinfo.addActionListener(this);
        add(cutinfo);
        
        checkout=new JButton("CHECK OUT");
        checkout.setBounds(10,230,200,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.addActionListener(this);
        add(checkout);
        
        
        pic=new JButton("PICK UP SERVICE");
        pic.setBounds(10,270,200,30);
        pic.setBackground(Color.BLACK);
        pic.setForeground(Color.WHITE);
         pic.addActionListener(this);
        add(pic);
        
        Search=new JButton("SEARCH ROOMS");
        Search.setBounds(10,310,200,30);
        Search.setBackground(Color.BLACK);
        Search.setForeground(Color.WHITE);
        Search.addActionListener(this);
        add(Search);
        
        log=new JButton("LOGOUT");
        log.setBounds(10,350,200,30);
        log.setBackground(Color.BLACK);
        log.setForeground(Color.WHITE);
        log.addActionListener(this);
        add(log);
        
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
         JLabel image = new JLabel(il);
         image.setBounds(250,30,500,470);
         add(image);
        
        
        
        
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setBounds(350,200,800,570);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==newcut)
        {
            setVisible(false);
            new Add_Customer();
        }else if(ae.getSource()==rooms)
        {
            setVisible(false);
            new Room();
        }
        else if(ae.getSource()==dep)
        {
            setVisible(false);
            new Deprtments();
        }else if(ae.getSource()==Allemp)
        {
            setVisible(false);
            new Empoyee();
        }else if(ae.getSource()==cutinfo)
        { 
            setVisible(false);
            new Customerinfo();
        }else if(ae.getSource()==Search)
        {
            setVisible(false);
            new Search_room();
        }
        else if(ae.getSource()==pic)
        {
            setVisible(false);
            new pickup();
        }
        
        else if(ae.getSource()==checkout)
        {
            setVisible(false);
            new Check_out();
        }
        else if(ae.getSource()==log)
        {
            setVisible(false);
             new Hotel_management(); 
        }
        
        
        
    }
    public static void main(String[] arg)
    {
        new Reception();
    }
}
