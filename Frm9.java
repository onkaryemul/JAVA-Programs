
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import mypkg.Util;

class WResult implements Serializable {

    public int no;
    public double mrk;

    public WResult()
    {
        no = 0;
        mrk = 0.0;
    }

    public WResult(int a,double b)
    {
        no = a;
        mrk = b;
    }

    public String toString()
    {
        String s = "\nRoll No. : " + no + "\nMarks : " + mrk;
        return s;
    }

    public void display()
    {
        Util.display(toString());
    }
}


public class Frm9 extends Frame implements WindowListener, ActionListener, FocusListener {

    Label lno,lmr;
    TextField tno,tmr;
    Button bok,bcl;
    int rno;
    double mrk;

    WResult obj;
    LinkedList<WResult> ls;

    Frm9()
    {
        super("Result");

        ls = new LinkedList<WResult>();

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
        open();
        System.out.println("Opened");
    }

    @Override
    public void windowClosed(WindowEvent e){}

    @Override
    public void windowClosing(WindowEvent e)
    {
        close();
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
            
            boolean res = search();

            if(res == true)
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

            obj = new WResult(rno,mrk);
            ls.add(obj);
        }
        else
        {
            displayAll();
        }

        tno.setText("");
        tmr.setText("");

        tno.requestFocus();
    }

    public void open()
    {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try
        {
            fis = new FileInputStream("Result.dat");
            ois = new ObjectInputStream(fis);
            
            ls = (LinkedList<WResult>)ois.readObject();

            fis.close();
            ois.close();
        }
        catch(Exception e)
        {
            ls = new LinkedList<WResult>();
        }
    }

    public void close()
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        try
        {
            fos = new FileOutputStream("Result.dat");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(ls);

            fos.close();
            oos.close();
        }
        catch(Exception e){}
    }
    
    public boolean search()
    {
        int i = 0;
        int n = ls.size();
        boolean res = false;

        while(i < n)
        {
            obj = (WResult)ls.get(i);

            if(obj.no == rno)
            {
                res = true;
                break;
            }

            i++;
        }

        return res;
    }

    public void displayAll()
    {
        int i = 0;
        int n = ls.size();

        while(i < n)
        {
            obj = (WResult)ls.get(i);
            obj.display();
            i++;
        }
    }
    
    public static void main(String[] args){
        
        Frm9 a = new Frm9();
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

