package tour360;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ViewBook extends JFrame implements ActionListener {

    JLabel uname,pri, pkg,tp;
    JButton back;
    String username;


    ViewBook(String usname){
        this.username=usname;

        setTitle("View Booked Package");
        setBounds(350,200,900,400);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JPanel p2=new JPanel();
        p2.setBounds(500,0,400,400);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        add(p2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/viewbook.png"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,400);
        p2.add(image);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(93, 2, 124, 216));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        /*------------------------------UserName---------------------------------------------*/
        JLabel lname=new JLabel("Username");
        lname.setBounds(70,50,70,20);
        lname.setFont(new Font("DialogInput",Font.PLAIN,15));
        lname.setForeground(Color.WHITE);
        p1.add(lname);

        uname=new JLabel();
        uname.setBounds(200,50,200,20);
        uname.setFont(new Font("SansSerif",Font.ITALIC,15));
        uname.setForeground(Color.WHITE);
        p1.add(uname);
        /*---------------------------------------------------------------------------*/

        /*------------------------------pack---------------------------------------------*/
        JLabel pname=new JLabel("Package");
        pname.setBounds(70,90,90,20);
        pname.setFont(new Font("DialogInput",Font.PLAIN,15));
        pname.setForeground(Color.WHITE);
        p1.add(pname);

        pkg=new JLabel();
        pkg.setBounds(200,90,200,20);
        pkg.setFont(new Font("SansSerif",Font.ITALIC,15));
        pkg.setForeground(Color.WHITE);
        p1.add(pkg);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Total---------------------------------------------*/
        JLabel tpers=new JLabel("Total Person");
        tpers.setBounds(70,130,120,20);
        tpers.setFont(new Font("DialogInput",Font.PLAIN,15));
        tpers.setForeground(Color.WHITE);
        p1.add(tpers);

        tp =new JLabel();
        tp.setBounds(200,130,200,20);
        tp.setFont(new Font("SansSerif",Font.ITALIC,15));
        tp.setForeground(Color.WHITE);
        p1.add(tp);
        /*---------------------------------------------------------------------------*/


        /*------------------------------Total Price---------------------------------------------*/
        JLabel totp=new JLabel("Price");
        totp.setBounds(70,170,60,20);
        totp.setFont(new Font("DialogInput",Font.PLAIN,15));
        totp.setForeground(Color.WHITE);
        p1.add(totp);

        pri =new JLabel();
        pri.setBounds(200,170,200,20);
        pri.setFont(new Font("SansSerif",Font.ITALIC,16));
        pri.setForeground(Color.WHITE);
        p1.add(pri);

        back=new JButton("Back");
        back.setBounds(200,250,100,30);
        back.setFont(new Font("SansSerif",Font.BOLD,15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(93, 2, 124, 216));
        back.addActionListener(this);
        p1.add(back);

        try{
            Conn c=new Conn();

            ResultSet rs=c.statement.executeQuery("select * from tour101.user_info where Username='"+username+"'");

            while(rs.next()){
                uname.setText(rs.getString("Username"));
                pkg.setText(rs.getString("Package"));
                tp.setText(rs.getString("NoPerson"));
                pri.setText(rs.getString("Cost"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        setVisible(true);
        setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new ViewBook("");
    }
}
