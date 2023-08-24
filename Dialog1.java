
import java.awt.*;
import java.awt.event.*;

class DResult extends Dialog implements ActionListener
{
    Label l1,l2;
    TextField t1,t2;
    Button b1,b2;

    DResult(Frame prnt, String title, boolean state)
    {
        super(prnt,title,state);

        l1 = new Label("No");
        l2 = new Label("Marks");
        t1 = new TextField(10);
        t2 = new TextField(10);
        b1 = new Button("Ok");
        b2 = new Button("Back");

        b1.addActionListener(this);
        b2.addActionListener(this);

        setLayout(new GridLayout(3,2,5,5));

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(b1);
        add(b2);

        setSize(300,300);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Button b = (Button)e.getSource();

        if(b == b1)
        {
            System.out.println("No : " + t1.getText() + "\nMarks : " + t2.getText());
        }

        setVisible(false);
    }
    
}


public class Dialog1 extends Frame implements ActionListener {

    Button bd;
    DResult obj;

    Dialog1()
    {
        super("Dialog");

        bd = new Button("Result");
        bd.addActionListener(this);

        setLayout(null);

        bd.setBounds(50,100,100,20);

        add(bd);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e)
            {
               System.exit(0);
            } 
        });

        obj = new DResult(this,"Result",true);

        setSize(200,200);
        setVisible(true);       
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        obj.setVisible(true);
    }

    public static void main(String[] args){
     
        Dialog1 a = new Dialog1();
    }
    
}

