
import java.awt.*;
import java.awt.event.*;
import mypkg.Util;

public class Frm8 extends Frame implements WindowListener, ActionListener, FocusListener {

    Label lno,lmr;
    TextField tno,tmr;
    Button bok,bcl;
    int rno;
    double mrk;

    Frm8()
    {
        super("Result");

        lno = new Label("Roll No.");
        lmr = new Label("Marks");
        tno = new TextField(10);
        tmr = new TextField(10);

        tno.addFocusListener(this);
        tmr.addFocusListener(this);

        bok = new Button("Ok");
        bcl = new Button("Clear");

        bok.addActionListener(this);
        bcl.addActionListener(this);

        setLayout(new GridLayout(3,3,5,5));

        add(lno);
        add(tno);
        add(lmr);
        add(tmr);
        add(bok);
        add(bcl);

        addWindowListener(this);
        setSize(400,400);
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
    public void focusLost(FocusEvent e){
        TextField t = (TextField)e.getSource();

        if(t == tno)
        {
            try
            {
               rno = Integer.parseInt(tno.getText());
            }
            catch(Exception e1){
                tno.requestFocus();
                return;
            }

            if(rno <= 0)
            {
                tno.requestFocus();
                return;
            }        
        }

        if(t == tmr)
        {
            try
            {
               mrk = Double.parseDouble(tmr.getText());
            }
            catch(Exception e1){
                tmr.requestFocus();
                return;
            }

            if(mrk <= 0.0 || mrk >= 10.0)
            {
                tmr.requestFocus();
                return;
            }     
        }
    
        bok.setEnabled(true);
    }

    @Override
    public void focusGained(FocusEvent e){
        TextField t = (TextField)e.getSource();

        if(t == tno)
        {
            bok.setEnabled(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        Button b = (Button)e.getSource();

        if(b == bok)
        {
            if(mrk <= 0.0 || mrk >= 10.0)
            {
                tno.requestFocus();
                return;
            }

            String s = "Roll No. " + rno + "\nMarks : " + mrk;
            Util.display(s);
        }

        tno.setText("");
        tmr.setText("");

        tno.requestFocus();
    }

    
    public static void main(String[] args){
        
        Frm8 a = new Frm8();
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

