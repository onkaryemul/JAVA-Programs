
import java.awt.*;
import java.awt.event.*;

class Ball extends Thread 
{
    Panel pobj;

    static int w=20;    //width
    static int h=20;

    int x,y,dx,dy;
    
    int count;

    Color cr;

    public Ball(Panel p) 
    {
        super();

        pobj = p;

        x = 0;
        y = (int)(Math.random()*500);

        dx = dy = 2;    //dx=>column increment ,dy=>row increment

        cr = new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));

        count=0;

        start();
    }

    @Override
    public void run() 
    {
        while(count<5) 
        {
            move();

            try 
            {
               Thread.sleep(10);
            }
            catch(Exception e){}
        }   

        bpaint(0);  
    }

    public void bpaint(int flg) 
    {
        Graphics g=pobj.getGraphics();

        if(flg==0)
            g.setColor(Color.WHITE);
        else
            g.setColor(cr);

        g.fillOval(x,y,w,h);       
    }

    public void move() 
    {
        Graphics g=pobj.getGraphics();
        
        bpaint(0);
        
        x += dx;
        y += dy;
        
        bpaint(1);

        Dimension d = pobj.getSize();

        if(x<0)
        {   
            x=0;
            dx= -dx;
            count++;
        }

        if(x>d.width)
        {   
            x = d.width-w;
            dx = -dx;
            count++;
        }

        if(y<0)
        {   
            y = 0;
            dy = -dy;
            count++;
        }

        if(y>d.height)
        {   
            y = d.height-h;
            dy = -dy;
            count++;
        }
    }

}


public class BouncingBall extends Frame implements ActionListener {
    
    Panel p,q;
    Button bs,bx;
    Ball obj;

    public BouncingBall() 
    {
        super("Bouncing ball");

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        p=new Panel();
        q=new Panel();

        bs=new Button("start");
        bx=new Button("exit");

        bs.addActionListener(this);
        bx.addActionListener(this);

        q.add(bs);
        q.add(bx);

        setLayout(new BorderLayout());

        add(p,BorderLayout.CENTER);
        add(q,BorderLayout.SOUTH);

        setSize(500,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        Button b=(Button)e.getSource();

        if(b==bx)
            System.exit(0);
        else {
            obj=new Ball(p);            
        }
    }

    public static void main(String [] args) {
        BouncingBall bb=new BouncingBall();
    }

}



