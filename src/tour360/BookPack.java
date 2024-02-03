package tour360;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class BookPack extends JFrame implements ActionListener {

    JLabel uname,phone, pri;
    JButton check,book,back;
    String username,pakg;
    Choice selpack;

    JTextField tp;
    BookPack(String usname){
        this.username=usname;

        setTitle("Book a Package");
        setBounds(350,200,900,400);
        getContentPane().setBackground(Color.lightGray);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel p2=new JPanel();
        p2.setBounds(500,0,400,400);
        p2.setBackground(Color.white);
        p2.setLayout(null);
        add(p2);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/bookpack.png"));
        Image i2=i1.getImage().getScaledInstance(400,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,400,400);
        p2.add(image);

        JPanel p1=new JPanel();
        p1.setBackground(new Color(103, 0, 46));
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

        /*------------------------------select pack---------------------------------------------*/
        JLabel selectpack=new JLabel("Select");
        selectpack.setBounds(70,90,90,20);
        selectpack.setFont(new Font("DialogInput",Font.PLAIN,15));
        selectpack.setForeground(Color.WHITE);
        p1.add(selectpack);

        selpack=new Choice();
        selpack.add("Package 1");
        selpack.add("Package 2");
        selpack.add("Package 3");
        selpack.add("Package 4");
        selpack.setBounds(200,90,200,20);
        p1.add(selpack);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Total---------------------------------------------*/
        JLabel tpers=new JLabel("Total Person");
        tpers.setBounds(70,130,120,20);
        tpers.setFont(new Font("DialogInput",Font.PLAIN,15));
        tpers.setForeground(Color.WHITE);
        p1.add(tpers);

        tp =new JTextField();
        tp.setBounds(200,130,200,20);
        tp.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tp);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Phone---------------------------------------------*/
        JLabel lphn=new JLabel("Phone");
        lphn.setBounds(70,170,60,20);
        lphn.setFont(new Font("DialogInput",Font.PLAIN,15));
        lphn.setForeground(Color.WHITE);
        p1.add(lphn);

        phone=new JLabel();
        phone.setBounds(200,170,200,20);
        phone.setFont(new Font("SansSerif",Font.ITALIC,16));
        phone.setForeground(Color.WHITE);
        p1.add(phone);
        /*---------------------------------------------------------------------------*/

        /*------------------------------Total Price---------------------------------------------*/
        JLabel totp=new JLabel("Total Price");
        totp.setBounds(70,210,120,20);
        totp.setFont(new Font("DialogInput",Font.PLAIN,15));
        totp.setForeground(Color.WHITE);
        p1.add(totp);

        pri =new JLabel();
        pri.setBounds(200,210,200,20);
        pri.setFont(new Font("SansSerif",Font.ITALIC,16));
        pri.setForeground(Color.WHITE);
        p1.add(pri);
        /*---------------------------------------------------------------------------*/

        check=new JButton("Check Price");
        check.setBounds(70,270,100,30);
        check.setFont(new Font("SansSerif",Font.BOLD,15));
        check.setBorder(BorderFactory.createEmptyBorder());
        check.setForeground(new Color(103, 0, 46));
        check.addActionListener(this);
        p1.add(check);


        book=new JButton("Book");
        book.setBounds(200,270,100,30);
        book.setFont(new Font("SansSerif",Font.BOLD,15));
        book.setBorder(BorderFactory.createEmptyBorder());
        book.setForeground(new Color(103, 0, 46));
        book.addActionListener(this);
        p1.add(book);

        back=new JButton("Back");
        back.setBounds(330,270,100,30);
        back.setFont(new Font("SansSerif",Font.BOLD,15));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.setForeground(new Color(103, 0, 46));
        back.addActionListener(this);
        p1.add(back);



        try{
            Conn c=new Conn();

            ResultSet rs=c.statement.executeQuery("select * from tour101.user_info where Username='"+username+"'");

            while(rs.next()){
                uname.setText(rs.getString("Username"));
                phone.setText(rs.getString("Phone"));
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }

        setVisible(true);
        setResizable(false);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==check){
            String s=tp.getText();
            pakg=new String(selpack.getSelectedItem());

            try{
                int i=Integer.parseInt(s);

                if(Objects.equals(pakg,"Package 1")){
                    int c=i*5000;
                    String cost=Integer.toString(c);
                    pri.setText(cost);
                }
                else if(Objects.equals(pakg,"Package 2")){
                    int c=i*6000;
                    String cost=Integer.toString(c);
                    pri.setText(cost);
                }
                else if(Objects.equals(pakg,"Package 3")){
                    int c=i*4500;
                    String cost=Integer.toString(c);
                    pri.setText(cost);
                }
                else if(Objects.equals(pakg,"Package 4")){
                    int c=i*7000;
                    String cost=Integer.toString(c);
                    pri.setText(cost);
                }
            }
            catch (NumberFormatException n){
                n.printStackTrace();
            }


        }
        else if(e.getSource()==book){

            String packname=new String(selpack.getSelectedItem());
            String cost= pri.getText();
            String num=tp.getText();
            if(!num.isEmpty()){
                try{
                    Conn c=new Conn();
                    String q="update tour101.user_info set Package='"+packname+"',Cost='"+cost+"', NoPerson='"+num+"' where Username='"+username+"'";
                    c.statement.executeUpdate(q);

                    JOptionPane.showMessageDialog(null,"Package Booked:)"+"\n"+"Please make payment");

                    setVisible(false);
                }
                catch (SQLException se){
                    se.printStackTrace();
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Provide All Information :(");
            }
        }
        else if(e.getSource()==back){
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new BookPack("");
    }
}
