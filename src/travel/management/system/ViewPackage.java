package travel.management.system;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;

public class ViewPackage extends JFrame implements ActionListener {
    JButton back;
    ViewPackage(String username)
    {
        setBounds(450,200,900,450);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel text =new JLabel("VIEW PACKAGE DETAILS");
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        text.setBounds(60,10,300,30);
        add(text);

        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(40,50,150,25);
        add(lblusername);

        JLabel usrname =new JLabel();
        usrname.setBounds(220,50,150,25);
        add(usrname);

        JLabel lblpkg =new JLabel("Package");
        lblpkg.setBounds(40,90,150,25);
        add(lblpkg);

        JLabel pkg =new JLabel();
        pkg.setBounds(220,90,150,25);
        add(pkg);

        JLabel lblperson =new JLabel("Number of persons");
        lblperson.setBounds(40,130,150,25);
        add(lblperson);

        JLabel persons =new JLabel();
        persons.setBounds(220,130,150,25);
        add(persons);

        JLabel lblid =new JLabel("ID");
        lblid.setBounds(40,170,150,25);
        add(lblid);

        JLabel id =new JLabel();
        id.setBounds(220,170,150,25);
        add(id);

        JLabel lblnum =new JLabel("Number");
        lblnum.setBounds(40,210,150,25);
        add(lblnum);

        JLabel num =new JLabel();
        num.setBounds(220,210,150,25);
        add(num);

        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(40,250,150,25);
        add(lblphone);

        JLabel phone =new JLabel();
        phone.setBounds(220,250,150,25);
        add(phone);

        JLabel lblprice =new JLabel("Total Price");
        lblprice.setBounds(40,290,150,20);
        add(lblprice);

        JLabel price =new JLabel();
        price.setBounds(220,290,150,20);
        add(price);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(130,360,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookedDetails.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(450,20,500,400);
        add(image);


        try
        {
            Conn c=new Conn();
            String query="select *from bookpackage where username= '"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                usrname.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                num.setText(rs.getString("number"));
                pkg.setText(rs.getString("package"));
                phone.setText(rs.getString("phone"));
                price.setText(rs.getString("price"));
                persons.setText(rs.getString("persons"));

            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }

    public static void main(String[] args) {
        new ViewPackage("amiya23");
    }
}
