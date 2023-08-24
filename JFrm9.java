
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;


class TAdd extends JDialog implements ActionListener
{
    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;

    public TAdd(JFrame frm, String title, boolean state)
    {
        super(frm, title, state);

        l1 = new JLabel("Trade ID");
        l2 = new JLabel("Name");

        t1 = new JTextField(10);
        t2 = new JTextField(20);

        b1 = new JButton("Ok");
        b2 = new JButton("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3,2,5,5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(b1);
        add(b2);

        setSize(400,400);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource();

        if(b == b2)
        {
            setVisible(false);
        }
        else
        {
            String str = "Trade ID : " + t1.getText() + "\nName : " + t2.getText();
            JOptionPane.showMessageDialog(null, str);
        }
    }

}


public class JFrm9 extends JFrame {

    JTree jt;
    JLabel l1;

    TAdd ta;

    public JFrm9()
    {
        super("Tree");

        ta = new TAdd(this, "Trade Add", true);
        
        l1 = new JLabel("Choose Options");
        
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");  // create a top node of tree

        DefaultMutableTreeNode t = new DefaultMutableTreeNode("Trade");
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

        jt.addTreeSelectionListener(new TreeSelectionListener(){
            @Override
            public void valueChanged(TreeSelectionEvent e)
            {
                DefaultMutableTreeNode a = (DefaultMutableTreeNode)jt.getLastSelectedPathComponent();

                if(a != null)
                {
                    Object b = a.getUserObject();

                    if(a.isLeaf() && a==t1)
                    {
                        ta.setVisible(true);
                    }
                }

                l1.setText("Selection is " + e.getPath());
            }
        });

        add(new JScrollPane(jt));

        add(l1, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300,300);
        setVisible(true);
    }
    

    public static void main(String[] args) {
        JFrm9 a = new JFrm9();
    }

}



