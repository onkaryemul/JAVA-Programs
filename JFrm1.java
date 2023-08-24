
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrm1 extends JFrame implements ActionListener {

    JLabel l1,l2;
    JTextField t1,t2;
    JButton b1,b2;

    public JFrm1()
    {
        super("Student");

        l1 = new JLabel("Roll No.");
        l2 = new JLabel("Name");

        t1 = new JTextField(10);
        t2 = new JTextField(30);

        b1 = new JButton("Ok");
        b2 = new JButton("Clear");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3,2,5,5));

        add(l1);
        add(t1);

        add(l2);
        add(t2);

        add(b1);
        add(b2);

        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource();

        if(b==b1)
        {
            String str = "Roll No. " + t1.getText() + "\nName : " + t2.getText();
            JOptionPane.showMessageDialog(null,str);
        }

        t1.setText("");
        t2.setText("");

        t1.requestFocus();
    }

    public static void main(String[] args) {
        JFrm1 a = new JFrm1();
    }
    
}



