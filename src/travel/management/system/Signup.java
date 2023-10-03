package travel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Signup extends JFrame implements ActionListener{
    JButton create,back;
    JTextField tfuser,tfpass,tfans,tfname;
    Choice security;
    Signup()
    {
      setBounds(350,200,900,360);
      getContentPane().setBackground(Color.WHITE);
      setLayout(null);

      JPanel pl=new JPanel();
      pl.setBackground(new Color(133,193,233));
      pl.setBounds(0,0,500,400);
      add(pl);
      pl.setLayout(null);

      JLabel usernm=new JLabel("Username");
      usernm.setFont(new Font("Calibri",Font.BOLD,14));
      usernm.setBounds(50,20,125,25);
      pl.add(usernm);

      tfuser= new JTextField();
      tfuser.setBounds(170,20,180 ,25);
      tfuser.setBorder(BorderFactory.createEmptyBorder());
      pl.add(tfuser);

      JLabel name=new JLabel("Name");
      name.setFont(new Font("Calibri",Font.BOLD,14));
      name.setBounds(50,55,125,25);
      pl.add(name);

      tfname= new JTextField();
      tfname.setBounds(170,55,180 ,25);
      tfname.setBorder(BorderFactory.createEmptyBorder());
      pl.add(tfname);

      JLabel pass=new JLabel("Password");
      pass.setFont(new Font("Calibri",Font.BOLD,14));
      pass.setBounds(50,90 ,125,25);
      pl.add(pass);

      tfpass= new JTextField();
      tfpass.setBounds(170,90,180 ,25);
      tfpass.setBorder(BorderFactory.createEmptyBorder());
      pl.add(tfpass);

      JLabel lblsecurity=new JLabel("Security Question");
      lblsecurity.setFont(new Font("Calibri",Font.BOLD,14));
      lblsecurity.setBounds(50,125 ,125,25);
      pl.add(lblsecurity);

      security=new Choice();
      security.add("Mothers maiden name");
      security.add("Favourite animal");
      security.add("Favourite hobby");
      security.setBounds(170,125,180,25);
      pl.add(security);

      JLabel ans=new JLabel("Answer");
      ans.setFont(new Font("Calibri",Font.BOLD,14));
      ans.setBounds(50,160,125,25);
      pl.add(ans);

      tfans= new JTextField();
      tfans.setBounds(170,160,180 ,25);
      tfans.setBorder(BorderFactory.createEmptyBorder());
      pl.add(tfans);

      create=new JButton("Create");
      create.setBackground(Color.WHITE);
      create.setForeground(new Color(133,193,233));
      create.setFont(new Font("Calibri",Font.BOLD,14));
      create.setBounds(80,220,100,30);
      create.addActionListener(this);
      pl.add(create);

      back =new JButton("Back");
      back.setBackground(Color.WHITE);
      back.setForeground(new Color(133,193,233));
      back.setFont(new Font("Calibri",Font.BOLD,14));
      back.setBounds(250,220,100,30);
      back.addActionListener(this);
      pl.add(back);

      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
      Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      JLabel image=new JLabel(i3);
      image.setBounds(580,70,250,200);
      add(image);


      setVisible(true);
    }
    public void actionPerformed(ActionEvent ac)
    {
       if( ac.getSource()==create)
       {
         String username= tfuser.getText();
         String name=tfname.getText();
         String password=tfpass.getText();
         String question=security.getSelectedItem();
         String ans=tfans.getText();

         String query="insert into account values('"+username+"','"+name+"','"+password+"','"+question+"','"+ans+"')";
         try{
           Conn c=new Conn();
           c.s.executeUpdate(query);

           JOptionPane.showMessageDialog(null,"Account Created Succesfully");
           setVisible(false);
           new Login();
         }catch(Exception e){
           e.printStackTrace();
         }
       }
       else if(ac.getSource()== back)
       {
         setVisible(false);
         new Login();
       }
    }

    public static void main(String[] args) {
        new Signup();

    }
}
