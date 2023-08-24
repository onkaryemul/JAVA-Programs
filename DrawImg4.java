
import java.awt.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;

class MyNewPanel1 extends Panel {
 
    Image img;
    int x,y,w,h;

    MyNewPanel1()
    {
        super();
        
        x = 20;
        y = 20;

        w = 200;
        h = 200;
    }

    public void paint(Graphics g)
    {
        g.drawImage(img,x,y,w,h,this);
    }

    public void setImage(Image img)
    {
        this.img = img;
        repaint();
    }
}


public class DrawImg4 extends Frame {

    Image[] img;
    MyNewPanel1 pan;
    int index;

    DrawImg4()
    {
        super("Image");

        pan = new MyNewPanel1();

        img = new Image[10];

        for(index=0;index<10;index++)
        {
            try
            {
              img[index] = (Image)(ImageIO.read(new File( "d:\\java23\\Image" + index + ".jpg" )));
            }
            catch(Exception e){}
        }

        index = 0;

        pan.setImage(img[index]);

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(++index>9)
                {
                    index=0;
                }
                pan.setImage(img[index]);
            }
        });

        setLayout(null);
        pan.setBounds(0,0,220,220);
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

        DrawImg4 a = new DrawImg4();
    }

}


