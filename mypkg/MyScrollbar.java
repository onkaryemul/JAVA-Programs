
package mypkg;

import java.awt.*;
import java.awt.event.*;

public class MyScrollbar extends Dialog implements ActionListener, AdjustmentListener, FocusListener {

    public Label lr,lg,lb,lclr;
    public TextField tr,tg,tb;
    public Panel pr,pg,pb,pclr;
    public Button bs,bb;
    public Scrollbar sr,sg,sb;

    public int r,g,b;
    public Color cr;

    public MyScrollbar(Frame prnt, String title, boolean state)
    {
        super(prnt,title,state);

        lr = new Label("R");
        lg = new Label("G");
        lb = new Label("B");
        lclr = new Label("Color");

        pr = new Panel();
        pg = new Panel();
        pb = new Panel();
        pclr = new Panel();

        tr = new TextField("0");
        tg = new TextField("0");
        tb = new TextField("0");

        tr.addFocusListener(this);
        tg.addFocusListener(this);
        tb.addFocusListener(this);

        bs = new Button("SELECT");
        bb = new Button("BACK");

        bs.addActionListener(this);
        bb.addActionListener(this);

        sr = new Scrollbar(Scrollbar.VERTICAL,0,10,0,255);
        sg = new Scrollbar(Scrollbar.VERTICAL,0,10,0,255);
        sb = new Scrollbar(Scrollbar.VERTICAL,0,10,0,255);

        sr.addAdjustmentListener(this);
        sg.addAdjustmentListener(this);
        sb.addAdjustmentListener(this);

        setLayout(null);

        lr.setBounds(50,50,30,20);
        lg.setBounds(90,50,30,20);
        lb.setBounds(130,50,30,20);
        lclr.setBounds(170,50,100,20);

        sr.setBounds(50,80,30,100);
        sg.setBounds(90,80,30,100);
        sb.setBounds(130,80,30,100);

        pclr.setBounds(170,80,100,100);
        pr.setBounds(50,190,30,20);
        pg.setBounds(90,190,30,20);
        pb.setBounds(130,190,30,20);

        bs.setBounds(170,190,100,20);
        
        tr.setBounds(50,220,30,20);
        tg.setBounds(90,220,30,20);
        tb.setBounds(130,220,30,20);

        bb.setBounds(170,230,100,20);

        add(lr);
        add(lg);
        add(lb);
        add(lclr);

        add(sr);
        add(sg);
        add(sb);
        
        add(pclr);
        add(pr);
        add(pg);
        add(pb);

        add(tr);
        add(tg);
        add(tb);

        add(bb);

        setSize(320,290);
        setResizable(false);
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e)
    {
        r = sr.getValue();
        g = sg.getValue();
        b = sb.getValue();

        pr.setBackground(new Color(r,0,0));
        pg.setBackground(new Color(0,g,0));
        pb.setBackground(new Color(0,0,b));
        pclr.setBackground(new Color(r,g,b));

        tr.setText("" + r);
        tg.setText("" + g);
        tb.setText("" + b);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b1 = (Button)e.getSource();
        
        if(b1 == bs)
        {
            cr = new Color(r,g,b);
        }
        else
        {
            setVisible(false);
        }
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        try
        {
            r = (Integer.parseInt(tr.getText()));
            g = (Integer.parseInt(tg.getText()));
            b = (Integer.parseInt(tb.getText()));
        }
        catch(Exception eq)
        {
            r = g = b = 100;
        }

        if(r<0 || r>255)
        {
            tr.requestFocus();
            return;
        }
        
        if(g<0 || g>255)
        {
            tg.requestFocus();
            return;
        }

        if(b<0 || b>255)
        {
            tb.requestFocus();
            return;
        }

        sr.setValue(r);
        sg.setValue(g);
        sb.setValue(b);

        pr.setBackground(new Color(r,0,0));
        pg.setBackground(new Color(0,g,0));
        pb.setBackground(new Color(0,0,b));

        cr = new Color(r,g,b);

        pclr.setBackground(cr);

    }
}


