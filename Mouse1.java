
import java.awt.*;
import java.awt.event.*;

public class Mouse1 extends Frame implements MouseListener {

    int x,y;

    Mouse1()
    {
        super("Mouse");

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

    public void draw()
    {
        Graphics g = getGraphics();

        g.drawString("Welcome",x,y);
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        x = 50;
        y = 50;
        draw();
    }
    
    @Override
    public void mouseExited(MouseEvent e)
    {
        x = 350;
        y = 350;
        draw();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        draw();
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        draw();
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        draw();
    }


    public static void main(String[] args){

        Mouse1 a = new Mouse1();
    }
    
}
