
import java.util.*;
import javax.swing.*;


public class Result3 implements Comparable<Result3>, Comparator<Result3>{

    public int no;
    public String nm;
    public int[] arr;
    public int total;
    public int avg;

    public Result3()
    {
        no = total = avg = 0;
        arr = new int[5];
        nm = new String();
    }

    public String toString()
    {
        String s = "\nRoll No. : " + no +
                   "\nName : " + nm +
                   "\nMarks : " + Arrays.toString(arr) +
                   "\nTotal : " + total +
                   "\nAverage : " + avg;
        return s;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    public void sum()
    {
        total = 0;
        int i=0;

        while(i<5)
        {
            total += arr[i];
            i++;
        }

        avg = total/5;
    }
 
    @Override
    public int compareTo(Result3 a)  // method from Comparable interface
    {
        return this.no - a.no;
    }

    @Override
    public int compare(Result3 a,Result3 b) // method from Comparator interface
    {
        return (a.nm).compareTo(b.nm);
    }
    
    public void setData(int n)
    {
        no = n;

        nm = JOptionPane.showInputDialog(null,"Name : ");

        int i=0;
        while(i<5)
        {
            try
            {
                arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"Marks : "));
            }
            catch(Exception e)
            {
                arr[i] = 0;
            }

            i++;
        }

        sum();
    }

  // most important
    public static Comparator<Result3> orderTot = new Comparator<Result3>()
    {
        @Override
        public int compare(Result3 a,Result3 b)
        {
            return a.total - b.total;
        }
    };

    public static Comparator<Result3> orderAvg = new Comparator<Result3>()
    {
        @Override
        public int compare(Result3 a,Result3 b)
        {
            return a.avg - b.avg;
        }
    };

    public static Comparator<Result3> orderTotNo = new Comparator<Result3>()
    {
        @Override
        public int compare(Result3 a,Result3 b)
        {
            int res = a.total - b.total;

            if(res == 0)
            {
                return a.no - b.no;
            }
            else
            {
                return res;
            }
        }
    };


    public static void main(String[] args){
        
        LinkedList<Result3> a = new LinkedList<Result3>();

        int n=0;

        while(true)
        {
            try
            {
                n = Integer.parseInt(JOptionPane.showInputDialog(null,"Roll No. : "));
            }
            catch(Exception e)
            {
                continue;
            }

            if(n==0)
            {
                break;
            }

            Result3 b = new Result3();
            b.setData(n);
            
            a.add(b);
        }

        JOptionPane.showMessageDialog(null,"Data : \n" + a);

        n = a.size();

        Result3[] arr = new Result3[n];
        a.toArray(arr); // copy linked list to array

        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

        Arrays.sort(arr);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

        Arrays.sort(arr,new Result3());
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
       
        Arrays.sort(arr,Result3.orderTot);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
       
        Arrays.sort(arr,Result3.orderAvg);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
        
        Arrays.sort(arr,Result3.orderTotNo);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

    }

}



