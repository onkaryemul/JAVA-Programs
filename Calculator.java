
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {

    TextField t1;
    Panel p1;
    Button[] btn;

    int v1,v2,res,flg;
    char opr,ch;
    String p,q;

    public Calculator()
    {
        super("Calculator");

        t1 = new TextField(10);
        t1.setEditable(false);

        btn = new Button[16];
        
        String[] cap = new String[]{"1", "2" , "3" , "+",
                                    "4", "5" , "6" , "-",
                                    "7", "8" , "9" , "*",
                                    "C", "0" , "=" , "/"};

        p1 = new Panel();
        p1.setLayout(new GridLayout(4,4,5,5));

        for(int i=0;i<16;i++)
        {
            btn[i] = new Button(cap[i]);
            btn[i].addActionListener(this);
            p1.add(btn[i]);
        }

        add(t1,BorderLayout.NORTH);
        add(p1,BorderLayout.CENTER);

        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

        flg = 0;
        p = "";
        q = "";

        setSize(200,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        ch = (e.getActionCommand()).charAt(0);

        if(ch == 'C')
        {
            flg = 0;
            p = "";
            q = "";
            t1.setText("");
            return;
        }

        if(ch == '=')
        {
            if(flg==1)
            {
                try
                {
                    v2 = Integer.parseInt(t1.getText());
                    compute();
                    t1.setText("" + res);
                    p = "";
                    q = "";
                    flg = 0;
                }
                catch(Exception e1){}
            }
            return;
        }

        if(ch == '+' || ch == '-'|| ch == '*' || ch == '/')
        {
            if(flg==0)
            {
                try
                {
                    v1 = Integer.parseInt(t1.getText());
                }
                catch(Exception e1){}

                flg=1;
                p="";
                q="";
                opr=ch;
            }
            else
            {
                try
                {
                    v2 = Integer.parseInt(t1.getText());
                }
                catch(Exception e1){}

                compute();
                t1.setText("" + res);
                v1 = res;
                p = "";
                q = "";
                opr = ch;
            } 
            return;
        }

        p = p + ch;
        t1.setText(p);
    }

    public void compute()
    {
        switch(opr)
        {
            case '+':
                 res = v1 + v2;
                 break;

            case '-':
                 res = v1 - v2;
                 break;

            case '*':
                 res = v1 * v2;
                 break;

            case '/':
                 res = v1 / v2;
                 break;
        }
    }

    public static void main(String[] args){
        Calculator c = new Calculator();
    }
    
}



