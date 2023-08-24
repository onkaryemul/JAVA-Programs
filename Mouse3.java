
import java.awt.*;
import java.awt.event.*;

public class Mouse3 extends Frame implements MouseListener {

    int x,y;
    String str;

    Mouse3()
    {
        super("Mouse");

        str = new String();

        addMouseListener(this);
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        setSize(400,400);
        setResizable(false);
        setVisible(true);
    }

    public void paint(Graphics g)
    {
        g.drawString(str,x,y);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        x = 50;
        y = 50;
        str = "Entered";
        repaint();
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        x = 350;
        y = 350;
        str = "Exited";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        str = "Pressed";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        str = "Released";
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        str = "Clicked";
        repaint();
    }


    public static void main(String[] args){

        Mouse3 a = new Mouse3();
    }
    
}

