package tour360;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FPDialog extends JFrame implements ActionListener {

    JButton tryag,fp;
    String un;
    FPDialog(String username){

        this.un=username;

        setSize(300,200);
        setLocation(600,300);
        getContentPane().setBackground(new Color(255, 202, 202));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel i=new JLabel("Incorrect Password :(");
        i.setBounds(50,5,200,20);
        i.setFont(new Font("DialogInput",Font.BOLD,15));
        i.setForeground(new Color(255, 0, 0));
        add(i);

        tryag=new JButton("Try Again");
        tryag.setBounds(60,55,180,30);
        tryag.setFont(new Font("DialogInput",Font.BOLD,15));
        tryag.setBorder(BorderFactory.createEmptyBorder());
        tryag.setBackground(new Color(210, 42, 42));
        tryag.setForeground(Color.white);
        tryag.addActionListener(this);
        add(tryag);

        fp=new JButton("Forgot Password?");
        fp.setBounds(60,95,180,30);
        fp.setFont(new Font("DialogInput",Font.BOLD,15));
        fp.setBorder(BorderFactory.createEmptyBorder());
        fp.setBackground(new Color(210, 42, 42));
        fp.setForeground(Color.white);
        fp.addActionListener(this);
        add(fp);


        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==tryag){
            setVisible(false);
            new Update(un);
        }
        else if(e.getSource()==fp){
            setVisible(false);
            new ForgetPass("FPD");
        }
    }

    public static void main(String[] args) {
        new FPDialog("");
    }

}
