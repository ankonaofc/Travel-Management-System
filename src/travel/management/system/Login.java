package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;
public class Login extends JFrame implements ActionListener {
    JButton login,sign,forget;
    JTextField tfusername,tfpass;
    Login()
    {
        setSize(700,300);
        setLocation(400,250);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JPanel pl=new JPanel();
        pl.setBackground(new Color(131,193,233));
        pl.setBounds(0,0,300,400);
        setLayout(null);
        add(pl);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(120,120,200,200);
        pl.add(image);

        JPanel pl2=new JPanel();
        pl2.setLayout(null);
        pl2.setBounds(250,30,400,200);
        add(pl2);

        JLabel username= new JLabel("Username");
        username.setBounds(60,20,100,25);
        username.setFont(new Font("CALIBRI",Font.PLAIN,15));
        pl2.add(username);

        tfusername= new JTextField();
        tfusername.setBounds(60,50,300,20);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        pl2.add(tfusername);

        JLabel pass= new JLabel("Password");
        pass.setBounds(60,80,100,25);
        pass.setFont(new Font("CALIBRI",Font.PLAIN,15));
        pl2.add(pass);

        tfpass= new JTextField();
        tfpass.setBounds(60,110,300,20);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        pl2.add(tfpass);

        login=new JButton("Login");
        login.setBounds(60,140,120,20);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        pl2.add(login);

        sign=new JButton("Signup");
        sign.setBounds(200,140,120,20);
        sign.setBackground(new Color(133,193,233));
        sign.setForeground(Color.WHITE);
        sign.setBorder(new LineBorder(new Color(133,193,233)));
        sign.addActionListener(this);
        pl2.add(sign);

        forget=new JButton("Forget Password");
        forget.setBounds(140,170,120,20);
        forget.setBackground(new Color(133,193,233));
        forget.setForeground(Color.WHITE);
        forget.setBorder(new LineBorder(new Color(133,193,233)));
        forget.addActionListener(this);
        pl2.add(forget);

        /*JLabel text=new JLabel("Trouble in Logging");
        text.setBounds(266,170,120,20);
        text.setForeground(Color.RED);
        pl2.add(text);*/

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            try{
                String username=tfusername.getText();
                String pass=tfpass.getText();

                String query="select *from account where username='"+username+"' and password='"+pass+"'";
                Conn c=new Conn();
                c.s.executeQuery(query);
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Loading(username);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Incorrect message or password");
                }
                {

                }

            }catch(Exception e)
            {
                e.printStackTrace();
            }

        }else if(ae.getSource()==sign)
        {
            setVisible(false);
            new Signup();
        }else {
            setVisible(false);
            new ForgetPassword();
        }
    }
    public static void main(String[] args) {
       new Login();
    }
}
