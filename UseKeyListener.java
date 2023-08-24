
import java.awt.*;
import java.awt.event.*;

public class UseKeyListener extends Frame implements KeyListener {

    public String str;
    public int style;
    public int size;
    public Font fnt;

    public UseKeyListener()
    {
        super("Key Listener");
        
        str = "Welcome";
        style = Font.PLAIN;
        size = 10;

     // fnt = new Font(Font.ROMAN_BASELINE,style,size);

        fnt = new Font("Serif",style,size);

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
        g.drawString(str,100,100);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {

    }

    @Override
    public void keyReleased(KeyEvent e)
    {

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    public static void main(String[] args){     
        UseKeyListener a = new UseKeyListener();
    }
    
}


