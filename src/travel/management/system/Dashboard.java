package travel.management.system;
import com.mysql.cj.QueryReturnType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addDetails,viewDetails,updateDetails,checkPackage,bookPackage,viewPackage,viewHotels,destination,bookHotels,viewBookedHotel,payments,calculator,deleteDetails,about;
    Dashboard(String username)
    {
        this.username=username;
        //setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel pl=new JPanel();
        pl.setLayout(null);
        pl.setBackground(new Color(0,0,102));
        pl.setBounds(0,0,1600,65);
        add(pl);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2=i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel icon=new JLabel(i3);
        icon.setBounds(5,0,70,70);
        pl.add(icon);

        JLabel heading =new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma",Font.BOLD,30));
        pl.add(heading);

        JPanel pl2=new JPanel();
        pl2.setLayout(null);
        pl2.setBackground(new Color(0,0,100));
        pl2.setBounds(0,65,300,900);
        add(pl2);

        addDetails= new JButton("Add Personal Details");
        addDetails.setBounds(0,0,300,50);
        addDetails.setBackground(new Color(0,0,102));
        addDetails.setForeground(Color.WHITE);
        addDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        addDetails.setMargin(new Insets(0,0,0,60));
        addDetails.addActionListener(this);
        pl2.add(addDetails);

        updateDetails= new JButton("Update Personal Details");
        updateDetails.setBounds(0,50,300,50);
        updateDetails.setBackground(new Color(0,0,102));
        updateDetails.setForeground(Color.WHITE);
        updateDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        updateDetails.setMargin(new Insets(0,0,0,40));
        updateDetails.addActionListener(this);
        pl2.add(updateDetails);

        viewDetails= new JButton("View Details");
        viewDetails.setBounds(0,100,300,50);
        viewDetails.setBackground(new Color(0,0,102));
        viewDetails.setForeground(Color.WHITE);
        viewDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewDetails.setMargin(new Insets(0,0,0,140));
        viewDetails.addActionListener(this);
        pl2.add(viewDetails);

        deleteDetails= new JButton("Delete Personal Details");
        deleteDetails.setBounds(0,150,300,50);
        deleteDetails.setBackground(new Color(0,0,102));
        deleteDetails.setForeground(Color.WHITE);
        deleteDetails.setFont(new Font("Tahoma",Font.PLAIN,20));
        deleteDetails.setMargin(new Insets(0,0,0,50));
        deleteDetails.addActionListener(this);
        pl2.add(deleteDetails);

        checkPackage= new JButton("Check Packages");
        checkPackage.setBounds(0,200,300,50);
        checkPackage.setBackground(new Color(0,0,102));
        checkPackage.setForeground(Color.WHITE);
        checkPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        checkPackage.setMargin(new Insets(0,0,0,110));
        checkPackage.addActionListener(this);
        pl2.add(checkPackage);

        bookPackage= new JButton("Book Packages");
        bookPackage.setBounds(0,250,300,50);
        bookPackage.setBackground(new Color(0,0,102));
        bookPackage.setForeground(Color.WHITE);
        bookPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookPackage.setMargin(new Insets(0,0,0,120));
        bookPackage.addActionListener(this);
        pl2.add(bookPackage);

        viewPackage= new JButton("View Packages");
        viewPackage.setBounds(0,300,300,50);
        viewPackage.setBackground(new Color(0,0,102));
        viewPackage.setForeground(Color.WHITE);
        viewPackage.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewPackage.setMargin(new Insets(0,0,0,120));
        viewPackage.addActionListener(this);
        pl2.add(viewPackage);

        viewHotels= new JButton("View Hotels");
        viewHotels.setBounds(0,350,300,50);
        viewHotels.setBackground(new Color(0,0,102));
        viewHotels.setForeground(Color.WHITE);
        viewHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewHotels.setMargin(new Insets(0,0,0,140));
        viewHotels.addActionListener(this);
        pl2.add(viewHotels);

        bookHotels= new JButton("Book Hotels");
        bookHotels.setBounds(0,400,300,50);
        bookHotels.setBackground(new Color(0,0,102));
        bookHotels.setForeground(Color.WHITE);
        bookHotels.setFont(new Font("Tahoma",Font.PLAIN,20));
        bookHotels.setMargin(new Insets(0,0,0,140));
        bookHotels.addActionListener(this);
        pl2.add(bookHotels);

        viewBookedHotel= new JButton("View Booked Hotels");
        viewBookedHotel.setBounds(0,450,300,50);
        viewBookedHotel.setBackground(new Color(0,0,102));
        viewBookedHotel.setForeground(Color.WHITE);
        viewBookedHotel.setFont(new Font("Tahoma",Font.PLAIN,20));
        viewBookedHotel.setMargin(new Insets(0,0,0,70));
        viewBookedHotel.addActionListener(this);
        pl2.add(viewBookedHotel);

        destination= new JButton("Destinations");
        destination.setBounds(0,500,300,50);
        destination.setBackground(new Color(0,0,102));
        destination.setForeground(Color.WHITE);
        destination.setFont(new Font("Tahoma",Font.PLAIN,20));
        destination.setMargin(new Insets(0,0,0,135));
        destination.addActionListener(this);
        pl2.add(destination);

        payments= new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(new Color(0,0,102));
        payments.setForeground(Color.WHITE);
        payments.setFont(new Font("Tahoma",Font.PLAIN,20));
        payments.setMargin(new Insets(0,0,0,155));
        payments.addActionListener(this);
        pl2.add(payments);

        calculator= new JButton("Calculator");
        calculator.setBounds(0,600,300,60);
        calculator.setBackground(new Color(0,0,102));
        calculator.setForeground(Color.WHITE);
        calculator.setFont(new Font("Tahoma",Font.PLAIN,20));
        calculator.setMargin(new Insets(0,0,0,155));
        calculator.addActionListener(this);
        pl2.add(calculator);

        about= new JButton("About");
        about.setBounds(0,660,300,60);
        about.setBackground(new Color(0,0,102));
        about.setForeground(Color.WHITE);
        about.setFont(new Font("Tahoma",Font.PLAIN,20));
        about.setMargin(new Insets(0,0,0,170));
        about.addActionListener(this);
        pl2.add(about);

        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5=i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6=new ImageIcon(i5);
        JLabel image=new JLabel(i6);
        image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text =new JLabel("Travel and Tourism Management System");
        text.setBounds(350,70,1300,70);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,60));
        image.add(text);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== addDetails)
        {
            new AddCustomer(username);
        }else if(ae.getSource()==viewDetails)
        {
            new ViewCustomer(username);
        }else if(ae.getSource()==updateDetails)
        {
            new UpdateCustomer(username);
        }else if(ae.getSource()==checkPackage)
        {
            new CheckPackage();
        }else if(ae.getSource()==bookPackage)
        {
            new BookPackage(username);
        }else if(ae.getSource()==viewPackage)
        {
            new ViewPackage(username);
        }else if(ae.getSource()==viewHotels)
        {
            new CheckHotels();
        }else if(ae.getSource()==destination)
        {
            new Destination();
        }else if(ae.getSource()==bookHotels)
        {
            new BookHotel(username);
        }else if(ae.getSource()==viewBookedHotel)
        {
            new ViewHotel(username);
        }
        else if(ae.getSource()==payments)
        {
            new Payment();
        }else if(ae.getSource()==calculator)
        {
            try{
                Runtime.getRuntime().exec("calc.exe");

            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }else if(ae.getSource()==about)
        {
            new About();
        }else if(ae.getSource()==deleteDetails)
        {
            new DeleteDetails(username);
        }

    }
    public static void main(String[] args) {
        new Dashboard("");
    }
}
