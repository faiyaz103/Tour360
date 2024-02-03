package tour360;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Signup extends JFrame implements ActionListener {

    JTextField tname,tuname,temail,tans;
    Choice security;
    JPasswordField tpass;

    JButton create,back;

    Signup(){

        setTitle("Signup");
        setBounds(350,200,900,400);
        getContentPane().setBackground(Color.lightGray);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(208,250,240));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,400);
        p1.add(image);

        JPanel p2=new JPanel();
        p2.setBounds(400,0,500,400);
        p2.setBackground(new Color(0, 74, 103));
        p2.setLayout(null);
        add(p2);

        JLabel name=new JLabel("Name");
        name.setFont(new Font("DialogInput",Font.BOLD,15));
        name.setBounds(100,30,80,20);
        name.setForeground(Color.white);
        p2.add(name);

        tname=new JTextField();
        tname.setBounds(185,30,250,20);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tname);

        JLabel uname=new JLabel("Username");
        uname.setFont(new Font("DialogInput",Font.BOLD,15));
        uname.setBounds(100,60,80,20);
        uname.setForeground(Color.white);
        p2.add(uname);

        tuname=new JTextField();
        tuname.setBounds(185,60,250,20);
        tuname.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tuname);

        JLabel email=new JLabel("Email");
        email.setFont(new Font("DialogInput",Font.BOLD,15));
        email.setBounds(100,90,80,20);
        email.setForeground(Color.white);
        p2.add(email);

        temail=new JTextField();
        temail.setBounds(185,90,250,20);
        temail.setBorder(BorderFactory.createEmptyBorder());
        p2.add(temail);

        JLabel sq=new JLabel("Pick one:");
        sq.setFont(new Font("DialogInput",Font.BOLD,15));
        sq.setBounds(100,120,80,20);
        sq.setForeground(Color.white);
        p2.add(sq);

        security=new Choice();
        security.add("What is your grandfather’s last name?");
        security.add("What year did you enter college?");
        security.add("Which teacher did you like the most at college?");
        security.add("Who is your favourite super hero?");
        security.add("What is your favourite movie?");
        security.setBounds(185,120,250,20);
        p2.add(security);

        JLabel ans=new JLabel("Answer");
        ans.setFont(new Font("DialogInput",Font.BOLD,15));
        ans.setBounds(100,150,80,20);
        ans.setForeground(Color.white);
        p2.add(ans);

        tans=new JTextField();
        tans.setBounds(185,150,250,20);
        tans.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tans);

        JLabel pass=new JLabel("Password");
        pass.setFont(new Font("DialogInput",Font.BOLD,15));
        pass.setBounds(100,180,80,20);
        pass.setForeground(Color.white);
        p2.add(pass);

        tpass=new JPasswordField();
        tpass.setBounds(185,180,250,20);
        tpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tpass);

        create=new JButton("Create Account");
        create.setBounds(200,240,150,30);
        create.setBackground(new Color(208,250,240));
        create.setForeground(new Color(0, 74, 103));
        create.setBorder(new LineBorder(new Color(0, 74, 103)));
        create.addActionListener(this);
        p2.add(create);

        back=new JButton("Back");
        back.setBounds(200,280,150,30);
        back.setBackground(new Color(208,250,240));
        back.setForeground(new Color(0, 74, 103));
        back.setBorder(new LineBorder(new Color(0, 74, 103)));
        back.addActionListener(this);
        p2.add(back);


        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==create){

            String n=tname.getText();
            String u=tuname.getText();
            String em=temail.getText();
            String sec=new String(security.getSelectedItem());
            String a=tans.getText();
            String p=new String(tpass.getPassword());

            if(!n.isEmpty() && !u.isEmpty() && !em.isEmpty() && !sec.isEmpty() && !a.isEmpty() && !p.isEmpty()){

                String q="insert into tour101.user_info(Name,Username,Email,Question,Answer,Password) values('"+n+"','"+u+"','"+em+"','"+sec+"','"+a+"','"+p+"')";

                try{
                    Conn c=new Conn();
                    c.statement.executeUpdate(q);

                    JOptionPane.showMessageDialog(null,"Account successfully created :)");

                    setVisible(false);
                    new Login();
                }
                catch (SQLException ex){
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"This Username or Email is already registered!!!");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Provide All Information...");

                setVisible(false);
                new Signup();
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
            new Login();
        }

    }

    public static void main(String[] args) {
        new Signup();
    }
}
