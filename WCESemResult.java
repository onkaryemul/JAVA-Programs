
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import mypkg.Util;


class Result4 implements Serializable 
{
    int no;
    double mrk;

    Result4()
    {
        no = 0;
        mrk = 0.0;
    }

    Result4(int a,double b)
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


class RAMDDialog extends Dialog implements ActionListener,FocusListener
{
    Result4 robj;
    LinkedList<Result4> obj;
    int no;
    double mrk;
    String action;
    Label l1,l2;
    TextField t1,t2;
    Button b1,b2;
    boolean res;

    RAMDDialog(Frame frm,String title,boolean state,LinkedList<Result4> ls)
    {
        super(frm,title,state);

        obj = ls;
        action = title; // ADD,MOD,DEL

        l1 = new Label("No");
        l2 = new Label("Marks");
        t1 = new TextField(10);
        t2 = new TextField(10);

        t1.addFocusListener(this);
        t2.addFocusListener(this);

        b1 = new Button("Update");
        b2 = new Button("Back");
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3,2,5,5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);

        setSize(400,300);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void focusGained(FocusEvent e)
    {
        TextField t = (TextField)e.getSource();

        if(t == t1)
        {
            b1.setEnabled(false);
        }
    }

    @Override
    public void focusLost(FocusEvent e)
    {
        TextField t = (TextField)e.getSource();

        if(t == t1)
        {
            try
            {
                no = Integer.parseInt(t1.getText());
            }
            catch(Exception e1){
                t1.setText("0");
                t1.requestFocus();
                return;
            }

            res = search(no);
            
            if(res == true)
            {
                if(action.equals("ADD"))
                {
                    t1.setText("0");
                    t1.requestFocus();
                    return;
                }

                t2.setText("" + robj.mrk);

                if(action.equals("DEL"))
                {
                    t2.setEditable(false);
                    b1.setEnabled(true);
                }
            }
            else
            {
                if(action.equals("ADD"))
                {
                    ;
                }
                else
                {
                    t1.requestFocus();
                    return;
                }
            }
        }

        if(t == t2)
        {
            try
            {
                mrk = Double.parseDouble(t2.getText());
            }
            catch(Exception e1)
            {
                t2.requestFocus();
                return;
            }

            if(mrk<0.0 || mrk>10.0)
            {
                t2.requestFocus();
                return;
            }

            b1.setEnabled(true);
        }
             
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b==b1)
        {
            if(action.equals("ADD"))
            {
                robj = new Result4(no,mrk);
                obj.add(robj);
            }

            if(action.equals("MOD"))
            {
                robj.no = no;
                robj.mrk = mrk;
            }

            if(action.equals("DEL"))
            {
                obj.remove(robj);
            }
        }
        
        setVisible(false);
    }

    public boolean search(int no)
    {
        int i = 0;
        int n = obj.size();

        while(i<n)
        {
            robj = (Result4)obj.get(i);

            if(robj.no == no)
            {
                break;
            }

            i++;
        }

        if(i == n)
        {
            robj = null;
            return false;
        }
        else
        {
            return true;
        }
        
    }

} 


class RDDisplay extends Dialog implements ActionListener
{
    int index,n;
    int no;
    double mrk;

    LinkedList<Result4> obj;
    Result4 robj;

    Label l1,l2;
    TextField t1,t2;
    Panel p1,p2;
    Button bf; // first
    Button bl; // last
    Button bp; // previous
    Button bn; // next

    RDDisplay(Frame prnt, String title, boolean state, LinkedList<Result4> ls)
    {
        super(prnt,title,state);

        obj = ls;

        l1 = new Label("No");
        l2 = new Label("Marks");
        t1 = new TextField(10);
        t2 = new TextField(10);

        t1.setEditable(false);
        t2.setEditable(false);

        p1 = new Panel();
        p1.setLayout(new GridLayout(2,2,5,5));
        p1.add(l1);
        p1.add(t1);
        p1.add(l2);
        p1.add(t2);

        bf = new Button("|<");
        bp = new Button("<<");
        bn = new Button(">>");
        bl = new Button(">|");

        bf.addActionListener(this);
        bp.addActionListener(this);
        bn.addActionListener(this);
        bl.addActionListener(this);

        p2 = new Panel(); // Default layout ---> Flowlayout
        p2.add(bf);
        p2.add(bp);
        p2.add(bn);
        p2.add(bl);

        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);

        setSize(300,200);
        setResizable(false);

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                setVisible(false);
            }
        });

        robj = null;
        n = obj.size();
        index = 0;

        if(n>0)
        {
            robj = (Result4)obj.get(index);

            no = robj.no;
            mrk =  robj.mrk;

            t1.setText("" + no);
            t2.setText("" + mrk);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b==bf)
        {
            index = 0;
        }

        if(b==bl)
        {
            index = n-1;
        }

        if(b==bp)
        {
            if(--index < 0)
            {
                index = 0;
            }
        }

        if(b==bn)
        {
            if(++index >= n)
            {
                index = n-1;
            }
        }

        robj = (Result4)obj.get(index);
        no = robj.no;
        mrk = robj.mrk;
        t1.setText("" + no);
        t2.setText("" + mrk);
    }

}


public class WCESemResult extends Frame implements ActionListener {

    Button ba,bm,bd,bdisp;
    LinkedList<Result4> obj;
    RDDisplay oDisplay;
    RAMDDialog aDialog;
    WCESemResult parent;

    WCESemResult()
    {
        super("Result");

        parent = this;

        ba = new Button("ADD");
        bm = new Button("MOD");
        bd = new Button("DEL");
        bdisp = new Button("DISPLAY");

        ba.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        bdisp.addActionListener(this);
        
        Panel p = new Panel();
        p.setLayout(new GridLayout(2,2,5,5));
        p.add(ba);
        p.add(bm);
        p.add(bd);
        p.add(bdisp);

        add(p,BorderLayout.CENTER);

        setSize(300,300);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        obj = new LinkedList<Result4>();

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b==ba)
        {
            aDialog = new RAMDDialog(parent,"ADD",true,obj);
        }

        if(b==bm)
        {
            aDialog = new RAMDDialog(parent,"MOD",true,obj);
        }

        if(b==bd)
        {
            aDialog = new RAMDDialog(parent,"DEL",true,obj);
        }
        
        if(b==bdisp)
        {
            oDisplay = new RDDisplay(parent,"DISPLAY",true,obj);
        }

    }
    

    public static void main(String[] args){

        WCESemResult a = new WCESemResult();
        
    }
    
}


