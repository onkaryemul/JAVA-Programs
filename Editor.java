
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;

public class Editor extends Frame implements ActionListener, TextListener {

    public TextArea ta;
    public Button bn,bo,bs,bx;
    public Panel ps;
    public FileDialog fd;
    public Boolean state;

    public Editor()
    {
        super("Editor");

        state = true;

        ta = new TextArea("",50,100,TextArea.SCROLLBARS_BOTH);
        ta.addTextListener(this);

        add(ta,BorderLayout.CENTER);
        
        bn = new Button("New");
        bo = new Button("Open");
        bs = new Button("Save");
        bx = new Button("Exit");

        bn.addActionListener(this);
        bo.addActionListener(this);
        bs.addActionListener(this);
        bx.addActionListener(this);

        ps = new Panel(); // Default --> FlowLayout

        ps.add(bn);
        ps.add(bo);
        ps.add(bs);
        ps.add(bx);

        add(ps,BorderLayout.SOUTH);

        setSize(300,300);

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                if(state == false)
                {
                    if(JOptionPane.showConfirmDialog(null, "Want to Save?") == JOptionPane.YES_OPTION)
                    {
                        save();
                    }
                }
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void open()
    {
        state = true;
        
        FileReader fr = null;
        File f = null;
        String str = "";
        
        fd = new FileDialog(this,"Open",FileDialog.LOAD);
        
        fd.setVisible(true);

        String fnm = fd.getDirectory() + fd.getFile();
        System.out.println(fnm);

        try
        {
            f = new File(fnm);
            fr = new FileReader(f);
        }
        catch(Exception e){}

        int val=0;

        while(true)
        {
            try
            {
                val = fr.read();
            }
            catch(Exception e){}

            if(val == -1)
            {
                break;
            }

            str = str + (char)val;
        }

        ta.setText(str);
    }

    public void save()
    {
        state = true;

        FileWriter fw = null;
        File f = null;
        String str = "";
        int i = 0;
        char[] ch = null;

        fd = new FileDialog(this,"Save",FileDialog.SAVE);
        
        fd.setVisible(true);

        String fnm = fd.getDirectory() + fd.getFile();

        try
        {
            f = new File(fnm);
            fw = new FileWriter(f);
        }
        catch(Exception e){}

        str = ta.getText();

        ch = str.toCharArray(); // converts string to character array

        while(i<ch.length)
        {
            try
            {
                fw.write(ch[i]);
            }
            catch(Exception e){}
           
            i++;
        }

        try
        {
            fw.close();
        }
        catch(Exception e){}
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b == bn)
        {
            ta.setText("");
            state = true;
        }

        if(b == bx)
        {
            if(state == false)
            {
                if(JOptionPane.showConfirmDialog(null, "Want to Save?") == JOptionPane.YES_OPTION)
                {
                    save();
                }
            }
            System.exit(0);
        }

        if(b == bo)
        {
            open();
        }

        if(b == bs)
        {
            save();
        }
    }

    @Override
    public void textValueChanged(TextEvent e)
    {
        state = false;
    }

    public static void main(String[] args){
        Editor a = new Editor();
    }
    
}



