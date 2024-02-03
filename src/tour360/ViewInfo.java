package tour360;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewInfo extends JFrame implements ActionListener {

    JLabel name,uname,email,phone,gender;
    JButton back;
    String username;
    ViewInfo(String username){

        this.username=username;

        setTitle("View Account Information");
        setBounds(350,200,900,400);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JPanel p2=new JPanel();
        p2.setBounds(500,0,400,400);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        add(p2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/view.png"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,400);
        p2.add(image);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(0, 74, 103));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        /*------------------------------Name---------------------------------------------*/
        JLabel lname=new JLabel("Name");
        lname.setBounds(70,50,50,20);
        lname.setFont(new Font("DialogInput",Font.PLAIN,18));
        lname.setForeground(Color.WHITE);
        p1.add(lname);

        name=new JLabel();
        name.setBounds(200,50,200,20);
        name.setFont(new Font("SansSerif",Font.ITALIC,16));
        name.setForeground(Color.WHITE);
        p1.add(name);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Username---------------------------------------------*/
        JLabel luname=new JLabel("Username");
        luname.setBounds(70,90,90,20);
        luname.setFont(new Font("DialogInput",Font.PLAIN,18));
        luname.setForeground(Color.WHITE);
        p1.add(luname);

        uname=new JLabel();
        uname.setBounds(200,90,200,20);
        uname.setFont(new Font("SansSerif",Font.ITALIC,16));
        uname.setForeground(Color.WHITE);
        p1.add(uname);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Email---------------------------------------------*/
        JLabel lemail=new JLabel("Email");
        lemail.setBounds(70,130,60,20);
        lemail.setFont(new Font("DialogInput",Font.PLAIN,18));
        lemail.setForeground(Color.WHITE);
        p1.add(lemail);

        email=new JLabel();
        email.setBounds(200,130,200,20);
        email.setFont(new Font("SansSerif",Font.ITALIC,16));
        email.setForeground(Color.WHITE);
        p1.add(email);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Phone---------------------------------------------*/
        JLabel lphn=new JLabel("Phone");
        lphn.setBounds(70,170,60,20);
        lphn.setFont(new Font("DialogInput",Font.PLAIN,18));
        lphn.setForeground(Color.WHITE);
        p1.add(lphn);

        phone=new JLabel();
        phone.setBounds(200,170,200,20);
        phone.setFont(new Font("SansSerif",Font.ITALIC,16));
        phone.setForeground(Color.WHITE);
        p1.add(phone);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Gender---------------------------------------------*/
        JLabel lgender=new JLabel("Gender");
        lgender.setBounds(70,210,80,20);
        lgender.setFont(new Font("DialogInput",Font.PLAIN,18));
        lgender.setForeground(Color.WHITE);
        p1.add(lgender);

        gender=new JLabel();
        gender.setBounds(200,210,200,20);
        gender.setFont(new Font("SansSerif",Font.ITALIC,16));
        gender.setForeground(Color.WHITE);
        p1.add(gender);
        /*---------------------------------------------------------------------------*/


        back=new JButton("Back");
        back.setBounds(200,270,100,30);
        back.setFont(new Font("SansSerif",Font.BOLD,15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(0,74,103));
        back.addActionListener(this);
        p1.add(back);

        /*-----------------------------Connection-----------------------------------------------*/
        try{
            Conn c=new Conn();

            ResultSet rs=c.statement.executeQuery("select * from tour101.user_info where Username='"+username+"'");

            while(rs.next()){
                name.setText(rs.getString("Name"));
                uname.setText(rs.getString("Username"));
                email.setText(rs.getString("Email"));
                phone.setText(rs.getString("Phone"));
                gender.setText(rs.getString("Gender"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        /*----------------------------------------------------------------------------*/

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewInfo("");
    }

}
