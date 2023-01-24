/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JLabel;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
/**
 *
 * @author aaaa
 */
public class Check_out extends JFrame implements ActionListener {
    Choice ccustomer;
    JLabel iblroomnum,iblroomnum1,iblroomnum2;
    JButton back,checkout;
    Check_out()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
         JLabel roo = new JLabel(" CHECKOUT ");
         roo.setForeground(Color.BLUE);
         roo.setFont(new Font("Tahoma",Font.PLAIN,20 ));
         roo.setBounds(100, 20, 100, 30);
         add(roo);
         
         
         JLabel cusID = new JLabel(" Customer Id ");
         cusID.setBounds(30, 80, 100, 30);
         add(cusID);
        
         
         ccustomer =new Choice() ;
        ccustomer.setBounds(150,80,150,25);
        add(ccustomer);
        
       
        
         
         JLabel roonum = new JLabel(" Room number ");
         roonum.setBounds(30, 130, 100, 30);
         add(roonum);
         
         iblroomnum=new JLabel();
         iblroomnum.setBounds(150, 130, 100, 30);
        add(iblroomnum);
         
         JLabel  checkin = new JLabel(" Checkintime ");
         checkin.setBounds(30, 180, 100, 30);
         add(checkin);
         
         iblroomnum1=new JLabel();
         iblroomnum1.setBounds(150, 180, 100, 30);
        add(iblroomnum1);
         
         
         JLabel  checkout1 = new JLabel(" Checkouttime ");
         checkout1.setBounds(30, 230, 100, 30);
         add(checkout1);
         
         Date dt=new Date();
         iblroomnum2=new JLabel(""+dt);
         iblroomnum2.setBounds(150, 230, 100, 30);
        add(iblroomnum2);
        
        checkout =new JButton("Chechout");
         checkout.setBounds(30,280,120,30);
        checkout.setBackground(Color.BLACK);
        checkout.setForeground(Color.WHITE);
        checkout.setFont(new Font("Tahoma",Font.PLAIN,16));
        checkout.addActionListener(this);
        add(checkout);
         
        back =new JButton("back");
         back.setBounds(170,280,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma",Font.PLAIN,16));
        back.addActionListener(this);
        add(back);
        
         try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select *from customer");
            while(rs.next())
            {
                ccustomer.add(rs.getString("number"));
                iblroomnum.setText(rs.getString("room"));
                iblroomnum1.setText(rs.getString("checkintime"));
            } 
        }catch (Exception e)
        {
            e.printStackTrace();
        }
         
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i2=il.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(350, 50, 400, 250);
         add(image);
         
        
        
        
        setBounds(300,200,800,400);
        setVisible(true);
        
    }
      public void actionPerformed(ActionEvent ae)
            {
                if (ae.getSource()==checkout)
                {
                    String query1="delete from  customer where number='"+ccustomer+"'";
                    String query2="update room set avlibility= 'Avilible' where roomnumber ='"+iblroomnum.getText()+"'";
                    try
                    {
                        Conn c=new Conn();
                        c.s.executeQuery(query1);
                        c.s.executeQuery(query2);
                        JOptionPane.showMessageDialog(null, "Checkout DONE");
                        setVisible(false);
                        
                    }catch(Exception e)
                    {
                        e.printStackTrace();

                    }
                    
                }else
                {
                    setVisible(false);
                    new Reception();
                }
                
                
                
            }
    public static void main(String[] arg)
    {
        new  Check_out();
    }
}
