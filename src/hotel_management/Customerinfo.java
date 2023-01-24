/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel_management;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class Customerinfo extends JFrame implements ActionListener {

    JTable table;
    JButton back;

    Customerinfo() {
        setLayout(null);

        JLabel roo = new JLabel("ID_TYPE");
        roo.setBounds(10, 10, 100, 20);
        add(roo);

        JLabel avi = new JLabel("NAME");
        avi.setBounds(170, 10, 100, 20);
        add(avi);

        JLabel sta = new JLabel("ID_NO");
        sta.setBounds(290, 10, 100, 20);
        add(sta);

        JLabel pri = new JLabel("GENDER");
        pri.setBounds(410, 10, 100, 20);
        add(pri);

        JLabel bed = new JLabel("COUNTRY");
        bed.setBounds(520, 10, 100, 20);
        add(bed);

        JLabel bed1 = new JLabel("ROOM ALOT");
        bed1.setBounds(630, 10, 100, 20);
        add(bed1);

        JLabel bed2 = new JLabel("CHECKIN TIME");
        bed2.setBounds(760, 10, 100, 20);
        add(bed2);
        
         JLabel bed3 = new JLabel("DEPOSITE");
        bed3.setBounds(890, 10, 100, 20);
        add(bed3);

        back = new JButton("back");
        back.setBounds(450, 410, 120, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setFont(new Font("Tahoma", Font.PLAIN, 16));
        back.addActionListener(this);
        add(back);

        table = new JTable();
        table.setBounds(0, 40, 1000, 400);
        add(table);
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            e.printStackTrace();
        }

        getContentPane().setBackground(Color.white);
        setBounds(300, 200, 1050, 600);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == back) {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] arg) {
        new Customerinfo();
    }
}
