
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintDemo extends JPanel 
{
    public PaintDemo()
    {
        super();

        setBorder(BorderFactory.createLineBorder(Color.RED, 5));
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        int i=1;

        while(i<=10)
        {
            int x = (int)(Math.random()*getWidth());
            int y = (int)(Math.random()*getHeight());

            g.drawRect(x,y,20,20);

            i++;
        }

    }

}


public class JFrm4 extends JFrame {

    PaintDemo pd;

    public JFrm4()
    {
        super("JPanel");

        pd = new PaintDemo();

        add(pd); 
        
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrm4 a = new JFrm4();
    }
    
}



