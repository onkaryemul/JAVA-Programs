
import javax.swing.*;
import java.util.*;

public class Stack2 {

    public static Stack<Integer> obj;

    static
    {
        obj = new Stack<Integer>();
    }

    public static void push()
    {
    
        int d = 0;

        try
        {
            d = Integer.parseInt(JOptionPane.showInputDialog(null,"Input Data :"));
        }
        catch(Exception e){}

        obj.push(d);
    }

    public static void pop()
    {
        if(obj.empty())
        {
            JOptionPane.showMessageDialog(null,"Underflow");
            return;
        }
        
        JOptionPane.showMessageDialog(null,"Popped Element : " + obj.pop());
    }

    public static void display()
    {
        if(obj.empty())
        {
            JOptionPane.showMessageDialog(null,"Stack Empty");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Stack : \n" + obj);
        }

    }

    public static void menu()
    {
        String[] choice = new String[]{"Push","Pop","Display","Exit"};

        int opt=0;

        while(true)
        {
            opt = JOptionPane.showOptionDialog(null,"Choose Option","Stack",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,choice,0);

            if(opt==3)
            {
                break;
            }

            switch(opt)
            {
                case 0:
                    push();
                    break;

                case 1:
                    pop();
                    break;

                case 2:
                    display();
                    break;
            }

        }

    }

    public static void main(String[] args){
        
        menu();
    }
}
