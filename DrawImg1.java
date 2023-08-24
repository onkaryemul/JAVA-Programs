
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

public class DrawImg1 extends Frame {

    Image img;

    DrawImg1()
    {
        super("Image");

        try
        {
           img = (Image)(ImageIO.read(new File("d:\\java23\\Image0.jpg")));
        }
        catch(Exception e){}

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

    public void paint(Graphics g)
    {
        g.drawImage(img,20,20,360,360,this);
    }

    public static void main(String[] args){

        DrawImg1 a = new DrawImg1();
    }

}


