
import java.awt.*;
import java.awt.event.*;
import mypkg.Util;

public class Frm7 extends Frame implements WindowListener, ActionListener {

    Panel p1,p2;
    Label lno,lnm,lmr;
    TextField tno,tnm,tmr;
    Button bok,bcl;

    int rno;;
    String nm;
    double mrk;

    Frm7()
    {  
        super("Result");
        lno = new Label("No");
        lnm = new Label("Name");
        lmr = new Label("Marks");
        tno = new TextField(10);
        tnm = new TextField(20);
        tmr = new TextField(10);

        p1 = new Panel();
        p1.setLayout(new GridLayout(3,2,5,5));
        p1.add(lno);
        p1.add(tno);
        p1.add(lnm);
        p1.add(tnm);
        p1.add(lmr);
        p1.add(tmr);
        add(p1,BorderLayout.CENTER);

        bok = new Button("Ok");
        bcl = new Button("Clear");
        bok.addActionListener(this);
        bcl.addActionListener(this);

        p2 = new Panel();
        p2.add(bok);
        p2.add(bcl);
        add(p2,BorderLayout.SOUTH);

        addWindowListener(this);
        setSize(500,400);
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
        System.out.println("Opened");
    }

    @Override
    public void windowClosed(WindowEvent e){}

    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
        System.out.println("Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        System.out.println("Deactivated");
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        System.out.println("Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        System.out.println("Deiconified");
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b == bok)
        {
            try
            {
                rno = Integer.parseInt(tno.getText());
            }
            catch(Exception e1)
            {
                tno.requestFocus();
                return;
            }

            if(rno <= 0)
            {
                tno.requestFocus();
                return;
            }

            nm = tnm.getText();
            if(nm.length() == 0)
            {
                tnm.requestFocus();
                return;
            }

            try
            {
                mrk = Double.parseDouble(tmr.getText());
            }
            catch(Exception e1)
            {
                tmr.requestFocus();
                return;
            }

            if( mrk<0.0 || mrk > 10.0 )
            {
                tmr.requestFocus();
                return;
            }

            String s = "Roll No. " + rno + "\nName : " + nm + "\nMarks " + mrk;
            Util.display(s);
        }

        tno.setText("");
        tnm.setText("");
        tmr.setText("");

        tno.requestFocus();
    }

    public static void main(String[] args){
        
        Frm7 a = new Frm7();
    }

}

/*
   Window is created :
   1) Window Activated
   2) Opened
   
   When minimized:
   1) Iconified &
   2) Deactivated

   When maximized:
   1) DeIconified
   2) Activated
 */
