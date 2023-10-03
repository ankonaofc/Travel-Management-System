package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class About  extends JFrame implements ActionListener{
    JButton back;
    About()
    {
        setBounds(600,200,500,550);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1=new JLabel("ABOUT");
        l1.setBounds(200,10,100,40);
        l1.setForeground(Color.RED);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        add(l1);

        String s="About Projects     \n"+"\n"+"The objective of the Travel and Tourism Management System Project is to develop a system that helps users to book hotels,packages \n"
                +"destinations.This application will help in accessing the information related to the travel to the particular place\n"+"\n"+
                "Advantages of Project include: \n"+"Gives accurate information\n"+"Simplifies the work of users.";

        TextArea area=new TextArea(s,10,40,Scrollbar.VERTICAL);
        area.setEditable(false);
        area.setBounds(20,100,450,300);
        add(area);

        back=new JButton("Back");
        back.setBounds(200,420,100,25);
        back.addActionListener(this);
        add(back);

        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
    }
    public static void main(String[] args) {
        new About();
    }
}
