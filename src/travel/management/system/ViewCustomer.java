package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener {
    JButton back;
    ViewCustomer(String username)
    {
        setBounds(450,180,870,625);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(50,50,150,25);
        add(lblusername);

        JLabel usrname =new JLabel();
        usrname.setBounds(220,50,150,25);
        add(usrname);

        JLabel lblid =new JLabel("ID");
        lblid.setBounds(50,110,150,25);
        add(lblid);

        JLabel id =new JLabel();
        id.setBounds(220,110,150,25);
        add(id);

        JLabel lblnum =new JLabel("Number");
        lblnum.setBounds(50,170,150,25);
        add(lblnum);

        JLabel num =new JLabel();
        num.setBounds(220,170,150,25);
        add(num);

        JLabel lblname =new JLabel("Name");
        lblname.setBounds(50,230,150,25);
        add(lblname);

        JLabel name =new JLabel();
        name.setBounds(220,230,150,25);
        add(name);

        JLabel lblgender =new JLabel("Gender");
        lblgender.setBounds(50,290,150,25);
        add(lblgender);

        JLabel gender =new JLabel();
        gender.setBounds(220,290,150,25);
        add(gender);

        JLabel lblcntry =new JLabel("Country");
        lblcntry.setBounds(470,50,150,25);
        add(lblcntry);

        JLabel country =new JLabel();
        country.setBounds(650,50,150,25);
        add(country);

        JLabel lbladdress =new JLabel("Address");
        lbladdress.setBounds(470,110,150,25);
        add(lbladdress);

        JLabel address =new JLabel();
        address.setBounds(650,110,150,25);
        add(address);

        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(470,170,150,25);
        add(lblphone);

        JLabel phone =new JLabel();
        phone.setBounds(650,170,150,25);
        add(phone);

        JLabel lblemail =new JLabel("Email");
        lblemail.setBounds(470,230,150,25);
        add(lblemail);

        JLabel email =new JLabel();
        email.setBounds(650,230,150,25);
        add(email);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,350,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(20,400,600,200);
        add(image);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/viewall.jpg"));
        Image i5=i4.getImage().getScaledInstance(600,200,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image2=new JLabel(i6);
        image2.setBounds(600,400,600,200);
        add(image2);

        try
        {
            Conn c=new Conn();
            String query="select *from customer where username= '"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                usrname.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                num.setText(rs.getString("number"));
                name.setText(rs.getString("name"));
                gender.setText(rs.getString("gender"));
                country.setText(rs.getString("country"));
                address.setText(rs.getString("address"));
                phone.setText(rs.getString("phone"));
                email.setText(rs.getString("email"));
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
        new ViewCustomer("amiya23");
    }
}
