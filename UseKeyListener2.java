
import java.awt.*;
import java.awt.event.*;

public class UseKeyListener2 extends Frame implements KeyListener {

    public String str;
    public int style;
    public int size;
    public Font fnt;

    public Color fc,bc;

    public UseKeyListener2()
    {
        super("Key Listener");
        
        fc = new Color(0,0,0);
        bc = new Color(255,255,255);

        str = "Welcome";
        style = Font.PLAIN;
        size = 10;

     // fnt = new Font(Font.ROMAN_BASELINE,style,size);

        fnt = new Font("Courier",style,size);

        addKeyListener(this);

        addWindowListener(new WindowAdapter(){
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
        g.setFont(fnt);
        g.drawString(str,50,50);
        setForeground(fc);
        setBackground(bc);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if( e.getKeyCode() == KeyEvent.VK_F1)
        {
            str = "";
        }

        if( e.getKeyCode() == KeyEvent.VK_F2)
        {
            if(++size > 72)
            {
                size = 72;
            }
        }

        if( e.getKeyCode() == KeyEvent.VK_F3)
        {
            if(--size < 5)
            {
                size = 5;
            }
        }

        if( e.getKeyCode() == KeyEvent.VK_F4)
        {
            fc = new Color((int)Math.random()*255, (int)Math.random()*255, (int)Math.random()*255);
        }

        if( e.getKeyCode() == KeyEvent.VK_F5)
        {
            bc = new Color((int)Math.random()*255, (int)Math.random()*255, (int)Math.random()*255);
        }

        if( e.getKeyCode() == KeyEvent.VK_F6)
        {
            style = Font.PLAIN;
        }

        if( e.getKeyCode() == KeyEvent.VK_F7)
        {
            style = Font.BOLD;
        }

        if( e.getKeyCode() == KeyEvent.VK_F8)
        {
            style = Font.ITALIC;
        }

        if( e.getKeyCode() == KeyEvent.VK_F9)
        {
            style = Font.BOLD | Font.ITALIC;
        }

        if( e.getKeyCode() == KeyEvent.VK_BACK_SPACE)
        {
            if( str.length() > 1 )
            {
                StringBuilder s = new StringBuilder(str);
                int n = str.length() - 1;
                str = s.substring(0,n);
            }
            else
            {
                str = "";
            }

            repaint();
        }

        fnt = new Font("Courier",style,size);
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        str = str + e.getKeyChar();
        repaint();
    }

    public static void main(String[] args){     
        UseKeyListener2 a = new UseKeyListener2();
    }
    
}



