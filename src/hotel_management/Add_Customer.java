/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import java.awt.Choice;
import java.awt.Color;
import static java.awt.Color.BLACK;
import static java.awt.Color.WHITE;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.sql.*;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author aaaa
 */
public class Add_Customer extends JFrame implements ActionListener{
    
    JComboBox cbjob;
    JTextField num1,tfname,coun1,depost1;
    JRadioButton rbfemale,rbmale;
    Choice choice;
    JLabel checkin;
    JButton add,back,delete,update;
    Add_Customer()
    {
        getContentPane().setBackground(WHITE);
        setLayout(null);
        
        JLabel text=new JLabel("ADD CUSTOMER");
         text.setBounds(100, 20, 300, 30);
         text.setFont(new Font("Raleway",Font.PLAIN,20));
         text.setForeground(Color.BLACK);
         add(text);
        
         JLabel  id =new JLabel("ID");
        id.setBounds(35,80,100,20);
        id.setBackground(Color.BLACK);
        id.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(id);
        
        String str[]={"CNIC","PASSPORT"};
        cbjob=new JComboBox(str);
        cbjob.setBackground(Color.WHITE);
        cbjob.setBounds(200,80,150,25);
        add(cbjob);
        
         JLabel  num =new JLabel("NUMBER");
        num.setBounds(35,120,100,20);
        num.setBackground(Color.BLACK);
        num.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(num);
        
        num1 =new JTextField();
        num1.setBounds(200,120,150,25);
        add(num1);
        
        JLabel  nam =new JLabel("NAME");
        nam.setBounds(35,160,100,20);
        nam.setBackground(Color.BLACK);
        nam.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(nam);
        
        tfname =new JTextField();
        tfname.setBounds(200,160,150,25);
        add(tfname);
        
        JLabel  gen =new JLabel("GENDER");
        gen.setBounds(35,200,100,20);
        gen.setBackground(Color.BLACK);
        gen.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(gen);
        
        
          rbmale=new JRadioButton("Male");
         rbmale.setFont(new Font("Tahoma",Font.PLAIN,13));
        rbmale.setBounds(200,200,60,25);
        add(rbmale);
        
         rbfemale=new JRadioButton("Female");
         rbfemale.setFont(new Font("Tahoma",Font.PLAIN,13));
        rbfemale.setBounds(270,200,70,25);
        add(rbfemale);
        
        ButtonGroup dp=new ButtonGroup();
        dp.add(rbmale);
        dp.add(rbfemale);
        
        
        
        JLabel  coun =new JLabel("COUNTRY");
        coun.setBounds(35,240,100,20);
        coun.setBackground(Color.BLACK);
        coun.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(coun);
        
        coun1 =new JTextField();
        coun1.setBounds(200,240,150,25);
        add(coun1);
        
        JLabel  alc =new JLabel("ALOCATED ROOM");
        alc.setBounds(35,280,150,20);
        alc.setBackground(Color.BLACK);
        alc.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(alc);
        
        choice =new Choice();
        
        try
        {
            Conn conn=new Conn();
            String q="select * from room where avlibility= 'Avilible' ";
            ResultSet rs= conn.s.executeQuery(q);
            while(rs.next()){
                choice.add(rs.getString("roomnumber"));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
            
        }
        choice.setForeground(BLACK);
        choice.setBounds(200,280,150,25);
        add(choice);
        
        JLabel  checktim =new JLabel("Checkin Time");
        checktim.setBounds(35,320,150,25);
        checktim.setBackground(Color.BLACK);
        checktim.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(checktim);
        
        Date date=new Date();
        checkin =new JLabel(""+date);
        checkin.setBounds(200,320,150,25);
        checkin.setBackground(Color.BLACK);
        checkin.setFont(new Font("Tahoma",Font.PLAIN,12));
        add(checkin);
        
        JLabel  depost =new JLabel("DEPOSIT");
        depost.setBounds(35,360,150,25);
        depost.setBackground(Color.BLACK);
        depost.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(depost);
        
        depost1 =new JTextField();
        depost1.setBounds(200,360,150,25);
        add(depost1);
        
         add =new JButton("ADD");
        add.setBounds(50,410,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.setFont(new Font("Tahoma",Font.PLAIN,16));
        add.addActionListener(this);
        add(add);
        
         back =new JButton("back");
         back.setBounds(200,410,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);
        
        delete =new JButton("Delete");
         delete.setBounds(50,450,120,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Tahoma",Font.PLAIN,16));
        delete.addActionListener(this);
        add(delete);
        
        update =new JButton("update");
         update.setBounds(200,450,120,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma",Font.PLAIN,16));
        update.addActionListener(this);
        add(update);
        
        
        
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=il.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(400, 50, 300, 400);
         add(image);
        
        
        setLayout(null);
        setBounds(350,200,800,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==add)
        {
            
            String id= (String)cbjob.getSelectedItem();
            String name=tfname.getText();
            String number=num1.getText();
            String gender=null;
            
            
            
            if(rbmale.isSelected())
            {
                gender="male";
               
            }else if(rbfemale.isSelected())
            {
                gender="female";
            }
            String country = coun1.getText();
            String room=choice.getSelectedItem();
            String time=checkin.getText();
            String deposite=depost1.getText();
              try
            {
                 Conn conn=new Conn();
                 String str="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+time+"','"+deposite+"')" ;
                 String str1="update room set avlibility='accpied'where roomnumber = '"+room+"'";
                 conn.s.executeUpdate(str);
                 conn.s.executeUpdate(str1);
                   JOptionPane.showMessageDialog(null, "Customer add successfully ");
                    setVisible(false);
                     new Reception();
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
        }else  if(ae.getSource()==back)
        {
            setVisible(false);
            new Reception();
        }else if(ae.getSource()==update)
        {
            String id= (String)cbjob.getSelectedItem();
            String name=tfname.getText();
            String number=num1.getText();
            String gender=null;
            
            if(rbmale.isSelected())
            {
                gender="male";
               
            }else if(rbfemale.isSelected())
            {
                gender="female";
            }
            String country = coun1.getText();
            String room=choice.getSelectedItem();
            String time=checkin.getText();
            String deposite=depost1.getText();
              try
            {
                 Conn conn=new Conn();
                 String str="update customer set document='"+id+"',number='"+number+"',name='"+name+"',gender='"+gender+"',country='"+country+"',room='"+room+"',checkintime='"+time+"',checkintime='"+time+"',deposite='"+deposite+"'where name= '"+name+"'";
                 String str1="update room set avlibility='accpied'where roomnumber = '"+room+"'";
                 conn.s.executeUpdate(str);
                 conn.s.executeUpdate(str1);
                   JOptionPane.showMessageDialog(null, "Customer update successfully ");
                    setVisible(false);
                     new Reception();
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
        }else if (ae.getSource()==delete)
        {
             String name=tfname.getText();
             String id=(String)cbjob.getSelectedItem();
              String room=choice.getSelectedItem();
            try
            {
                 Conn conn=new Conn();
                 String str="delete from customer where name= '"+name+"'";
                 String str1="update room set avlibility='Avilible'where roomnumber = '"+room+"'";
                 conn.s.executeUpdate(str);
                conn.s.executeUpdate(str1);
                
                   JOptionPane.showMessageDialog(null, "customer Delete successfully ");
                    setVisible(false);
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
    }
    }
    public static void main(String[] arg)
    {
        new Add_Customer(); 
    }
}
    
