package tour360;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    JButton bupdate,bview,bbook,bookp,vpack,pay;

    String name,username,email,phone,gender,password;


    Dashboard(String un){

        this.username=un;

        setTitle("Welcome");
        setBounds(0,0,1540,820);
        getContentPane().setBackground(new Color(208, 240, 250));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        /*------------------------------------------------------------*/
        JPanel p1=new JPanel();
        p1.setBounds(0,0,1540,120);
        p1.setBackground(new Color(0, 74, 103));
        p1.setLayout(null);
        add(p1);

        JLabel logo=new JLabel("TOUR 360");
        logo.setBounds(60,40,250,50);
        logo.setFont(new Font("MONOSPACED",Font.BOLD,50));
        logo.setForeground(Color.WHITE);
        logo.setBorder(BorderFactory.createEmptyBorder());
        p1.add(logo);

        /*------------------------------------------------------------*/

        /*------------------------------------------------------------*/
        JPanel p2=new JPanel();
        p2.setBounds(300,200,300,200);
        p2.setBackground(new Color(71, 156, 255));
        p2.setLayout(null);
        add(p2);

        bupdate=new JButton("Update Account Information");
        bupdate.setBounds(0,140,300,60);
        bupdate.setForeground(new Color(53, 143, 243));
        bupdate.setBackground(new Color(255, 255, 255, 255));
        bupdate.setFont(new Font("DialogInput",Font.BOLD,15));
        bupdate.setBorder(BorderFactory.createEmptyBorder());
        bupdate.addActionListener(this);
        p2.add(bupdate);

        ImageIcon up=new ImageIcon(ClassLoader.getSystemResource("icons/updateinfo.png"));
        Image iup=up.getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
        ImageIcon up2=new ImageIcon(iup);
        JLabel lup=new JLabel(up2);
        lup.setBounds(0,0,300,200);
        p2.add(lup);
        /*------------------------------------------------------------*/

        /*------------------------------------------------------------*/
        JPanel p3=new JPanel();
        p3.setBounds(630,200,300,200);
        p3.setBackground(new Color(0, 74, 103));
        p3.setLayout(null);
        add(p3);

        bview=new JButton("View Account Information");
        bview.setBounds(0,140,300,60);
        bview.setForeground(new Color(0, 74, 103));
        bview.setBackground(Color.white);
        bview.setFont(new Font("DialogInput",Font.BOLD,15));
        bview.setBorder(BorderFactory.createEmptyBorder());
        bview.addActionListener(this);
        p3.add(bview);

        ImageIcon v=new ImageIcon(ClassLoader.getSystemResource("icons/viewinfo.png"));
        Image imv=v.getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
        ImageIcon v2=new ImageIcon(imv);
        JLabel lv=new JLabel(v2);
        lv.setBounds(0,0,300,200);
        p3.add(lv);
        /*------------------------------------------------------------*/

        /*------------------------------------------------------------*/
        JPanel p4=new JPanel();
        p4.setBounds(960,200,300,200);
        p4.setBackground(new Color(243, 216, 28, 255));
        p4.setLayout(null);
        add(p4);

        bbook=new JButton("Check Package");
        bbook.setBounds(0,140,300,60);
        bbook.setForeground(new Color(159, 139, 7, 255));
        bbook.setBackground(Color.white);
        bbook.setFont(new Font("DialogInput",Font.BOLD,15));
        bbook.setBorder(BorderFactory.createEmptyBorder());
        bbook.addActionListener(this);
        p4.add(bbook);

        ImageIcon book=new ImageIcon(ClassLoader.getSystemResource("icons/book.png"));
        Image imb=book.getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
        ImageIcon b=new ImageIcon(imb);
        JLabel lbook=new JLabel(b);
        lbook.setBounds(0,0,300,200);
        p4.add(lbook);
        /*------------------------------------------------------------*/

        JPanel p7=new JPanel();
        p7.setBounds(300,430,300,200);
        p7.setBackground(new Color(213, 44, 22));
        p7.setLayout(null);
        add(p7);

        bookp=new JButton("Book Package");
        bookp.setBounds(0,140,300,60);
        bookp.setForeground(new Color(213, 44, 22));
        bookp.setBackground(Color.white);
        bookp.setFont(new Font("DialogInput",Font.BOLD,15));
        bookp.setBorder(BorderFactory.createEmptyBorder());
        bookp.addActionListener(this);
        p7.add(bookp);

        ImageIcon bp=new ImageIcon(ClassLoader.getSystemResource("icons/cbook.png"));
        Image imbp=bp.getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
        ImageIcon bp2=new ImageIcon(imbp);
        JLabel lbookp=new JLabel(bp2);
        lbookp.setBounds(0,0,300,200);
        p7.add(lbookp);

        /*------------------------------------------------------------*/
        JPanel p5=new JPanel();
        p5.setBounds(630,430,300,200);
        p5.setBackground(new Color(181, 53, 213));
        p5.setLayout(null);
        add(p5);

        vpack=new JButton("View Booked Package");
        vpack.setBounds(0,140,300,60);
        vpack.setForeground(new Color(181, 53, 213));
        vpack.setBackground(Color.WHITE);
        vpack.setFont(new Font("DialogInput",Font.BOLD,15));
        vpack.setBorder(BorderFactory.createEmptyBorder());
        vpack.addActionListener(this);
        p5.add(vpack);

        ImageIcon vp=new ImageIcon(ClassLoader.getSystemResource("icons/viewpack.png"));
        Image ivp=vp.getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
        ImageIcon vp2=new ImageIcon(ivp);
        JLabel lvp=new JLabel(vp2);
        lvp.setBounds(0,0,300,200);
        p5.add(lvp);
        /*------------------------------------------------------------*/

        /*------------------------------------------------------------*/
        JPanel p6=new JPanel();
        p6.setBounds(960,430,300,200);
        p6.setBackground(new Color(243, 89, 158));
        p6.setLayout(null);
        add(p6);

        pay=new JButton("Make Payment");
        pay.setBounds(0,140,300,60);
        pay.setForeground(new Color(243, 89, 158));
        pay.setBackground(Color.WHITE);
        pay.setFont(new Font("DialogInput",Font.BOLD,15));
        pay.setBorder(BorderFactory.createEmptyBorder());
        pay.addActionListener(this);
        p6.add(pay);

        ImageIcon imgpay=new ImageIcon(ClassLoader.getSystemResource("icons/pay.png"));
        Image ipay=imgpay.getImage().getScaledInstance(300,200,Image.SCALE_SMOOTH);
        ImageIcon imgp=new ImageIcon(ipay);
        JLabel lip=new JLabel(imgp);
        lip.setBounds(0,0,300,200);
        p6.add(lip);
        /*------------------------------------------------------------*/



        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==bupdate){
            new Update(username);
        }
        else if(e.getSource()==bview){
            new ViewInfo(username);
        }
        else if(e.getSource()==bbook){
            new CheckPack();
        }
        else if(e.getSource()==bookp){
            new BookPack(username);
        }
        else if(e.getSource()==vpack){
            new ViewBook(username);
        }
        else if(e.getSource()==pay){
            new Payment(username);
        }
    }

    public static void main(String[] args) {
        new Dashboard("");
    }
}
