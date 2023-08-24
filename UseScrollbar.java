
import java.awt.*;
import java.awt.event.*;
import mypkg.MyScrollbar;

public class UseScrollbar extends Frame implements ActionListener {
    
    Button bc,bx;
    MyScrollbar sb;

    public UseScrollbar()
    {
        super("Scrollbar");

        sb = new MyScrollbar(this, "Scrollbar", true);
        
        bc = new Button("Color");
        bx = new Button("Exit");

        bc.addActionListener(this);
        bx.addActionListener(this);

        setLayout(null);

        bc.setBounds(50,50,100,20);
        bx.setBounds(170,50,100,20);

        add(bc);
        add(bx);

        setSize(400,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b==bx)
        {
            System.exit(0);
        }
        else
        {
            sb.setVisible(true);
            setBackground(sb.cr);
        }
    }

    public static void main(String[] args){
        UseScrollbar a = new UseScrollbar();
    }
    
}
