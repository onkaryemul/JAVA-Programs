
import java.awt.*;
import java.awt.event.*;

public class Menu1 extends Frame implements ActionListener {

    MenuBar mb;
    Menu mf,me,mx;
    MenuItem mfn,mfo,mfs;
    MenuItem mec,meo,mep;
    MenuItem mxn,mxy;

    Menu1()
    {
        super("Menu");

        mfn = new MenuItem("New");
        mfo = new MenuItem("Open");
        mfs = new MenuItem("Save");

        mfn.addActionListener(this);
        mfo.addActionListener(this);
        mfs.addActionListener(this);

        mf = new Menu("File");
        mf.add(mfn);
        mf.add(mfo);
        mf.add(mfs);

        mec = new MenuItem("Cut");
        meo = new MenuItem("Copy");
        mep = new MenuItem("Paste");

        mec.addActionListener(this);
        meo.addActionListener(this);
        mep.addActionListener(this);

        me = new Menu("Edit");
        me.add(mec);
        me.add(meo);
        me.add(mep);

        mxn = new MenuItem("No");
        mxy = new MenuItem("Yes");

        mxn.addActionListener(this);
        mxy.addActionListener(this);

        mx = new Menu("Exit");
        mx.add(mxn);
        mx.add(mxy);

        mb = new MenuBar();
        mb.add(mf);
        mb.add(me);
        mb.add(mx);

        setMenuBar(mb);
        setSize(400,400);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        MenuItem a = (MenuItem)e.getSource();

        if(a == mxy)
        {
            System.exit(0);
        }
        else
        {
            System.out.println(a.getLabel());
        }
    }


    public static void main(String[] args){
        
        Menu1 a = new Menu1();

    }
    
}


