
import java.awt.*;
import java.awt.event.*;

public class UseAdapter extends Frame {
    
    UseAdapter()
    {
        super("WindowAdapter");

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

        UseAdapter a = new UseAdapter();
    }

}
