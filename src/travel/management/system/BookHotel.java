package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class BookHotel extends JFrame implements ActionListener{
    Choice chotel,cac,cfood;
    JTextField tfpersons,tfdays,ac;
    JLabel usrname,id,number,phone,price;
    JButton book,back,checkprice;
    String username;
    BookHotel(String username)
    {
        this.username=username;
        setBounds(350,200,1100,600);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel text= new JLabel("BOOK HOTEL");
        text.setBounds(100,10,200,30);
        text.setFont(new Font("Tahoma",Font.BOLD,20));
        add(text);

        JLabel lblusername =new JLabel("Username");
        lblusername.setBounds(40,70,100,20);
        add(lblusername);

        usrname =new JLabel();
        usrname.setBounds(220,70,100,20);
        add(usrname);

        JLabel lblhtl =new JLabel("Select Hotel");
        lblhtl.setBounds(40,110,100,20);
        add(lblhtl);

        chotel=new Choice();
        chotel.setBounds(220,110,150,20);
        add(chotel);

        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select *from hotel");
            while(rs.next())
            {
                chotel.add(rs.getString("name"));

            }

        }catch(Exception e)
        {
            e.printStackTrace();
        }

        JLabel lblperson =new JLabel("Total Persons");
        lblperson.setBounds(40,150,150,20);
        add(lblperson);

        tfpersons=new JTextField();
        tfpersons.setBounds(220,150,150,20);
        add(tfpersons);

        JLabel lbldays =new JLabel("No of Days");
        lbldays.setBounds(40,190,150,20);
        add(lbldays);

        tfdays=new JTextField();
        tfdays.setBounds(220,190,150,20);
        add(tfdays);

        JLabel lblac =new JLabel("AC/Non-AC");
        lblac.setBounds(40,230,150,20);
        add(lblac);

        cac=new Choice();
        cac.add("AC");
        cac.add("Non-AC");
        cac.setBounds(220,230,150,20);
        add(cac);

        JLabel lblfood =new JLabel("Food Included");
        lblfood.setBounds(40,270,150,20);
        add(lblfood);

        cfood=new Choice();
        cfood.add("Yes");
        cfood.add("No");
        cfood.setBounds(220,270,150,20);
        add(cfood);

        JLabel lblid =new JLabel("ID");
        lblid.setBounds(40,310,150,20);
        add(lblid);

        id =new JLabel();
        id.setBounds(220,310,150,20);
        add(id);

        JLabel lblnum =new JLabel("Number");
        lblnum.setBounds(40,350,150,20);
        add(lblnum);

        number =new JLabel();
        number.setBounds(220,350,150,20);
        add(number);

        JLabel lblphone =new JLabel("Phone");
        lblphone.setBounds(40,390,150,20);
        add(lblphone);

        phone =new JLabel();
        phone.setBounds(220,390,150,20);
        add(phone);

        JLabel lblprice =new JLabel("Total Price");
        lblprice.setBounds(40,430,150,20);
        add(lblprice);

        price =new JLabel();
        price.setBounds(220,430,150,20);
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

        checkprice=new JButton("Check Price");
        checkprice.setBackground(Color.BLACK);
        checkprice.setForeground(Color.WHITE);
        checkprice.setBounds(60,470,120,25);
        checkprice.addActionListener(this);
        add(checkprice);

        book=new JButton("Book Now");
        book.setBackground(Color.BLACK);
        book.setForeground(Color.WHITE);
        book.setBounds(210,470,100,25);
        book.addActionListener(this);
        add(book);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(340,470,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/book.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,50,600,400);
        add(image);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==checkprice)
        {
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select *from hotel where name='" + chotel.getSelectedItem() + "'");
                while(rs.next())
                {
                   int cost=Integer.parseInt(rs.getString("costperperson"));
                   int food=Integer.parseInt(rs.getString("foodincluded"));
                   int ac=Integer.parseInt(rs.getString("acroom"));
                   int persons=Integer.parseInt(tfpersons.getText());
                   int days=Integer.parseInt(tfdays.getText());
                   String acselected=cac.getSelectedItem();
                   String foodselected=cfood.getSelectedItem();
                   if(persons*days>0)
                   {
                       int total=0;
                       total+=acselected.equals("AC")?ac:0;
                       total+=foodselected.equals("Yes")?food:0;
                       total+=cost;
                       total=total*persons*days;
                       price.setText("Rs "+total);
                   }else
                   {
                       JOptionPane.showMessageDialog(null,"Please enter a valid number");
                   }

                }}catch(Exception e)
            {
                e.printStackTrace();
            }

        }else if(ae.getSource()==book)
        {
            try{
                Conn c=new Conn();
                c.s.executeUpdate("insert into bookhotel values('"+usrname.getText()+"','"+chotel.getSelectedItem()+"','"+ tfpersons.getText()+"','"+tfdays.getText()+"','"+cac.getSelectedItem()+"','"+cfood.getSelectedItem()+"','"+ id.getText()+"','"+ number.getText()+"','"+ phone.getText()+"','"+ price.getText()+"')");

                JOptionPane.showMessageDialog(null,"Hotel Booked Successfully");
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
        new BookHotel("amiya23");
    }
}
