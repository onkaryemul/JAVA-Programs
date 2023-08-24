
import java.util.*;
import javax.swing.*;

public class Result1 {
    
    public int no; // roll no
    public int arr[];  // 

    public Result1()
    {
        no = 0;
        arr = new int[5];
    }

    public Result1(int n)
    {
        no = 0;
        arr = new int[n];
    }

    public Result1(int n,int m)
    {
        no = n;
        arr = new int[m];
    }

    public void inputMarks()
    {
        int i=0;

        while(i<arr.length)
        {
            try
            {
               arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Marks : "));
            }
            catch(Exception e)
            {
               continue;
            }

            i++;
        }

    }

    public void setData()
    {
        try
        {
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"Roll No.: "));
        }
        catch(Exception e){}
        
        int nos = 0;

        try
        {
            nos = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Subject Count : "));
        }
        catch(Exception e)
        {
            nos = 5;
        }

        if( nos != arr.length )
        {
            arr = new int[nos];
        }
      
        inputMarks();
    }

    public void setData(int n) // roll no
    {
        no = n;

        int nos = 0;

        try
        {
            nos = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Subject Count : "));
        }
        catch(Exception e)
        {
            nos = 5;
        }

        if( nos != arr.length)
        {
            arr = new int[nos];
        }

        inputMarks();
    }
    
    public int total()
    {
        int i=1,tot=arr[0];
        
        while(i<arr.length)
        {
            tot += arr[i];
            i++;
        }

        return tot;
    }

    public int avg()
    {
        return total()/arr.length;
    }

    public String toString()
    {
        String s = "\nRoll No. : " + no + 
                   "\nMarks : " + Arrays.toString(arr) + 
                   "\nTotal : " + total() +
                   "\nAverage : " + avg();
        return s;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    public boolean isMax(Result1 k)
    {
        return this.total() > k.total();
    }

    public boolean isMin(Result1 k)
    {
        return this.total() < k.total();
    }


    public static void main(String[] args){

        Result1 a = new Result1();
        a.setData();

        Result1 b = new Result1();
        b.setData();

        a.display();
        b.display();

        if(a.isMax(b))
        {
            a.display();
        }
        else
        {
            b.display();
        }

    }

}

