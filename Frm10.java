
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import mypkg.Util;

public class Frm10 extends Frame implements ActionListener, WindowListener, FocusListener, ItemListener {

    Label lno,lnm,ltnm;
    TextField tno,tnm;
    Choice ctnm;
    Button ba,bm,bd,bdisp;
    Panel p1,p2;

    int no;
    String nm,trade;
    Boolean res;

    Student10 obj;
    LinkedList<Student10> ls;

    public Frm10()
    {
        super("Student Data");

        lno = new Label("Roll No.");
        lnm = new Label("Name");
        ltnm = new Label("Trade");
        tno = new TextField(10);
        tnm = new TextField(30);
        ctnm = new Choice();

        ctnm.add("CSE");
        ctnm.add("IT");
        ctnm.add("ENTC");
        ctnm.add("MECH");
        ctnm.add("ELEC");
        ctnm.add("CIVIL");
        ctnm.add("AUTOMOBILE");
        ctnm.add("AEROSPACE");
        ctnm.add("CHEMICAL");
        
        ctnm.addItemListener(this);

        tno.addFocusListener(this);
        tnm.addFocusListener(this);

        p1 = new Panel();
        p1.setLayout(new GridLayout(3,2,5,5));
        p1.add(lno);
        p1.add(tno);
        p1.add(lnm);
        p1.add(tnm);
        p1.add(ltnm);
        p1.add(ctnm);

        ba = new Button("ADD");
        bm = new Button("MOD");
        bd = new Button("DEL");
        bdisp = new Button("DISPLAY");

        ba.addActionListener(this);
        bm.addActionListener(this);
        bd.addActionListener(this);
        bdisp.addActionListener(this);

        p2 = new Panel();
        p2.setLayout(new GridLayout(1,4,5,5));
        p2.add(ba);
        p2.add(bm);
        p2.add(bd);
        p2.add(bdisp);

        add(p1,BorderLayout.CENTER);
        add(p2,BorderLayout.SOUTH);

        no = 0;
        nm = new String();
        trade = new String();

        obj = new Student10();
        ls = new LinkedList<Student10>();

        addWindowListener(this);
        setSize(400,300);
        setVisible(true);
    }

    // 7 methods of windowListener  same
    // actionPeformed    empty
    // focuslost and focusgained   empty
    // open(Same --> Student2324.dat) and close(Student2324.dat)  same
    // search()  same (.rno ---> .no)

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
    public void actionPerformed(ActionEvent e) {
        Button b = (Button)e.getSource();

        if(b == ba)
        {
            obj = new Student10(no,nm,trade);
            ls.add(obj);
        }

        if(b == bm)
        {
            obj.nm = nm;
            obj.tnm = trade;
        }

        if(b == bd)
        {
            ls.remove(obj);
        }

        if(b == bdisp)
        {
            int i = 0;
            int n = ls.size();

            while(i<n)
            {
                obj = (Student10)ls.get(i);

                obj.display();

                i++;
            }

        }

        tno.requestFocus();
    }

    @Override
    public void focusLost(FocusEvent e) {
        TextField t = (TextField)e.getSource();

        if(t == tno)
        {
            try
            {
                no = Integer.parseInt(tno.getText());
            }
            catch(Exception e1){
                tno.requestFocus();
                return;
            }

            res = search();

            if(res == true) // record found
            {
                ba.setEnabled(false);
                bm.setEnabled(true);
                bd.setEnabled(true);
    
                tnm.setText(obj.nm);
                ctnm.select(obj.tnm);
            }
            else
            {
                ba.setEnabled(true);
                bm.setEnabled(false);
                bd.setEnabled(false);
            }
    
        }

        if(t == tnm)
        {
            nm = tnm.getText();
            nm = nm.trim(); // leading trailing 
            
            if(nm.length() == 0)
            {
                tnm.requestFocus();
                return;
            }
        }
       
    }

    @Override
    public void focusGained(FocusEvent e) {
        TextField t = (TextField)e.getSource();

        if(t == tno)
        {
            ba.setEnabled(false);
            bm.setEnabled(false);
            bd.setEnabled(false);
        }

    }
    
    @Override
    public void itemStateChanged(ItemEvent e)
    {
        trade = ctnm.getSelectedItem();
    }

    public void open()
    {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try
        {
            fis = new FileInputStream("Student2324.dat");
            ois = new ObjectInputStream(fis);

            ls = (LinkedList<Student10>)ois.readObject();

            fis.close();
            ois.close();
        }
        catch(Exception e)
        {
            ls = new LinkedList<Student10>();
        }

    }

    public void close()
    {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try
        {
            fos = new FileOutputStream("Student2324.dat");
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
            obj = (Student10)ls.get(i);

            if(obj.no == no)
            {
                res = true;
                break;
            }

            i++;
        }

        return res;
    }


    public static void main(String[] args){
        
        Frm10 a = new Frm10();
    }
    
}

