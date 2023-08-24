
import java.awt.*;
import java.awt.event.*;

class Thrd7 extends Thread 
{
    int x,y;
    Boolean flg;
    Graphics obj;

    Thrd7(Graphics g)
    {
        super();
        
        obj = g;
    }

    public void tStart()
    {
        flg = true;
        start();
    }

    public void tStop()
    {
        flg = false;
    }

    @Override
    public void run()
    {
        while(flg)
        {
            x = (int)(Math.random()*400);
            y = (int)(Math.random()*400);
            int a1 = (int)(Math.random()*255);
            int a2 = (int)(Math.random()*255);
            int a3 = (int)(Math.random()*255);
            obj.setColor(new Color(a1,a2,a3));
            obj.fillRect(x,y,20,20);

            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}
        }
    }
}


public class Thread7 extends Frame implements Runnable {
    
    Thrd7 obj;
    Thread th;
    int flg;

    public Thread7()
    {
        super("Thread");

        flg = 0;

        th = new Thread(this);
        th.start();
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if(flg==0)
                {
                    begin();
                }
                else
                {
                    end();
                }
            }
        });

        setSize(400,400);
        setVisible(true);
    }

    public void begin()
    {
        obj = new Thrd7(getGraphics());
        flg = 1;
        obj.tStart();
    }

    public void end()
    {
        flg = 0;
        obj.tStop();
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                Thread.sleep(10000);
            }
            catch(Exception e){}

            repaint();
        }

    }


    public static void main(String[] args){
        
        Thread7 a = new Thread7();
    
    } 

}




