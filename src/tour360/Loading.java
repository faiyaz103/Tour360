package tour360;

import javax.swing.*;
import java.awt.*;

public class Loading extends JFrame implements Runnable{

    Thread t;
    JProgressBar bar;

    String name,username,email,phone,gender,password;
    Loading(String un){

        this.username=un;

        setTitle("Loading...");
        setBounds(350,200,900,400);
        getContentPane().setBackground(new Color(0, 74, 103));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel title=new JLabel("TOUR 360");
        title.setBounds(365,60,170,30);
        title.setFont(new Font("DialogInput",Font.BOLD,35));
        title.setForeground(new Color(208,250,240));
        add(title);

        bar=new JProgressBar();
        bar.setBounds(300,110,300,20);
        bar.setBorder(BorderFactory.createEmptyBorder());
        bar.setBackground(new Color(232, 34, 8, 255));
        bar.setStringPainted(true);
        bar.setForeground(new Color(87, 160, 241, 255));
        add(bar);

        JLabel wait=new JLabel("Loading...");
        wait.setBounds(400,135,100,20);
        wait.setFont(new Font("DialogInput",Font.BOLD,15));
        wait.setForeground(new Color(208,250,240));
        add(wait);

        JLabel uname=new JLabel("Welcome "+username);
        uname.setBounds(360,200,240,25);
        uname.setFont(new Font("DialogInput",Font.BOLD,20));
        uname.setForeground(new Color(208,250,240));
        add(uname);

        t=new Thread(this);
        t.start();

        setVisible(true);
    }

    @Override
    public void run() {

        try{

            for(int i=1; i<=101; i++){

                int max=bar.getMaximum();
                int val=bar.getValue();

                if(val<max){
                    bar.setValue(bar.getValue()+1);
                }
                else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(20);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Loading("");
    }
}
