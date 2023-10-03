package travel.management.system;
import javax.swing.*;
import java.awt.*;
public class CheckPackage  extends JFrame{

    CheckPackage()
    {
        setBounds(450,200,900,600);

        String[] pkg1={"GOLD PACKAGE","6 Days and 7 Nights","Full Transport Facility","Half Day City Tour","Salsa Evening","Full Time Guide","All Meals Included","Full 2 Day Cruise","Book Now","Rs 25000/-","package1.jpg"};
        String[] pkg2={"SILVER PACKAGE","3 Days and 4 Nights","Free Bus Tickets","Camping","2 Meals Included","Night Safari","Cruise with Dinner","Sightseeing","Book Now","Rs 12000/-","package2.jpg"};
        String[] pkg3={"BRONZE PACKAGE","2 Days and 3 Nights","Sightseeing","Breakfast Included","BBQ Dinner","Hotel Accomodation","Local Guide","Evening Opera Tickets","Book Now","Rs 7000/-","package3.jpg"};

        JTabbedPane tab=new JTabbedPane();
        JPanel pl=createPackage(pkg1);
        tab.addTab("Package 1",null,pl);

        JPanel pl2=createPackage(pkg2);
        tab.addTab("Package 2",null,pl2);

        JPanel pl3=createPackage(pkg3);
        tab.addTab("Package 3",null,pl3);

        add(tab);


        setVisible(true);
    }
    public JPanel createPackage(String[] pack)
    {
        JPanel pl=new JPanel();
        pl.setLayout(null);
        pl.setBackground(Color.white);

        JLabel l1 =new JLabel(pack[0]);
        l1.setBounds(60,10,350,35);
        l1.setForeground(Color.ORANGE);
        l1.setFont(new Font("Aerial",Font.BOLD,35));
        pl.add(l1);

        JLabel l2 =new JLabel(pack[1]);
        l2.setBounds(30,60,300,35);
        l2.setForeground(Color.MAGENTA);
        l2.setFont(new Font("Aerial",Font.BOLD,20));
        pl.add(l2);

        JLabel l3 =new JLabel(pack[2]);
        l3.setBounds(30,110,300,35);
        l3.setForeground(Color.MAGENTA);
        l3.setFont(new Font("Aerial",Font.BOLD,20));
        pl.add(l3);

        JLabel l4 =new JLabel(pack[3]);
        l4.setBounds(30,160,300,35);
        l4.setForeground(Color.MAGENTA);
        l4.setFont(new Font("Aerial",Font.BOLD,20));
        pl.add(l4);

        JLabel l5 =new JLabel(pack[4]);
        l5.setBounds(30,210,300,35);
        l5.setForeground(Color.MAGENTA);
        l5.setFont(new Font("Aerial",Font.BOLD,20));
        pl.add(l5);

        JLabel l6 =new JLabel(pack[5]);
        l6.setBounds(30,260,300,35);
        l6.setForeground(Color.MAGENTA);
        l6.setFont(new Font("Aerial",Font.BOLD,20));
        pl.add(l6);

        JLabel l7 =new JLabel(pack[6]);
        l7.setBounds(30,310,300,35);
        l7.setForeground(Color.MAGENTA);
        l7.setFont(new Font("Aerial",Font.BOLD,20));
        pl.add(l7);

        JLabel l10 =new JLabel(pack[7]);
        l10.setBounds(30,360,300,35);
        l10.setForeground(Color.MAGENTA);
        l10.setFont(new Font("Aerial",Font.BOLD,20));
        pl.add(l10);

        JLabel l8 =new JLabel(pack[8]);
        l8.setBounds(60,430,300,35);
        l8.setForeground(Color.BLUE);
        l8.setFont(new Font("Aerial",Font.BOLD,25));
        pl.add(l8);

        JLabel l9 =new JLabel(pack[9]);
        l9.setBounds(250,430,300,35);
        l9.setForeground(Color.BLACK);
        l9.setFont(new Font("Aerial",Font.BOLD,25));
        pl.add(l9);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/"+pack[10]));
        Image i2=i1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(350,50,500,300);
        pl.add(image);

        return pl;
    }
    public static void main(String[] args) {
        new CheckPackage();
    }
}
