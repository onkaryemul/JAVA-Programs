
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.tree.*;

import java.io.*;
import java.util.*;


class Trade implements Serializable 
{
    int no;
    String nm;

    public Trade(int a, String b) 
    {
        no = a;
        nm = b;
    }

    public String toString() 
    {
        String s = "\nRoll No :" + no + "\nName :" + nm;
        return s;
    }
}


class TDisplay extends JDialog implements ActionListener 
{
    JButton b1;

    Trade obj;
    LinkedList<Trade> ls;

    JTable jt;
    DefaultTableModel dtm; // model for JTable

    String[] chead = { "Trade No", "Name" }; // column head
    Object[][] arr = null; // two dimensional array

    public TDisplay(JFrame frm, String title, boolean state, LinkedList<Trade> ls) 
    {
        super(frm, title, true);

        this.ls = ls;

        dtm = new DefaultTableModel(arr, chead);

        int i = 0, n = ls.size();

        while (i < n) 
        {
            obj = ls.get(i);
            dtm.insertRow(i, new String[] { "" + obj.no, obj.nm });
            i++;
        }

        jt = new JTable(dtm);
        add(jt);

        b1 = new JButton("Print");
        b1.addActionListener(this);

        add(b1, BorderLayout.SOUTH);

        setSize(400, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        try 
        {
            jt.print();
        } catch (Exception e1) {}
    }

}


class TAdd extends JDialog implements ActionListener, FocusListener 
{
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;

    int no;
    String nm;

    Trade obj;
    LinkedList<Trade> ls;

    public TAdd(JFrame frm, String title, boolean state, LinkedList<Trade> ls) 
    {
        super(frm, title, state);

        this.ls = ls;

        l1 = new JLabel("Trade ID");
        l2 = new JLabel("Name");

        t1 = new JTextField(10);
        t1.addFocusListener(this);
        t2 = new JTextField(20);

        b1 = new JButton("OK");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3, 2, 5, 5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(b1);
        add(b2);

        setSize(400, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton b = (JButton) e.getSource();

        if (b == b2)
        {
            setVisible(false);
        }
        else 
        {
            try 
            {
                no = Integer.parseInt(t1.getText());
                nm = t2.getText();

                obj = new Trade(no, nm);

                ls.add(obj);
            } catch (Exception e1) {}

            t1.requestFocus();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) 
    {
        int i = 0, n = ls.size();

        try 
        {
            no = Integer.parseInt(t1.getText());
        } catch (Exception e1) {}

        // this checking is to avoid the duplication
        while (i < n) 
        {
            obj = ls.get(i);

            if (obj.no == no) 
            {
                break;
            }

            i++;
        }

        if (i != n) 
        {
            t2.setText(obj.nm);
            t1.requestFocus();
            return;
        }
    }

}


class TMod extends JDialog implements ActionListener, FocusListener 
{
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;

    int no;
    String nm;

    Trade obj;
    LinkedList<Trade> ls;

    public TMod(JFrame frm, String title, boolean state, LinkedList<Trade> ls) 
    {
        super(frm, title, state);

        this.ls = ls;

        l1 = new JLabel("Trade ID");
        l2 = new JLabel("Name");

        t1 = new JTextField(10);
        t1.addFocusListener(this);
        t2 = new JTextField(20);

        b1 = new JButton("OK");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3, 2, 5, 5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(b1);
        add(b2);

        setSize(400, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton) e.getSource();

        if (b == b2)
        {
            setVisible(false);
        }
        else 
        {
            try 
            {
                no = Integer.parseInt(t1.getText());
                nm = t2.getText();

                obj.no = no;
                obj.nm = nm;
            } catch (Exception e1) {}

            t1.requestFocus();
        }
    }

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) 
    {
        int i = 0, n = ls.size();

        try 
        {
            no = Integer.parseInt(t1.getText());
        } catch (Exception e1) {}

        // this checking is to avoid the duplication
        while (i < n) 
        {
            obj = ls.get(i);

            if (obj.no == no) 
            {
                break;
            }

            i++;
        }

        if (i == n) 
        {
            t1.requestFocus();
            return;
        }

        // record found
        t1.setText("" + obj.no);
        t2.setText(obj.nm); // displaying the found record info
    }
}


class TDel extends JDialog implements ActionListener, FocusListener 
{
    JLabel l1, l2;
    JTextField t1, t2;
    JButton b1, b2;

    int no;
    String nm;

    Trade obj;
    LinkedList<Trade> ls;

    public TDel(JFrame frm, String title, boolean state, LinkedList<Trade> ls) 
    {
        super(frm, title, state);

        this.ls = ls;

        l1 = new JLabel("Trade ID");
        l2 = new JLabel("Name");

        t1 = new JTextField(10);
        t1.addFocusListener(this);
        t2 = new JTextField(20);
        t2.setEditable(false);

        b1 = new JButton("OK");
        b2 = new JButton("BACK");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3, 2, 5, 5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(b1);
        add(b2);

        setSize(400, 400);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        JButton b = (JButton) e.getSource();

        if (b == b2)
        {
            setVisible(false);
        }
        else 
        {
            ls.remove(obj);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {}

    @Override
    public void focusLost(FocusEvent e) 
    {
        int i = 0, n = ls.size();

        try 
        {
            no = Integer.parseInt(t1.getText());
        } catch (Exception e1) {}

        // this checking is to avoid the duplication
        while (i < n) 
        {
            obj = ls.get(i);

            if (obj.no == no) 
            {
                break;
            }

            i++;
        }

        if (i == n) 
        {
            t1.requestFocus();
            return;
        }

        // record found
        t1.setText("" + obj.no);
        t2.setText(obj.nm); // displaying the found record info
    }
}


public class JFrm10 extends JFrame {

    JTree jt;
    JLabel l1;

    TAdd ta;
    TMod tm;
    TDel tl;
    TDisplay td;

    LinkedList<Trade> ls;

    public JFrm10() 
    {
        super("Tree");

        ls = new LinkedList<Trade>();

        l1 = new JLabel("Choose Option");

        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options"); // create a top node of tree

        DefaultMutableTreeNode t = new DefaultMutableTreeNode("Trade"); // subtree

        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("ADD");
        DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("MOD");
        DefaultMutableTreeNode t3 = new DefaultMutableTreeNode("DEL");
        DefaultMutableTreeNode t4 = new DefaultMutableTreeNode("DISPLAY");

        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);

        top.add(t);

        jt = new JTree(top);

        jt.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) 
            {
                DefaultMutableTreeNode a = (DefaultMutableTreeNode) jt.getLastSelectedPathComponent();
                
                if (a != null) 
                {
                    if (a.isLeaf() && a == t1) 
                    {
                        ta = new TAdd(null, "Trade Add", true, ls);
                        ta.setVisible(true);
                    }

                    if (a.isLeaf() && a == t2) 
                    {
                        tm = new TMod(null, "Modify", true, ls);
                        tm.setVisible(true);
                    }

                    if (a.isLeaf() && a == t3) 
                    {
                        tl = new TDel(null, "Delete", true, ls);
                        tl.setVisible(true);
                    }

                    if (a.isLeaf() && a == t4) 
                    {
                        td = new TDisplay(null, "Display", true, ls);
                        td.setVisible(true);
                    }
                }

                l1.setText("Selection is " + e.getPath());
            }
        });

        add(new JScrollPane(jt));

        add(l1, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrm10 a = new JFrm10();
    }
}



