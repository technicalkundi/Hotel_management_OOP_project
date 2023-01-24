
package hotel_management;

import java.awt.Color;
import java.awt.Font;
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
public class Add_rooms extends JFrame implements ActionListener{

    JTextField pn,rn;
    JButton addroo,cancel,update,delete;
    JComboBox avb,avp,avi;       
    Add_rooms()

    {
        setLayout(null);
        
        JLabel addroom=new JLabel("ADD ROOM");
        addroom.setBounds(150,20,200,20);
        addroom.setBackground(Color.BLACK);
        addroom.setFont(new Font("Tahoma",Font.BOLD,18));
        add(addroom);
        
        JLabel  roomnumber =new JLabel("Room Number");
        roomnumber.setBounds(60,80,120,20);
        roomnumber.setBackground(Color.BLACK);
        roomnumber.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(roomnumber);
        
        rn=new JTextField();
        rn.setBounds(200,80,150,30);
        add(rn);
        
        JLabel  avalible =new JLabel("Avalible");
        avalible.setBounds(60,130,120,20);
        avalible.setBackground(Color.BLACK);
        avalible.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(avalible);
        
        
        String str[]={"Avilible","Not Avilible"};
        avi=new JComboBox(str);
        avi.setBounds(200, 130, 150, 30);
        avi.setBackground(Color.white);
        add(avi);
        
        JLabel  clean =new JLabel("Clean Status");
        clean.setBounds(60,180,120,20);
        clean.setBackground(Color.BLACK);
        clean.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(clean);
        
        
        String stp[]={"clean","Not clean"};
        avp=new JComboBox(stp);
        avp.setBounds(200, 180, 150, 30);
        avp.setBackground(Color.white);
        add(avp);
        
        JLabel  price =new JLabel("Price");
        price.setBounds(60,230,120,20);
        price.setBackground(Color.BLACK);
        price.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(price);
        
        pn=new JTextField();
        pn.setBounds(200,230,150,30);
        add(pn);
        
        JLabel  bedtype =new JLabel("bed Type");
        bedtype.setBounds(60,280,120,20);
        bedtype.setBackground(Color.BLACK);
        bedtype.setFont(new Font("Tahoma",Font.PLAIN,16));
        add(bedtype);
        
        String stb[]={"Single" ,"Double bed","Traple bed","four bed"};
        avb=new JComboBox(stb);
        avb.setBounds(200, 280, 150, 30);
        avb.setBackground(Color.white);
        add(avb);
        
        addroo =new JButton("Add Room");
        addroo.setBounds(60,330,130,30);
        addroo.setBackground(Color.BLACK);
        addroo.setForeground(Color.WHITE);
        addroo.setFont(new Font("Tahoma",Font.PLAIN,16));
        addroo.addActionListener(this);
        add(addroo);
        
        
        update =new JButton("Update");
        update.setBounds(60,380,130,30);
        update.setBackground(Color.BLACK);
        update.setForeground(Color.WHITE);
        update.setFont(new Font("Tahoma",Font.PLAIN,16));
        update.addActionListener(this);
        add(update);
        
        delete =new JButton("DELETE");
        delete.setBounds(220,330,130,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.setFont(new Font("Tahoma",Font.PLAIN,16));
        delete.addActionListener(this);
        add(delete);
        
       
         ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
         JLabel image = new JLabel(il);
         image.setBounds(400, 30, 500, 300);
         add(image);
        
        getContentPane().setBackground(Color.white);
        setBounds(330,200,940,470);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==addroo)
        {
            String roomnumber=rn.getText();
            String avalible=(String)avi.getSelectedItem();
            String status=(String)avp.getSelectedItem();
            String price= pn.getText();
            String bedtype=(String)avb.getSelectedItem();
            try
            {
                 Conn conn=new Conn();
                 String str="insert into room values('"+roomnumber+"','"+avalible+"','"+status+"','"+price+"','"+bedtype+"')" ;
                 conn.s.executeUpdate(str);
                
                
                   JOptionPane.showMessageDialog(null, "room add successfully ");
                    setVisible(false);
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
            
            
        }else if (ae.getSource()==update)
        {
             String roomnumber=rn.getText();
            String avalible=(String)avi.getSelectedItem();
            String status=(String)avp.getSelectedItem();
            String price= pn.getText();
            String bedtype=(String)avb.getSelectedItem();
            try
            {
                 Conn conn=new Conn();
                 String str="update room set roomnumber='"+roomnumber+"',avlibility='"+avalible+"',cleaning_status='"+status+"',price='"+price+"',bed_type='"+bedtype+"'where roomnumber= '"+roomnumber+"'";
                 conn.s.executeUpdate(str);
                
                
                   JOptionPane.showMessageDialog(null, "room UPDATE successfully ");
                    setVisible(false);
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
            
        }else if (ae.getSource()==delete)
        {
             String roomnumber=rn.getText();
            try
            {
                 Conn conn=new Conn();
                 String str="delete from room where roomnumber= '"+roomnumber+"'";
                 conn.s.executeUpdate(str);
                 
                
                
                   JOptionPane.showMessageDialog(null, "room Delete successfully ");
                    setVisible(false);
            } catch(Exception e)
            {
                e.printStackTrace(); 
            }
        }
    }
    public static void main(String[] arg)
    {
        new Add_rooms();
    }
    
}
