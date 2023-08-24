
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

class CityPanel extends JPanel 
{
    JButton bs,bm,bp,bk;

    public CityPanel()
    {
        super();

        bs = new JButton("Sangli");
        bm = new JButton("Mumbai");
        bp = new JButton("Pune");
        bk = new JButton("Kolhapur");

        add(bs);
        add(bm);
        add(bp);
        add(bk);
    }
}


class TradePanel extends JPanel 
{
    JCheckBox bs,bm,bp,bk;

    public TradePanel()
    {
        super();

        bs = new JCheckBox("Sangli");
        bm = new JCheckBox("Mumbai");
        bp = new JCheckBox("Pune");
        bk = new JCheckBox("Kolhapur");

        add(bs);
        add(bm);
        add(bp);
        add(bk);
    }
}


class YearPanel extends JPanel 
{
    JRadioButton bs,bm,bp,bk;
    ButtonGroup bg;

    public YearPanel()
    {
        super();

        bs = new JRadioButton("FE");
        bm = new JRadioButton("SE");
        bp = new JRadioButton("TE");
        bk = new JRadioButton("BE");

        bg = new ButtonGroup();

        bg.add(bs);
        bg.add(bm);
        bg.add(bp);
        bg.add(bk);

        add(bs);
        add(bm);
        add(bp);
        add(bk);
    }

}


public class JFrm11 extends JFrame {
    
    JTabbedPane a;

    public JFrm11()
    {
        super("");
        
        a = new JTabbedPane();

        a.add(new CityPanel(), "City");
        a.add(new TradePanel(), "Trade");
        a.add(new YearPanel(), "Year");

        add(a);  // tabbed pane is added at center

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        JFrm11 a = new JFrm11();
    }
}



