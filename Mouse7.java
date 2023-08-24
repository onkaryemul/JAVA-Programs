
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class MyObject 
{
    int x,y,w,h,shp;
    Color cr;

    MyObject(int x,int y,int w,int h,int shp,Color cr)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.shp = shp;
        this.cr = cr;
    }

    public void draw(Graphics g)
    {
        g.setColor(cr);

        switch(shp)
        {
            case 1: 
                g.drawRect(x,y,w,h);
                break;

            case 2:
                g.fillRect(x,y,w,h);
                break;

            case 3:
                g.drawOval(x,y,w,h);
                break;

            case 4:
                g.fillOval(x,y,w,h);
                break;
        }
    }

}


public class Mouse7 extends Frame implements MouseListener {

    int x,y,w,h,flg,shp;
    MyObject obj;
    LinkedList<MyObject> ls;

    Mouse7()
    {
        super("Mouse");

        ls = new LinkedList<MyObject>();

        flg = 0;
        //shp = 1;
        shp = 2;

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
        int i=0,n=ls.size();

        while(i<n)
        {
            obj = (MyObject)ls.get(i);
            obj.draw(g);
            i++;
        }
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
            
            int a = (int)(Math.random()*255);
            int b = (int)(Math.random()*255);
            int c = (int)(Math.random()*255);

            Color cr = new Color(a,b,c);

            obj = new MyObject(x,y,w,h,shp,cr);

            ls.add(obj);

            repaint();
            flg = 0;
        }
    }

    public static void main(String[] args){

        Mouse7 a = new Mouse7();
    }
    
}


