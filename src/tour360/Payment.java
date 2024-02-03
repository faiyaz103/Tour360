package tour360;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Payment extends JFrame implements ActionListener {

    JLabel lam,lref;

    JButton back;

    String username;
    Payment(String usname){

        this.username=usname;

        setTitle("Make Payment");
        setBounds(350,200,900,400);
        getContentPane().setBackground(new Color(243, 89, 158));
        setLayout(null);

        JLabel amount=new JLabel("Amount");
        amount.setBounds(300,50,100,20);
        amount.setFont(new Font("DialogInput",Font.BOLD,20));
        add(amount);

        lam=new JLabel();
        lam.setBounds(420,50,100,20);
        lam.setFont(new Font("DialogInput",Font.BOLD,20));
        add(lam);

        JLabel usref=new JLabel("User Reference");
        usref.setBounds(220,90,180,20);
        usref.setFont(new Font("DialogInput",Font.BOLD,20));
        add(usref);

        lref=new JLabel();
        lref.setBounds(420,90,100,20);
        lref.setFont(new Font("DialogInput",Font.BOLD,20));
        add(lref);

        JLabel pls=new JLabel("Please provide this reference while making payment.");
        pls.setBounds(200,130,500,20);
        pls.setFont(new Font("DialogInput",Font.BOLD,15));
        add(pls);

        JLabel acc=new JLabel("Account No: 01234567891");
        acc.setBounds(300,170,400,20);
        acc.setFont(new Font("DialogInput",Font.BOLD,20));
        add(acc);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/payment.jpg"));
        Image i2=i1.getImage().getScaledInstance(400,100,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(250,210,400,100);
        add(image);

        back=new JButton("Back");
        back.setBounds(400,330,100,20);
        add(back);
        back.addActionListener(this);

        try{
            Conn c=new Conn();

            ResultSet rs=c.statement.executeQuery("select * from tour101.user_info where Username='"+username+"'");

            while(rs.next()){
                lref.setText(rs.getString("Username"));
                lam.setText(rs.getString("Cost"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Payment("");
    }


}
