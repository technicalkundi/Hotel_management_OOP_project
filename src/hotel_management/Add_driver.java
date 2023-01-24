package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
/**
 *
 * @author aaaa
 */
public class Add_driver extends JFrame implements ActionListener{

    JTextField tfage,tfname,tfcompany,tfmodel;
    JButton addroo,cancel,update,delete;
    JComboBox avb,avp,avi,age,age1;       
    Add_driver()

    {
        setLayout(null);
        
        JLabel addroom=new JLabel("ADD DRIVERS");
        addroom.setBounds(150,20,200,20);
        addroom.setBackground(Color.BLACK);
        addroom.setFont(new Font("Tahoma",Font.BOLD,18));
        add(addroom);
        
        JLabel  roomnumber =new JLabel("NAME");
        roomnumber.setBounds(60,80,120,20);
        roomnumber.setBackground(Color.BLACK);
        roomnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(roomnumber);
        
        tfname=new JTextField();
        tfname.setBounds(200,80,150,30);
        add(tfname);
        
        JLabel  avalible =new JLabel("AGE");
        avalible.setBounds(60,130,120,20);
        avalible.setBackground(Color.BLACK);
        avalible.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(avalible);
        
        tfage=new JTextField();
        tfage.setBounds(200,130,150,30);
        add(tfage);
        
        JLabel  clean =new JLabel("Gender");
        clean.setBounds(60,180,120,20);
        clean.setBackground(Color.BLACK);
        clean.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(clean);
        
        
        String stp[]={"MALE","FEMALE"};
        age=new JComboBox(stp);
        age.setBounds(200, 180, 150, 30);
        age.setBackground(Color.white);
        add(age);
        
        JLabel  price =new JLabel("CAR COMPANY");
        price.setBounds(60,230,120,20);
        price.setBackground(Color.BLACK);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);
        
        tfcompany=new JTextField();
        tfcompany.setBounds(200,230,150,30);
        add(tfcompany);
        
        JLabel  bedtype =new JLabel("MODEL");
        bedtype.setBounds(60,280,120,20);
        bedtype.setBackground(Color.BLACK);
        bedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(bedtype);
        
        JLabel   avilible=new JLabel("Avilibility");
        avilible.setBounds(60,330,120,20);
        avilible.setBackground(Color.BLACK);
        avilible.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(avilible);
        
        String sta[]={"AVILIBLE","NOT AVILIBLE"};
        age1=new JComboBox(sta);
        age1.setBounds(200, 330, 150, 30);
        age1.setBackground(Color.white);
        add(age1);
        
        
        tfmodel=new JTextField();
        tfmodel.setBounds(200,280,150,30);
        add(tfmodel);
        
        addroo =new JButton("Add Driver");
        addroo.setBounds(60,380,130,30);
        addroo.setBackground(Color.BLACK);
        addroo.setForeground(Color.WHITE);
        addroo.setFont(new Font("Tahoma",Font.PLAIN,16));
        addroo.addActionListener(this);
        add(addroo);
        
         update  =new JButton("Update");
        update.setBounds(380,380,130,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma",Font.PLAIN,16));
        update.addActionListener(this);
        add(update);
        
         delete =new JButton("Delete");
        delete.setBounds(540,380,130,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Tahoma",Font.PLAIN,16));
        delete.addActionListener(this);
        add(delete);
        
        
        cancel =new JButton("Cancel");
        cancel.setBounds(220,380,130,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Tahoma",Font.PLAIN,16));
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2=il.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(400, 30, 500, 300);
         add(image);
        
        getContentPane().setBackground(Color.white);
        setBounds(300,200,980,470);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addroo)
        {
            String name=tfname.getText();
            String age2 = tfage.getText();
            String gender=(String)age.getSelectedItem();
            String company=tfcompany.getText();
            String model= tfmodel.getText();
            String avilibilty=(String)age1.getSelectedItem();
            try
            {
                 Conn conn=new Conn();
                 String str="insert into driver values('"+name+"','"+age2+"','"+gender+"','"+company+"','"+model+"','"+avilibilty+"')" ;
                 conn.s.executeUpdate(str);
                
                
                   JOptionPane.showMessageDialog(null, "driver added successfully ");
                    setVisible(false);
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
            
            
        }else if(ae.getSource()== update)
        {
            
            String name=tfname.getText();
            String age2 = tfage.getText();
            String gender=(String)age.getSelectedItem();
            String company=tfcompany.getText();
            String model= tfmodel.getText();
            String avilibilty=(String)age1.getSelectedItem();
            try
            {
                 Conn conn=new Conn();
                 String str="update driver set age='"+age2+"',gender='"+gender+"',car_company='"+company+"',model='"+model+"',aviliblity='"+avilibilty+"'where name= '"+name+"'";
                 conn.s.executeUpdate(str);
                
                
                   JOptionPane.showMessageDialog(null, "driver Update successfully ");
                    setVisible(false);
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
        }
        else if(ae.getSource()==delete)
        {
             
            String name=tfname.getText();
            
            try
            {
                 Conn conn=new Conn();
                 String str="delete from driver where name= '"+name+"'";
                 conn.s.executeUpdate(str);
                
                
                   JOptionPane.showMessageDialog(null, "driver delete successfully ");
                    setVisible(false);
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
        }
        else
        {
            setVisible(false);
        }
        
    }
    
    public static void main(String[] arg)
    {
        new Add_driver();
    }
    
}
