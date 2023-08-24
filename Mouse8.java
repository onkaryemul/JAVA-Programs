
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

            case 5:
                g.drawLine(x,y,w,h);
                break;
        }
    }

}


public class Mouse8 extends Frame implements MouseListener, ActionListener {

    int x,y,w,h,flg,shp;
    Color cr;
    MyObject obj;
    LinkedList<MyObject> ls;

    Panel p1,p2;
    Button b1,b2,b3,b4,b5;
    Button br,bg,bb,brnd;

    Mouse8()
    {
        super("Mouse");

        ls = new LinkedList<MyObject>();

        flg = 0;
        //shp = 1;
        shp = 2;

        b1 = new Button("Rect");
        b2 = new Button("FRect");
        b3 = new Button("Oval");
        b4 = new Button("FOval");
        b5 = new Button("Line");

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);

        p1 = new Panel();
        p1.setLayout(new GridLayout(5,1,5,5));

        p1.add(b5);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);

        add(p1,BorderLayout.WEST);
        
        br = new Button("RED");
        br.setBackground(new Color(255,0,0));
        bg = new Button("GREEN");
        bg.setBackground(new Color(0,255,0));
        bb = new Button("BLUE");
        bb.setBackground(new Color(0, 0, 255));
        brnd = new Button("RND");

        br.addActionListener(this);
        bg.addActionListener(this);
        bb.addActionListener(this);
        brnd.addActionListener(this);
        
        p2 = new Panel();
        p2.setLayout(new GridLayout(1,4,5,5));
        p2.add(br);
        p2.add(bg);
        p2.add(bb);
        p2.add(brnd);

        add(p2,BorderLayout.SOUTH);

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
            if(shp == 5)
            {
                w = e.getX();
                h = e.getY();
            }
            else
            {
                w = e.getX() - x;
                h = e.getY() - y;    
            }
           
            obj = new MyObject(x,y,w,h,shp,cr);

            ls.add(obj);

            repaint();
            flg = 0;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b == b1)
        {
            shp = 1;
        }

        if(b == b2)
        {
            shp = 2;
        }

        if(b == b3)
        {
            shp = 3;
        }

        if(b == b4)
        {
            shp = 4;
        }

        if(b == b5)
        {
            shp = 5;
        }

        if(b == br)
        {
            cr = new Color(255,0,0);
        }

        if(b == bg)
        {
            cr = new Color(0,255,0);
        }

        if(b == bb)
        {
            cr = new Color(0,0,255);
        }

        if(b == brnd)
        {
            int a1 = (int)(Math.random()*255);
            int a2 = (int)(Math.random()*255);
            int a3 = (int)(Math.random()*255);

            cr = new Color(a1,a2,a3);
        }
    }

    public static void main(String[] args){

        Mouse8 a = new Mouse8();
    }
    
}


