
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

class MyNewPanel extends Panel {
 
    Image img;
    int x,y,w,h;

    MyNewPanel()
    {
        super();

        w = 100;
        h = 100;

        addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e)
            {
                x = e.getX();
                y = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {
                w = e.getX() - x;
                h = e.getY() - y;
                repaint();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e)
            {
                w = e.getX() - x;
                h = e.getY() - y;
                repaint();
            }
        });
    }

    public void paint(Graphics g)
    {
        g.drawImage(img,x,y,w,h,this);
    }

    public void setImage(Image img)
    {
        this.img = img;
    }
}


public class DrawImg3 extends Frame {

    Image img;
    MyNewPanel pan;

    DrawImg3()
    {
        super("Image");

        pan = new MyNewPanel();

        try
        {
           img = (Image)(ImageIO.read(new File("d:\\java23\\Image0.jpg")));
        }
        catch(Exception e){}

        pan.setImage(img);
        add(pan);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }    
        });

        setSize(400,400);
        setVisible(true);
    }

    public static void main(String[] args){

        DrawImg3 a = new DrawImg3();
    }

}


