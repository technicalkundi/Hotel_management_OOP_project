/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel_management;

import java.awt.Color;
import java.awt.Font;
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
public class Hotel_management extends JFrame implements ActionListener{
        public Hotel_management(){
         setSize(1355,555);
        setLocation(100,100);
        ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image=new JLabel(il);
        add(image);
        setVisible(true);
        JLabel text=new JLabel("HOTEL MANAGEMENT SYSTEM");
        text.setBounds(20,430,1000,90);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("serif",Font.PLAIN,50));
        JButton next=new JButton("NEXT");
        next.setBounds(1150,450,150,50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        image.add(next);
        image.add(text);
        next.addActionListener(this);
         
        }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        // TODO code application logic here
       new Hotel_management(); 
       
    }
    
}
