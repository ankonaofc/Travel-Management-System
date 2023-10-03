package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookPackage extends JFrame implements ActionListener{
    Choice cpkg;
    JTextField tfpersons;
    JLabel usrname,id,number,phone,price;
    JButton book,back,checkpkg;
    String username;
    BookPackage(String username)
    {
        this.username=username;
        setBounds(350,200,1100,500);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text= new JLabel("BOOK PACKAGE");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        add(lblusername);

        usrname =new JLabel();
        usrname.setBounds(220,70,100,20);
        add(usrname);

        JLabel lblpkg =new JLabel("Select Package");
        lblpkg.setBounds(40,120,100,20);
        add(lblpkg);

        cpkg=new Choice();
        cpkg.add("Gold Package");
        cpkg.add("Silver Package");
        cpkg.add("Bronze Package");
        cpkg.setBounds(220,120,150,20);
        add(cpkg);

        JLabel lblperson =new JLabel("Total Persons");
        lblperson.setBounds(40,170,150,20);
        add(lblperson);

        tfpersons=new JTextField("");
        tfpersons.setBounds(220,170,150,20);
        add(tfpersons);

        JLabel lblid =new JLabel("ID");
        lblid.setBounds(40,220,150,20);
        add(lblid);

        id =new JLabel();
        id.setBounds(220,220,150,20);
        add(id);

        JLabel lblnum =new JLabel("Number");
        lblnum.setBounds(40,270,150,20);
        add(lblnum);

        number =new JLabel();
        number.setBounds(220,270,150,20);
        add(number);

        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(40,320,150,20);
        add(lblphone);

        phone =new JLabel();
        phone.setBounds(220,320,150,20);
        add(phone);

        JLabel lblprice =new JLabel("Total Price");
        lblprice.setBounds(40,370,150,20);
        add(lblprice);

        price =new JLabel();
        price.setBounds(220,370,150,20);
        add(price);

        try
        {
            Conn c=new Conn();
            String query="select *from customer where username= '"+username+"'";
            ResultSet rs=c.s.executeQuery(query);
            while(rs.next())
            {
                usrname.setText(rs.getString("username"));
                id.setText(rs.getString("id"));
                number.setText(rs.getString("number"));
                phone.setText(rs.getString("phone"));

            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        checkpkg=new JButton("Check Price");
        checkpkg.setBackground(Color.BLACK);
        checkpkg.setForeground(Color.WHITE);
        checkpkg.setBounds(60,420,120,25);
        checkpkg.addActionListener(this);
        add(checkpkg);

        book=new JButton("Book Now");
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.setBounds(210,420,100,25);
        book.addActionListener(this);
        add(book);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,420,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpackage.jpg"));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(550,50,500,300);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==checkpkg)
        {
            String pkg=cpkg.getSelectedItem();
            int cost=0;
            if(pkg.equals("Gold Package"))
            {
                cost+=25000;
            }else if(pkg.equals("Silver Package"))
            {
                cost+=12000;
            }else {
                cost+=7000;

            }
            int persons=Integer.parseInt(tfpersons.getText());
            cost *=persons;
            price.setText("Rs "+cost);

        }else if(ae.getSource()==book)
        {
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookpackage values('"+usrname.getText()+"','"+cpkg.getSelectedItem()+"','"+ tfpersons.getText()+"','"+ id.getText()+"','"+ number.getText()+"','"+ phone.getText()+"','"+ price.getText()+"')");

                JOptionPane.showMessageDialog(null,"Package Booked Successfully");
                setVisible(false);
            }catch(Exception e)
            {
                e.printStackTrace();
            }

        }else
        {
            setVisible(false);
            //new Dashboard();
        }

    }

    public static void main(String[] args) {
        new BookPackage("amiya23");

    }
}

