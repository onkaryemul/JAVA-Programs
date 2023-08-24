
import java.awt.*;
import java.awt.event.*;

public class Mouse6 extends Frame implements MouseListener {

    int x,y,w,h,flg;

    Mouse6()
    {
        super("Mouse");

        flg = 0;

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
        int a = (int)(Math.random()*255);
        int b = (int)(Math.random()*255);
        int c = (int)(Math.random()*255);

        Color cr = new Color(a,b,c);

        Graphics g = getGraphics();
        g.setColor(cr);
      //  g.fillRect(x,y,20,20);
        g.fillOval(x,y,20,20);
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
        if(flg==0) // first time clicked
        {
            x = e.getX();
            y = e.getY();
            flg = 1;
        }
        else
        {
            w = e.getX() - x;
            h = e.getY() - y;
            draw();
            flg = 0;
        }

    }

    public static void main(String[] args){

        Mouse6 a = new Mouse6();
    }
    
}


