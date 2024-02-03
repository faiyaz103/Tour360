package tour360;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class ForgetPass extends JFrame implements ActionListener {

    JTextField tuname,tname,tques,tpass, tans;
    JButton search,retrieve,back;
    String code;

    ForgetPass(String code){

        this.code=code;

        setTitle("Retrieve Password");
        setBounds(350,200,900,400);
        getContentPane().setBackground(new Color(0, 74, 103));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JPanel p=new JPanel();
        p.setBounds(80,30,740,300);
        p.setBackground(new Color(208,250,240));
        p.setLayout(null);
        add(p);

        JLabel uname=new JLabel("Username");
        uname.setBounds(250,40,80,20);
        uname.setFont(new Font("DialogInput",Font.BOLD,13));
        uname.setForeground(new Color(0, 74, 103));
        p.add(uname);

        tuname=new JTextField();
        tuname.setBounds(340,40,100,20);
        tuname.setBorder(new LineBorder(new Color(0, 74, 103)));
        p.add(tuname);

        search = new JButton("Search");
        search.setBounds(450,40,70,20);
        search.setForeground(new Color(208,250,240));
        search.setBackground(new Color(0, 74, 103));
        search.setBorder(BorderFactory.createEmptyBorder());
        search.addActionListener(this);
        p.add(search);

        JLabel name=new JLabel("Name");
        name.setBounds(250,70,80,20);
        name.setFont(new Font("DialogInput",Font.BOLD,13));
        name.setForeground(new Color(0, 74, 103));
        p.add(name);

        tname=new JTextField();
        tname.setBounds(340,70,180,20);
        tname.setBorder(new LineBorder(new Color(0, 74, 103)));
        p.add(tname);

        JLabel sec=new JLabel("Question");
        sec.setBounds(250,100,80,20);
        sec.setFont(new Font("DialogInput",Font.BOLD,13));
        sec.setForeground(new Color(0, 74, 103));
        p.add(sec);

        tques=new JTextField();
        tques.setBounds(340,100,180,20);
        tques.setBorder(new LineBorder(new Color(0, 74, 103)));
        p.add(tques);

        JLabel ans=new JLabel("Answer");
        ans.setBounds(250,130,80,20);
        ans.setFont(new Font("DialogInput",Font.BOLD,13));
        ans.setForeground(new Color(0, 74, 103));
        p.add(ans);

        tans=new JTextField();
        tans.setBounds(340,130,180,20);
        tans.setBorder(new LineBorder(new Color(0, 74, 103)));
        p.add(tans);

        retrieve = new JButton("Retrieve");
        retrieve.setBounds(380,160,100,20);
        retrieve.setForeground(new Color(208,250,240));
        retrieve.setBackground(new Color(0,74,103));
        retrieve.setBorder(BorderFactory.createEmptyBorder());
        retrieve.addActionListener(this);
        p.add(retrieve);

        JLabel pass=new JLabel("Password");
        pass.setBounds(250,210,80,20);
        pass.setFont(new Font("DialogInput",Font.BOLD,13));
        pass.setForeground(new Color(0, 74, 103));
        p.add(pass);

        tpass=new JTextField();
        tpass.setBounds(340,210,180,20);
        tpass.setBorder(new LineBorder(new Color(0, 74, 103)));
        p.add(tpass);

        back = new JButton("Back");
        back.setBounds(380,240,100,20);
        back.setForeground(new Color(208,250,240));
        back.setBackground(new Color(0,74,103));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        p.add(back);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==search){

            int flag=0;
            try{

                String q="select * from tour101.user_info where Username = '"+tuname.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.statement.executeQuery(q);

                while(rs.next()){
                    tname.setText(rs.getString("Name"));
                    tques.setText(rs.getString("Question"));
                    flag=1;
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            if(flag==0){
                JOptionPane.showMessageDialog(null,"Invalid Username :(");
            }
        }
        else if(e.getSource()==retrieve){

            int flag=0;
            try{

                String q="select * from tour101.user_info where Username = '"+tuname.getText()+"' AND Answer = '"+tans.getText()+"'";
                Conn c=new Conn();
                ResultSet rs=c.statement.executeQuery(q);

                while(rs.next()){
                    tpass.setText(rs.getString("Password"));
                    flag=1;
                }
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

            if(flag==0){
                JOptionPane.showMessageDialog(null,"Please Provide"+"\n"+"Correct Information!!!");
//                setVisible(false);
//                new ForgetPass();
            }
        }
        else if(e.getSource()==back){


            if(Objects.equals(code, "L") || Objects.equals(code, "")){
                setVisible(false);
                new Login();
            }
            else if(Objects.equals(code, "FPD")){
                setVisible(false);
            }

        }
    }

    public static void main(String[] args) {
        new ForgetPass("");
    }
}
