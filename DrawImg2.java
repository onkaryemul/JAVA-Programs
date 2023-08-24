
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

class MyPanel extends Panel {
 
    Image img;
    int x,y,w,h;

    MyPanel()
    {
        super();

        w = 100;
        h = 100;

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                x = e.getX();
                y = e.getY();
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


public class DrawImg2 extends Frame {

    Image img;
    MyPanel pan;

    DrawImg2()
    {
        super("Image");

        pan = new MyPanel();

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

        DrawImg2 a = new DrawImg2();
    }

}


