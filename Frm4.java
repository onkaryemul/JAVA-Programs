
import java.awt.*;
import java.awt.event.*;

public class Frm4 extends Frame implements ActionListener {
    
    Panel p1,p2,p3;
    Button br,bg,bb,brnd,bclr,bext;
    int r,g,b;
    Color cr;

    Frm4()
    {
        super("Color");

        br = new Button("R");
        bg = new Button("G");
        bb = new Button("B");
        brnd = new Button("RND");
        bclr = new Button("CLR");
        bext = new Button("EXT");

        br.addActionListener(this);
        bg.addActionListener(this);
        bb.addActionListener(this);
        brnd.addActionListener(this);
        bclr.addActionListener(this);
        bext.addActionListener(this);

        p1 = new Panel();
        p1.setLayout(new GridLayout(2,3,5,5));
        p1.add(br);
        p1.add(bg);
        p1.add(bb);
        p1.add(brnd);
        p1.add(bclr);
        p1.add(bext);

        p2 = new Panel();

        p3 = new Panel();
        p3.setLayout(null);

        p1.setBounds(20,20,200,100);
        p2.setBounds(20,130,200,100);

        p3.add(p1);
        p3.add(p2);

        add(p3); // method related to container i.e. frame
        setSize(240,270);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button ba = (Button)e.getSource();

        if(ba == bext)
        {
            System.exit(0);
        }

        if(ba == br)
        {
            r=25;
            g=0;
            b=0;
            cr = new Color(r,g,b);
        }

        if(ba == bg)
        {
            g = 255;
            r = b = 0;
            cr = new Color(r,g,b);
        }

        if(ba == bb)
        {
            b = 255;
            g=r=0;
        }

        if(ba == brnd)
        {
            r = (int)(Math.random()*255);
            g = (int)(Math.random()*255);
            b = (int)(Math.random()*255);
        }

        if(ba == bclr)
        {
            r=g=b=255;
        }

        cr = new Color(r,g,b);
        p2.setBackground(cr);
    }

    public static void main(String[] args) {
        
        Frm4 a = new Frm4();
    }

}
