package tour360;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class Update extends JFrame implements ActionListener {

    JTextField tname,tuname,temail,tphn;

    JPasswordField tnpass,topass;

    JButton update,back;

    JRadioButton rmale,rfemale;
    String username,gender,password;


    Update(String un){

        this.username=un;

        setTitle("Update Account Information");
        setBounds(350,200,900,400);
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);

        JPanel p1=new JPanel();
        p1.setBackground(Color.white);
        p1.setBounds(0,0,400,400);
        p1.setLayout(null);
        add(p1);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,400);
        p1.add(image);

        JPanel p2=new JPanel();
        p2.setBounds(400,0,500,400);
        p2.setBackground(new Color(71, 156, 255));
        p2.setLayout(null);
        add(p2);

/*-------------------------------Name------------------------------------------*/
        JLabel lname=new JLabel("Name");
        lname.setFont(new Font("DialogInput",Font.BOLD,15));
        lname.setBounds(60,40,80,20);
        //name.setForeground(Color.white);
        p2.add(lname);

        tname=new JTextField();
        tname.setBounds(185,40,250,20);
        tname.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tname);
        /*--------------------------------------------------------------------*/


        /*-------------------------------Username------------------------------------------*/
        JLabel uname=new JLabel("Username");
        uname.setFont(new Font("DialogInput",Font.BOLD,15));
        uname.setBounds(60,70,80,20);
        //uname.setForeground(Color.white);
        p2.add(uname);

        tuname=new JTextField();
        tuname.setBounds(185,70,250,20);
        tuname.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tuname);
        /*--------------------------------------------------------------------*/

        /*-------------------------Phone-------------------------------------------*/
        JLabel phn=new JLabel("Phone");
        phn.setFont(new Font("DialogInput",Font.BOLD,15));
        phn.setBounds(60,100,80,20);
        //phn.setForeground(Color.white);
        p2.add(phn);

        tphn=new JTextField();
        tphn.setBounds(185,100,250,20);
        tphn.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tphn);
        /*--------------------------------------------------------------------*/

        /*----------------------------Email----------------------------------------*/
        JLabel lemail=new JLabel("Email");
        lemail.setFont(new Font("DialogInput",Font.BOLD,15));
        lemail.setBounds(60,130,80,20);
        //email.setForeground(Color.white);
        p2.add(lemail);

        temail=new JTextField();
        temail.setBounds(185,130,250,20);
        temail.setBorder(BorderFactory.createEmptyBorder());
        p2.add(temail);
        /*--------------------------------------------------------------------*/

        /*--------------------------Gender------------------------------------------*/
        JLabel lgender=new JLabel("Gender");
        lgender.setBounds(60,170,80,20);
        lgender.setFont(new Font("DialogInput",Font.BOLD,15));
        //gender.setForeground(Color.white);
        p2.add(lgender);

        rmale =new JRadioButton("Male");
        rmale.setBounds(185,170,80,20);
        rmale.setBackground(null);
        rmale.setBorder(BorderFactory.createEmptyBorder());
        rmale.setFont(new Font("DialogInput",Font.BOLD,15));
        //rmale.setForeground(Color.WHITE);
        p2.add(rmale);

        rfemale =new JRadioButton("Female");
        rfemale.setBounds(275,170,125,20);
        rfemale.setBackground(null);
        rfemale.setBorder(BorderFactory.createEmptyBorder());
        rfemale.setFont(new Font("DialogInput",Font.BOLD,15));
        //rfemale.setForeground(Color.WHITE);
        p2.add(rfemale);

        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(rmale);
        buttonGroup.add(rfemale);
        /*--------------------------------------------------------------------*/

        /*--------------------------Connection------------------------------------------*/
        try{
            Conn conn=new Conn();

            ResultSet rs=conn.statement.executeQuery("select * from tour101.user_info where Username='"+username+"'");

            while(rs.next()){
                tname.setText(rs.getString("Name"));
                tuname.setText(rs.getString("Username"));
                tphn.setText(rs.getString("Phone"));
                temail.setText(rs.getString("Email"));
                gender=rs.getString("Gender");
                if(gender!=null && gender.equals("Male")){
                    rmale.setSelected(true);
                }
                else if(gender!=null && gender.equals("Female")){
                    rfemale.setSelected(true);
                }
                password=rs.getString("Password");
            }
        }
        catch (SQLException sqe){
            sqe.printStackTrace();
        }
        /*--------------------------------------------------------------------*/

        /*----------------------------New Password----------------------------------------*/
        JLabel npass=new JLabel("New Password");
        npass.setFont(new Font("DialogInput",Font.BOLD,15));
        npass.setBounds(60,200,110,20);
        //email.setForeground(Color.white);
        p2.add(npass);

        tnpass=new JPasswordField();
        tnpass.setBounds(185,200,250,20);
        tnpass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tnpass);
        /*--------------------------------------------------------------------*/

        /*----------------------------Old Password----------------------------------------*/
        JLabel opass=new JLabel("Old Password");
        opass.setFont(new Font("DialogInput",Font.BOLD,15));
        opass.setBounds(60,230,110,20);
        //email.setForeground(Color.white);
        p2.add(opass);

        topass=new JPasswordField();
        topass.setBounds(185,230,250,20);
        topass.setBorder(BorderFactory.createEmptyBorder());
        p2.add(topass);
        /*--------------------------------------------------------------------*/

        /*----------------------------Update----------------------------------------*/
        update=new JButton("Update");
        update.setBounds(125,290,120,30);
        update.setBackground(Color.white);
        update.setForeground(new Color(71, 156, 255));
        update.setBorder(new LineBorder(new Color(71, 156, 255)));
        update.addActionListener(this);
        p2.add(update);
        /*--------------------------------------------------------------------*/

        /*----------------------------Back----------------------------------------*/
        back=new JButton("Back");
        back.setBounds(285,290,120,30);
        back.setBackground(Color.white);
        back.setForeground(new Color(71, 156, 255));
        back.setBorder(new LineBorder(new Color(71, 156, 255)));
        back.addActionListener(this);
        p2.add(back);
        /*--------------------------------------------------------------------*/

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==update){

            String n=tname.getText();
            String u=tuname.getText();
            String ph=tphn.getText();
            String em=temail.getText();
            String g=null;
            if(rmale.isSelected()){
                g="Male";
            }
            else if(rfemale.isSelected()){
                g="Female";
            }
            String op=new String(topass.getPassword());
            String np=new String(tnpass.getPassword());
            if(np.isEmpty()){
                np=op;
            }

            if(Objects.equals(op,password) && !username.isEmpty()){

                try{
                    Conn c=new Conn();
                    String q="update tour101.user_info set Name='"+n+"',Username='"+u+"',Email='"+em+"',Password='"+np+"',Phone='"+ph+"',Gender='"+g+"' where Username='"+username+"'";
                    c.statement.executeUpdate(q);

                    JOptionPane.showMessageDialog(null,"Account Information Updated :)");

                    setVisible(false);
                }
                catch (SQLException se){
                    se.printStackTrace();
                }
            }
            else{
                setVisible(false);
                new FPDialog(username);
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Update("");
    }
}
