
package hotel_management;

/**
 *
 * @author aaaa
 */
import java.awt.Color;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
public class Login extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField password;
    JButton cancel,login;
    public Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        JLabel user=new JLabel("User Name");
        user.setBounds(40, 20, 100, 30);
        add(user);
        
         username= new JTextField();
         username.setBounds(150, 20, 150, 30);
        add(username);
        
         password= new JPasswordField();
         password.setBounds(150, 70, 150, 30);
        add(password);
         
         JLabel pass=new JLabel("Password");
        pass.setBounds(40, 70, 100, 30);
        add(pass);
        
         login= new JButton("LOGIN");
        login.setBounds(40, 150, 120,30 );
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
         add(login);
         
        cancel= new JButton("Cancel");
        cancel.setBounds(180, 150, 120,30 );
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
         add(cancel);
        
         ImageIcon il=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
         JLabel image = new JLabel(il);
         image.setBounds(350, 10, 200, 200);
         add(image);
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        setBounds(500,200,600,300);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== login)
        {
            String user=username.getText();
            String pass=password.getText();
            try
            {
                Conn c=new Conn();
                String query="select * from login1 where username= '"+user+"'and Password='"+pass+"'";
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Dashboard();
                }else
                {
                    JOptionPane.showMessageDialog(null, "invilade username or Password");
                }
            } catch (Exception e) {
                e.printStackTrace();
                
            }
        } 
        else if(ae.getSource()== cancel)
        {
            setVisible(false);
        }
        
        
    }
    public static void main(String[] args)
    {
        new Login();
    }
    
}
