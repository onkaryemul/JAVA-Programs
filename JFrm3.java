
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class PaintDemo extends JPanel //implements Runnable 
{
    public PaintDemo()
    {
        super();

        setBorder(BorderFactory.createLineBorder(Color.RED, 5));

        // Thread th = new Thread(this);
        // th.start();
    }

    public void draw()
    {
        Graphics g = getGraphics();

        while(true)
        {
            int x = (int)(Math.random()*getWidth());
            int y = (int)(Math.random()*getHeight());

            g.drawRect(x,y,20,20);

            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e){}
        }
    }

    // @Override
    // public void run()
    // {
    //     draw();
    // }
    
}


public class JFrm3 extends JFrame {

    PaintDemo pd;

    public JFrm3()
    {
        super("JPanel");

        pd = new PaintDemo();

        add(pd); 
         
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pd.draw();
    }

    public static void main(String[] args) {
        JFrm3 a = new JFrm3();
    }
    
}



