
import java.awt.*;
import java.awt.event.*;

public class UseKeyListener3 extends Frame implements KeyListener {

    int x,y;

    public UseKeyListener3()
    {
        super("KeyListener");

        x = 50;
        y = 50;

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        addKeyListener(this);

        setSize(400,400);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.setColor(new Color(255,0,0));
        g.fillOval(x,y,25,25);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if( e.getKeyCode() == KeyEvent.VK_UP)
        {
            if(--y < 20)
            {
                y = 20;
            }
        }

        if( e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            if(++y > 350)
            {
                y = 360;
            }
        }

        if( e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            if(--x < 50)
            {
                x = 50;
            }
        }

        if( e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            if(++x > 350)
            {
                x = 360;
            }
        }

        if( e.getKeyCode() == KeyEvent.VK_HOME)
        {
            x = 50;
            y = 50;
        }

        if( e.getKeyCode() == KeyEvent.VK_END)
        {
            x = 360;
            y = 360;
        }

        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        
    }

    public static void main(String[] args){
        UseKeyListener3 a = new UseKeyListener3();
    }
    
}
