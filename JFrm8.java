
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;


public class JFrm8 extends JFrame {

    JTree jt;
    JLabel l1;

    public JFrm8()
    {
        super("Tree");
        
        l1 = new JLabel("Choose Options");
        
        DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");  // create a top node of tree

        DefaultMutableTreeNode t = new DefaultMutableTreeNode("Trade");
        DefaultMutableTreeNode t1 = new DefaultMutableTreeNode("CSE");
        DefaultMutableTreeNode t2 = new DefaultMutableTreeNode("IT");
        DefaultMutableTreeNode t3 = new DefaultMutableTreeNode("ELECTRONICS");
        DefaultMutableTreeNode t4 = new DefaultMutableTreeNode("ELECTRICAL");
    
        t.add(t1);
        t.add(t2);
        t.add(t3);
        t.add(t4);

        DefaultMutableTreeNode y = new DefaultMutableTreeNode("Year");
        DefaultMutableTreeNode y1 = new DefaultMutableTreeNode("I");
        DefaultMutableTreeNode y2 = new DefaultMutableTreeNode("II");
        DefaultMutableTreeNode y3 = new DefaultMutableTreeNode("III");
        DefaultMutableTreeNode y4 = new DefaultMutableTreeNode("IV");

        y.add(y1);
        y.add(y2);
        y.add(y3);
        y.add(y4);

        top.add(t);
        top.add(y);

        jt = new JTree(top);

        jt.addTreeSelectionListener(new TreeSelectionListener(){
            @Override
            public void valueChanged(TreeSelectionEvent e)
            {
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
        JFrm8 a = new JFrm8();
    }

}



