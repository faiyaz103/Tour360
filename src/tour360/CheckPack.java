package tour360;

import javax.swing.*;
import java.awt.*;

public class CheckPack extends JFrame {

    CheckPack(){

        setTitle("Check Available Packages");
        setSize(1200,600);
        setLocation(200,100);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(154, 222, 255));
        //setLayout(null);

        JTabbedPane tab=new JTabbedPane();
        tab.setBackground(new Color(185, 215, 255));

/*-----------------------------------------------------------------------*/
        JPanel p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(169, 211, 255));
        tab.addTab("Package 1",null,p1);
        add(tab);

        JLabel cox=new JLabel("Cox's Bazar");
        cox.setBounds(450,5,300,30);
        cox.setFont(new Font("DialogInput",Font.BOLD,30));
        cox.setForeground(new Color(53, 143, 243));
        p1.add(cox);

        String coxplan[] = {
                "Duration: 3 Days 2 Nights",
                "Check In: 2nd Thursday on every month from 8 am.",
                "Check Out: 2nd Saturday on every month before 11 am",
                "Total 7 meals.",
                "Explore:",
                "  Inani Beach",
                "  Himchari Falls",
                "  Enjoy Sunset and Sunrise",
                "  Moheshkhali Island",
                "  Barmese Market",
                "  Dulahazra Safari Park",
                "",
                "",
                "",
                "Cost: BDT 5000 Per Person."
        };

        JList l=new JList(coxplan);
        l.setBounds(50,120,350,250);
        p1.add(l);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/cox.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(500,70,600,400);
        p1.add(image);

        /*-----------------------------------------------------------------------*/

        JPanel p2=new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(172, 238, 255));
        tab.addTab("Package 2",null,p2);
        add(tab);

        JLabel saint=new JLabel("Saint Martin");
        saint.setBounds(450,5,300,30);
        saint.setFont(new Font("DialogInput",Font.BOLD,30));
        saint.setForeground(new Color(53, 143, 243));
        p2.add(saint);

        String saintplan[] = {
                "Duration: 3 Days 2 Nights",
                "Check In: 2nd Thursday on every month from 8 am.",
                "Check Out: 2nd Saturday on every month before 11 am",
                "Total 7 meals.",
                "Explore:",
                "  Beach",
                "  Cycle Tour",
                "  Enjoy Sunset and Sunrise",
                "  Chhera Dwip",
                "  Enjoy Campfire",
                "",
                "",
                "",
                "Cost: BDT 6000 Per Person."
        };

        JList lsaint=new JList(saintplan);
        lsaint.setBounds(50,120,350,250);
        p2.add(lsaint);

        ImageIcon is=new ImageIcon(ClassLoader.getSystemResource("icons/saint.jpg"));
        Image is1=is.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon is2=new ImageIcon(is1);
        JLabel image1=new JLabel(is2);
        image1.setBounds(500,70,600,400);
        p2.add(image1);

        /*-------------------------------------------------------*/

        JPanel p3=new JPanel();
        p3.setLayout(null);
        p3.setBackground(new Color(141, 255, 218));
        tab.addTab("Package 3",null,p3);
        add(tab);

        JLabel rang=new JLabel("Rangamati");
        rang.setBounds(450,5,300,30);
        rang.setFont(new Font("DialogInput",Font.BOLD,30));
        rang.setForeground(new Color(0, 74, 103));
        p3.add(rang);

        String rangplan[] = {
                "Duration: 3 Days 2 Nights",
                "Check In: 2nd Thursday on every month from 8 am.",
                "Check Out: 2nd Saturday on every month before 11 am",
                "Total 7 meals.",
                "Explore:",
                "  Kaptai Lake",
                "  Shubholong Waterfall",
                "  Rajbon Bihar",
                "  Chakma Rajbari",
                "  Hanging Bridge",
                "",
                "",
                "",
                "Cost: BDT 4500 Per Person."
        };

        JList lrang=new JList(rangplan);
        lrang.setBounds(50,120,350,250);
        p3.add(lrang);

        ImageIcon irang=new ImageIcon(ClassLoader.getSystemResource("icons/rang.jpg"));
        Image ir1=irang.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon irang2=new ImageIcon(ir1);
        JLabel imager=new JLabel(irang2);
        imager.setBounds(500,70,600,400);
        p3.add(imager);

        /*------------------------------------------------------------*/

        JPanel p4=new JPanel();
        p4.setLayout(null);
        p4.setBackground(new Color(90, 161, 241));
        tab.addTab("Package 4",null,p4);
        add(tab);

        JLabel tang=new JLabel("Tanguar Haor");
        tang.setBounds(450,5,300,30);
        tang.setFont(new Font("DialogInput",Font.BOLD,30));
        tang.setForeground(new Color(0, 74, 103));
        p4.add(tang);

        String tangplan[] = {
                "Duration: 2 Days 1 Nights",
                "Check In: 2nd Friday on every month from 8 am.",
                "Check Out: 2nd Saturday on every month before 7 pm",
                "Total 5 meals.",
                "Explore:",
                "  Watch Tower",
                "  Niladri Lake",
                "  Jadukata River",
                "  Lakmachora",
                "  Barikka Tila",
                "  Shimul Bagan",
                "",
                "",
                "Cost: BDT 7000 Per Person."
        };

        JList ltang=new JList(tangplan);
        ltang.setBounds(50,120,350,250);
        p4.add(ltang);

        ImageIcon itang=new ImageIcon(ClassLoader.getSystemResource("icons/tang.jpg"));
        Image it1=itang.getImage().getScaledInstance(600,400,Image.SCALE_SMOOTH);
        ImageIcon itang2=new ImageIcon(it1);
        JLabel imaget=new JLabel(itang2);
        imaget.setBounds(500,70,600,400);
        p4.add(imaget);

        setVisible(true);
        setResizable(false);
    }

    public static void main(String[] args) {
        new CheckPack();
    }
}
