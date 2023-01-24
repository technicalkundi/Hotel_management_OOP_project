
package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Dashboard extends JFrame implements ActionListener{
    public Dashboard()
    {
         setBounds(0,0,1500,1000);
         ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
         JLabel image = new JLabel(il);
         image.setBounds(0, 0, 1550, 1000);
         
         JLabel text=new JLabel("THE MARINA HOTEL WELCOME YOU");
         text.setBounds(400, 30, 1000, 50);
         text.setFont(new Font("Tahoma",Font.PLAIN,50));
         text.setForeground(Color.WHITE);
         image.add(text);
         
         JMenuBar e1=new JMenuBar();
         e1.setBounds(0, 0, 1550, 30);
         image.add(e1);
         JMenu Hotel=new JMenu("Hotel Mangament");
         Hotel.setForeground(Color.BLACK);
         e1.add(Hotel);
         
         JMenu Mang=new JMenu("Admin");
         Mang.setForeground(Color.BLACK);
         e1.add(Mang);
          
         JMenuItem reception=new JMenuItem("reception");
         reception.setForeground(Color.BLACK); 
         reception.addActionListener(this);
         Hotel.add(reception);
         
         JMenuItem employee=new JMenuItem("add employee");
         employee.setForeground(Color.BLACK);
         employee.addActionListener(this);
   
         Mang.add(employee);
         
          
         JMenuItem e2=new JMenuItem("add room");
         e2.setForeground(Color.BLACK);
         e2.addActionListener(this);
         Mang.add(e2);
         
          
         JMenuItem e3=new JMenuItem("add Driver");
         e3.setForeground(Color.BLACK);
         e3.addActionListener(this);
         Mang.add(e3);
         
         
         add(image);
         setVisible(true);
         
    }
    public void actionPerformed(ActionEvent ae)
    {
        switch (ae.getActionCommand()) {
            case "add employee":
                new Add_employee();
                break;
            case "add room":
                new Add_rooms();
                break;
            case "add Driver":
                new Add_driver();
                break;
            case "reception":
                new Reception();
                break;
            default:
                break;
        }
        
    }
    public static void main(String[] arg)
    {
        new Dashboard();
    }
    
}

