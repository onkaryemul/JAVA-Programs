
import java.util.*;
import javax.swing.*;

abstract class Array7
{
    public int[] arr;

    public Array7()
    {
        arr = new int[5];
    }

    public void set(int pos,int d)
    {
        arr[pos] = d;
    }

    public int get(int pos)
    {
        return arr[pos];
    }

    public String toString()
    {
        String s = "Data : \n";
        return s;
    }

    abstract public void menu();
    abstract public void display();
}

interface IStack
{
    void push(int d);
    void pop();
    boolean isFull();
    boolean isEmpty();
}

interface IQueue
{
    void insert(int d);
    void remove();
    boolean isQFull();
    boolean isQEmpty();
}

class Stack3 extends Array7 implements IStack
{
    public int top;

    public Stack3()
    {
        super();
        top = -1;
    }

    @Override
    public boolean isFull()
    {
        return top==4;
    }

    @Override
    public boolean isEmpty()
    {
        return top==-1;
    }

    @Override
    public void push(int d)
    {
        if(isFull())
        {
            JOptionPane.showMessageDialog(null,"Overflow!!!");
        }
        else
        {
            set(++top,d);
        }
    }

    @Override
    public void pop()
    {
        if(isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Underflow!!!");
        }
        else
        {
            top--;
        }
    }

    public String toString()
    {
        String s = "Stack : \n";

        if(isEmpty())
        {
            s = s + "Empty!!";
        }
        else
        {
            for(int i=top;i>=0;i--)
            {
                s = s + " " + get(i);
            }
        }

        return s;
    }

    @Override
    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    @Override
    public void menu()
    {
        String[] option = new String[]{"Push","Pop","Display","Back"};

        int opt=0,d=0;

        while(true)
        {
            opt = JOptionPane.showOptionDialog(null,"Choose Option","Stack",
                    JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, option, 0);

            if( opt == 3 )
            {
                break;
            }

            switch(opt)
            {
                case 0:
                    try
                    {
                        d = Integer.parseInt(JOptionPane.showInputDialog(null,"Data : "));
                    }
                    catch(Exception e){}
                    push(d);
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

}

class Queue3 extends Array7 implements IQueue
{
    public int fr;
    public int rr;

    public Queue3()
    {
        super();
        fr = 0;
        rr = -1;
    }

    @Override
    public boolean isQFull()
    {
        return rr==4;
    }

    @Override
    public boolean isQEmpty()
    {
        return rr < fr;
    }

    @Override
    public void insert(int d)
    {
        if(isQFull())
        {
            JOptionPane.showMessageDialog(null,"Overflow!!");
        }
        else
        {            
            set(++rr,d);   
        }

    }

    @Override
    public void remove()
    {
        if(isQEmpty())
        {
            JOptionPane.showMessageDialog(null,"Underflow!!");
        }
        else
        {
            fr++;
        }
    }

    public String toString()
    {
        String s = "Queue : \n";

        if(isQEmpty())
        {
            s = s + "Empty!!";
        }
        else
        {
            for(int i=fr;i<=rr;i++)
            {
                s = s + " " + get(i);
            }
        }

        return s;
    }

    @Override
    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    @Override
    public void menu()
    {
        String[] option = new String[]{"Insert","Remove","Display","Back"};

        int opt=0,d=0;

        while(true)
        {
            opt = JOptionPane.showOptionDialog(null,"Choose Option", "Queue",
                  JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE, null, option,0);

            if(opt==3)
            {
                break;
            }

            switch(opt)
            {
                case 0:
                    try
                    {
                        d = Integer.parseInt(JOptionPane.showInputDialog(null,"Data : "));
                    }
                    catch(Exception e){}
                    insert(d);
                    break;

                case 1:
                    remove();
                    break;

                case 2:
                    display();
                    break;
            }

        }

    }
    
}


public class HInheritance {
    
    public static void main(String[] args){
        
        Array7 ref = null;

        int opt = JOptionPane.showOptionDialog(null,"Choose Option","Data Structures",
                  JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE,
                  null, new String[]{"Stack","Queue","Exit"}, 0);

        if(opt == 2)
        {
            return;
        }

        if(opt == 0)
        {
            ref = new Stack3();
        }
        else
        {
            ref = new Queue3();
        }

        ref.menu();
        
    }

}



