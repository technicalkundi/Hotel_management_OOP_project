/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author aaaa
 */
public class Add_employee extends JFrame implements ActionListener  {
    
    JTextField tfname, tsname,psname,tename,thname;
    JRadioButton rbmale,rbfemale;
    JButton sun,update,cancel;
    JComboBox cbjob;
    
    Add_employee()
    {
        setLayout(null);
        JLabel iblname=new JLabel("name");
        iblname.setBounds(60,30,120,30);
        iblname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(iblname);
        
        tfname= new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);
        
        JLabel illname=new JLabel("Age");
        illname.setBounds(60,80,120,30);
        illname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(illname);
        
        tsname= new JTextField();
        tsname.setBounds(200,80,150,30);
        add(tsname);
        
        JLabel islname=new JLabel("Gender");
        islname.setBounds(60,130,120,30);
        islname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(islname);
        
         rbmale=new JRadioButton("Male");
        rbmale.setFont(new Font("Tahoma",Font.PLAIN,13));
        rbmale.setBounds(200,130,70,30);
        add(rbmale);
        
        
          rbfemale=new JRadioButton("Female");
         rbfemale.setFont(new Font("Tahoma",Font.PLAIN,13));
        rbfemale.setBounds(280,130,70,30);
        add(rbfemale);
        
        ButtonGroup dp=new ButtonGroup();
        dp.add(rbmale);
        dp.add(rbfemale);
        
        
        JLabel job=new JLabel("JOB");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(job);
        
        String str[]={"Front desk Clark","porters","HouseKeeping","Driver","KitchenStaff","Room Services","Chefs"};
        cbjob=new JComboBox(str);
        cbjob.setBackground(Color.WHITE);
        cbjob.setBounds(200,180,150,30);
        add(cbjob);
        
          JLabel iplname=new JLabel("SALARY");
        iplname.setBounds(60,230,120,30);
        iplname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(iplname);
        
        psname = new JTextField();
        psname.setBounds(200,230,150,30);
        add(psname);
        
          JLabel iqlname=new JLabel("Email");
        iqlname.setBounds(60,280,120,30);
        iqlname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(iqlname);
        
        tename= new JTextField();
        tename.setBounds(200,280,150,30);
        add(tename);
        
          JLabel ihlname=new JLabel("PHONE #");
        ihlname.setBounds(60,330,120,30);
        ihlname.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(ihlname);
        
        thname= new JTextField();
        thname.setBounds(200,330,150,30);
        add(thname);
        
        sun =new JButton("Submit");
        sun.setBackground(Color.BLACK);
        sun.setForeground(Color.WHITE);
        sun.setBounds(200, 380, 150, 30);
        sun.addActionListener(this);
        add(sun);
        
        update=new JButton("UPDETE");
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setBounds(40, 380, 150, 30);
        update.addActionListener(this);
        add(update);
        
        cancel=new JButton("DELETE");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(120, 420, 150, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        
         ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
         JLabel image = new JLabel(il);
         image.setBounds(380, 60, 450, 450);
         add(image);

        
        
        getContentPane().setBackground(Color.white);
        setBounds(350,200,850,540);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==sun)
        {
            String name=tfname.getText();
        String age=tsname.getText();
        String salary=psname.getText();
        String email=tename.getText();
        String phone=thname.getText();
        
        String gender= null;
        
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Name is empty");
                    return;
        }
        
        if(rbmale.isSelected())
        {
            gender="male";

        } else if(rbfemale.isSelected())
        {
            gender="female";
        }       
        
        String job=(String)cbjob.getSelectedItem();
        
        try
        {
            Conn conn = new Conn();
            String g="insert into empyee1 values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"')";
            conn.s.executeUpdate(g);
            JOptionPane.showMessageDialog(null, "Employee add successfully ");
                    setVisible(false);
        } catch(Exception e)
                {
                    e.printStackTrace();  
        
                }
                
        } else if(ae.getSource()==update)
        {
            String name=tfname.getText();
        String age=tsname.getText();
        String salary=psname.getText();
        String email=tename.getText();
        String phone=thname.getText();
        
        String gender= null;
        
        if(name.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Name is empty");
                    return;
        }
        
        if(rbmale.isSelected())
        {
            gender="male";

        } else if(rbfemale.isSelected())
        {
            gender="female";
        }       
        
        String job=(String)cbjob.getSelectedItem();
        
        try
        {
            Conn conn = new Conn();
            String g1="update empyee1 set age='"+age+"',gender='"+gender+"',job='"+job+"',salary='"+salary+"',phone='"+phone+"',email='"+email+"'where name= '"+name+"'";
              
            conn.s.executeUpdate(g1);
            JOptionPane.showMessageDialog(null, "Employee update successfully ");
                    setVisible(false);
        } catch(Exception e)
                {
                    e.printStackTrace();  
        
                }
        }
        else if(ae.getSource()==cancel)
        {
             String name=tfname.getText();
       
        try
        {
            Conn conn = new Conn();
            String g1="delete from empyee1 where name= '"+name+"'";
              
            conn.s.executeUpdate(g1);
            JOptionPane.showMessageDialog(null, "Employee Delete successfully ");
                    setVisible(false);
        } catch(Exception e)
                {
                    e.printStackTrace();  
        
                }
        }
        
        
        
    }
    public static void main(String[] arg)
    {
        new Add_employee();
    }
    
}
   
