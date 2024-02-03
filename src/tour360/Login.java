package tour360;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {

    JButton signup,frpass,login;
    JTextField tfusername;
    JPasswordField tfpass;

    Login(){

        //Main Frame
        setTitle("Login");
        setSize(900,400);
        setLocation(350,200);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(Color.lightGray);

        //Frame->Left Panel
        JPanel p1=new JPanel();
        p1.setBackground(new Color(208,250,240));
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        //Frame->Left Panel->Image
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,400);
        p1.add(image);

        //Frame->Right Panel
        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,0,500,400);
        p2.setBackground(new Color(0, 74, 103));
        add(p2);

        //Frame->Right Panel->Username
        JLabel lblusername=new JLabel("Username");
        lblusername.setBounds(100,20,100,25);
        lblusername.setFont(new Font("DialogInput",Font.PLAIN,15));
        lblusername.setForeground(Color.WHITE);
        p2.add(lblusername);

        //Frame->Right Panel->Username Input
        tfusername=new JTextField();
        tfusername.setBounds(100,55,300,30);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfusername);

        //Frame->Right Panel->Password
        JLabel lblpass=new JLabel("Password");
        lblpass.setBounds(100,95,100,25);
        lblpass.setFont(new Font("DialogInput",Font.PLAIN,15));
        lblpass.setForeground(Color.WHITE);
        p2.add(lblpass);

        //Frame->Right Panel->Password Input
        tfpass=new JPasswordField();
        tfpass.setBounds(100,130,300,30);
        tfpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpass);

        //Frame->Right Panel->Login Button
        login=new JButton("Login");
        login.setBounds(135,180,100,25);
        login.setBackground(new Color(208,250,240));
        login.setForeground(new Color(0, 74, 103));
        login.setBorder(new LineBorder(Color.WHITE));
        login.addActionListener(this);
        p2.add(login);

        //Frame->Right Panel->Signup Button
        signup=new JButton("Signup");
        signup.setBounds(265,180,100,25);
        signup.setBackground(new Color(208,250,240));
        signup.setForeground(new Color(0, 74, 103));
        signup.setBorder(new LineBorder(Color.white));
        signup.addActionListener(this);
        p2.add(signup);

        //Frame->Right Panel->Trouble in Login
        JLabel trbl=new JLabel("Trouble Logging in?");
        trbl.setBounds(192,240,115,20);
        trbl.setForeground(Color.WHITE);
        p2.add(trbl);

        //Frame->Right Panel->Forgot Password Button
        frpass=new JButton("Forgot Password");
        frpass.setBounds(135,270,230,30);
        frpass.setBackground(new Color(208,250,240));
        frpass.setForeground(new Color(0, 74, 103));
        frpass.setBorder(new LineBorder(Color.white));
        frpass.addActionListener(this);
        p2.add(frpass);


        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==login){

            try{
                String u=tfusername.getText();
                String p=new String(tfpass.getPassword());

                String q="select * from tour101.user_info";

                Conn c=new Conn();
                ResultSet resultSet=c.statement.executeQuery(q);

                int flag=0;

                while(resultSet.next()){
                    String nm=resultSet.getString("Name");
                    String un=resultSet.getString("Username");
                    String em=resultSet.getString("Email");
                    String pass=resultSet.getString("Password");
                    String ph=resultSet.getString("Phone");
                    String gn=resultSet.getString("Gender");

                    if(Objects.equals(un, u) && Objects.equals(pass, p)){
                        flag=1;
                        setVisible(false);
                        new Loading(un);
                        break;
                    }
                }

                if(flag==0){
                    JOptionPane.showMessageDialog(null,"Incorrect Username/Password :(");
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        }
        else if(e.getSource()==signup){
            setVisible(false);
            new Signup();
        }
        else if(e.getSource()==frpass){
            setVisible(false);
            new ForgetPass("L");
        }
    }

    public static void main(String[] args){

        new Login();
    }
}
