
import javax.swing.*;

class Number1
{
    public int no;

    public Number1()
    {
        no = 0;
    }

    public Number1(int a)
    {
        no = a;
    }

    public void setData(int a)
    {
        no = a;
    }

    public void setData()
    {
        try
        { 
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"No. : "));
        }
        catch(Exception e){}
    }

    public String toString()
    {
        String s = "\nNo : " + no;
        return s;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

}


class Number2 extends Number1
{
    public String nm;

    public Number2()
    {
        super();
        nm = "";
    }

    public Number2(int a,String b)
    {
        super(a);
        nm = b;
    }

    public String toString()
    {
        String s = super.toString() + "\nName : " + nm;
        return s;
    }

    @Override
    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    public void setData()
    {
        super.setData();

        nm = JOptionPane.showInputDialog(null,"Name : ");
    }

    public void setData(int a,String b)
    {
        super.setData(a);

        nm = b;
    }

    public void setData(int a)
    {
        super.setData(a);

        nm = JOptionPane.showInputDialog(null,"Name : ");
    }

}


public class SInheritance {
    
    public static void main(String[] args){
        
        Number1 a = new Number1(101);
        a.display();

        Number2 b = new Number2();
        b.setData();
        b.display();

        a=b;
        a.display(); // calls Number2 class display()

        /* 
           After changing display() of Number2 to display1() and then
           calling the display() through referenece variable a. 
           Which function will be called?

           Subclass function will be called.
           Internally it will call toString() of subclass even though 
           super-class display() run which will call internally the
           sub-class toString().
        
        */
    }

}
