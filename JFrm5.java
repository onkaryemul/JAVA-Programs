

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyPanel extends JPanel 
{
    int x,y;

    public MyPanel()
    {
        super();

        setBorder(BorderFactory.createLineBorder(Color.RED, 5));
    
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                x = e.getX();
                y = e.getY();
            }
        });
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawRect(x,y,20,20);
    }
}


public class JFrm5 extends JFrame {

    MyPanel obj;

    public JFrm5()
    {
        super("JPanel");

        obj = new MyPanel();

        add(obj);

        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){
        JFrm5 a = new JFrm5();
    }
    
}
