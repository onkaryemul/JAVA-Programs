
import java.awt.*;
import java.awt.event.*;

public class Frm5 extends Frame implements WindowListener {

    Frm5()
    {
        super("WindowListner");
        addWindowListener(this);
        setSize(400,400);
        setVisible(true);
    }

    @Override
    public void windowOpened(WindowEvent e)
    {
        System.out.println("Opened");
    }

    @Override
    public void windowClosed(WindowEvent e){}

    @Override
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }

    @Override
    public void windowActivated(WindowEvent e)
    {
        System.out.println("Activated");
    }

    @Override
    public void windowDeactivated(WindowEvent e)
    {
        System.out.println("Deactivated");
    }

    @Override
    public void windowIconified(WindowEvent e)
    {
        System.out.println("Iconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e)
    {
        System.out.println("Deiconified");
    }

    public static void main(String[] args){
        
        Frm5 a = new Frm5();
    }

}

/*
   Window is created :
   1) Window Activated
   2) Opened
   
   When minimized:
   1) Iconified &
   2) Deactivated

   When maximized:
   1) DeIconified
   2) Activated
 */
