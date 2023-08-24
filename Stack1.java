
import javax.swing.*;

public class Stack1 {

    public static int top;
    public static int[] arr;

    static
    {
        arr = new int[5];
        top = -1;
    }

    public static boolean isFull()
    {
        return top == (arr.length-1);
    }

    public static boolean isEmpty()
    {
        return top == -1;
    }

    public static void push()
    {
        if(isFull())
        {
            JOptionPane.showMessageDialog(null,"Overflow");
            return;
        }

        int d = 0;

        try
        {
            d = Integer.parseInt(JOptionPane.showInputDialog(null,"Input Data :"));
        }
        catch(Exception e){}

        arr[++top] = d;
    }

    public static void pop()
    {
        if(isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Underflow");
            return;
        }
        
        top--;
    }

    public static void display()
    {
        String str = "Stack Data : \n";

        if(isEmpty())
        {
            str = str + " is Empty";
        }
        else
        {
            for(int i=top;i>=0;i--)
            {
               str = str + " " + arr[i];
            }
        }

        JOptionPane.showMessageDialog(null,str);
    }

    public static void menu()
    {
        String[] choice = new String[]{"Push","Pop","Display","Exit"};

        int opt=0;

        while(true)
        {
            opt = JOptionPane.showOptionDialog(null,"Choose Option","Matrix",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,choice,0);

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
