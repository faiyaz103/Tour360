package tour360;

import javax.swing.*;
import java.awt.*;

public class Opening extends JFrame implements Runnable{

    Thread thread;
    Opening(){
        setTitle("TOUR 360");
        setSize(1200,600);
        setLocation(200,100);
        getContentPane().setBackground(new Color(208,250,240));
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        setLayout(null);

        JLabel logo=new JLabel("TOUR 360");
        logo.setFont(new Font("DialogInput",Font.BOLD,100));
        logo.setBounds(360,50,480,150);
        logo.setForeground(new Color(0,76,103));
        add(logo);

        ImageIcon ic1=new ImageIcon(ClassLoader.getSystemResource("icons/splash1.png"));
        Image im1=ic1.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon ic2=new ImageIcon(im1);
        JLabel image1=new JLabel(ic2);
        image1.setBounds(100,250,200,200);
        add(image1);

        ImageIcon ic3=new ImageIcon(ClassLoader.getSystemResource("icons/splash2.png"));
        Image im2=ic3.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon ic4=new ImageIcon(im2);
        JLabel image2=new JLabel(ic4);
        image2.setBounds(300,250,200,200);
        add(image2);

        ImageIcon ic5=new ImageIcon(ClassLoader.getSystemResource("icons/splash3.png"));
        Image im3=ic5.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon ic6=new ImageIcon(im3);
        JLabel image3=new JLabel(ic6);
        image3.setBounds(500,250,200,200);
        add(image3);

        ImageIcon ic7=new ImageIcon(ClassLoader.getSystemResource("icons/splash4.png"));
        Image im4=ic7.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon ic8=new ImageIcon(im4);
        JLabel image4=new JLabel(ic8);
        image4.setBounds(700,250,200,200);
        add(image4);

        ImageIcon ic9=new ImageIcon(ClassLoader.getSystemResource("icons/splash5.png"));
        Image im5=ic9.getImage().getScaledInstance(200,200,Image.SCALE_SMOOTH);
        ImageIcon ic0=new ImageIcon(im5);
        JLabel image5=new JLabel(ic0);
        image5.setBounds(900,250,200,200);
        add(image5);

        setResizable(false);
        setVisible(true);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

        try{
            Thread.sleep(3500);
            new Login();
            setVisible(false);
        }
        catch (Exception e){

        }
    }

    public static void main(String[] args){

        new Opening();
    }
}
