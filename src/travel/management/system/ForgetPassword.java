package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.sql.ResultSet;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{
    JTextField tfusername,tfname,tfques,tfans,tfpass;
    JButton search,retrieve,back;
    ForgetPassword()
    {
        setBounds(360,250,650,300);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JPanel pl=new JPanel();
        pl.setLayout(null);
        pl.setBounds(15,15,400,230);
        add(pl);

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2= i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(430,40,180,180);
        add(image);

        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(20,20,100,25);
        lblusername.setFont(new Font("Calibri",Font.BOLD,14));
        pl.add(lblusername);

        tfusername=new JTextField();
        tfusername.setBounds(130,20,150,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfusername);

        search=new JButton("Search");
        search.setBackground(Color.GRAY);
        search.setForeground(Color.WHITE);
        search.setBounds(290,20,100,25);
        search.addActionListener(this);
        pl.add(search);

        JLabel lblname = new JLabel("Name");
        lblname.setBounds(20,55,100,25);
        lblname.setFont(new Font("Calibri",Font.BOLD,14));
        pl.add(lblname);

        tfname=new JTextField();
        tfname.setBounds(130,55,150,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfname);

        JLabel lblquestion  = new JLabel("Security question");
        lblquestion.setBounds(20,90,150,25);
        lblquestion.setFont(new Font("Calibri",Font.BOLD,14));
        pl.add(lblquestion);

        tfques=new JTextField();
        tfques.setBounds(130,90,150,25);
        tfques.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfques);

        JLabel lblans  = new JLabel("Answer");
        lblans.setBounds(20,125,150,25);
        lblans.setFont(new Font("Calibri",Font.BOLD,14));
        pl.add(lblans);

        tfans=new JTextField();
        tfans.setBounds(130,125,150,25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfans);

        retrieve=new JButton("Retrieve");
        retrieve.setBackground(Color.GRAY);
        retrieve.setForeground(Color.WHITE);
        retrieve.setBounds(290,125,100,25);
        retrieve.addActionListener(this);
        pl.add(retrieve);

        JLabel lblpass  = new JLabel("Password");
        lblpass.setBounds(20,160,150,25);
        lblpass.setFont(new Font("Calibri",Font.BOLD,14));
        pl.add(lblpass);

        tfpass=new JTextField();
        tfpass.setBounds(130,160,150,25);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        pl.add(tfpass);

        back=new JButton("Back");
        back.setBackground(Color.GRAY);
        back.setForeground(Color.WHITE);
        back.setBounds(130,195,100,25);
        back.addActionListener(this);
        pl.add(back);


        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
           try
           {
               String query="select *from account where username = '"+tfusername.getText()+"'";
               Conn c=new Conn();
               ResultSet rs= c.s.executeQuery(query);
               while(rs.next())
               {
                  tfname.setText(rs.getString("name"));
                  tfques.setText(rs.getString("security"));
               }
           }catch(Exception e)
           {
               e.printStackTrace();
           }
        }
        else if(ae.getSource()==retrieve)
        {
            try{
                String query="select *from account where ans = '"+tfans.getText()+"' and username = '"+tfusername.getText()+"'";
                Conn c=new Conn();
                ResultSet rs= c.s.executeQuery(query);
                while(rs.next())
                {
                    tfpass.setText(rs.getString("password"));
                }

            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Login();
        }
    }
    public static void main(String[] args) {
        new ForgetPassword();
    }
}
