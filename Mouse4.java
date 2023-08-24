
import java.awt.*;
import java.awt.event.*;

public class Mouse4 extends Frame implements MouseListener {

    int x,y;

    Mouse4()
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

    public void paint(Graphics g)
    {
        g.drawRect(x,y,50,50);
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    
    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e)
    {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    public static void main(String[] args){

        Mouse4 a = new Mouse4();
    }
    
}

