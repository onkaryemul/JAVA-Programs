
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrm6 extends JFrame {

    JLabel l1;

    public JFrm6()
    {
        super("Frame");

        l1 = new JLabel(new ImageIcon("fish.jpg"));

        add(l1);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrm6 a = new JFrm6();
    }
    
}
