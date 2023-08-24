/* 
   interface ISize
       int size = 10

   interface IComp
       int total(), avg(), findMax(), findMin()

   interface IArray extends ISize, IComp
   {
       void sort();
       boolean search(int sv);
   }

   class Array8 implements IArray 
       int[] arr

*/

import java.util.*;
import javax.swing.*;

interface ISize
{
    int size = 10;
}

interface IComp 
{
    int total();
    int avg();
    int findMax();
    int findMin();
}

interface IArray extends ISize, IComp
{
    void sort();
    boolean search(int sv);
}

class Array8 implements IArray
{
    public int[] arr;

    public Array8()
    {
        arr = new int[size];
    }

    public void setData()
    {
        JOptionPane.showMessageDialog(null,"Enter 10 numbers");
        
        int i=0;

        while(i<size)
        {
            try
            {
               arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"arr[" + i + "] : "));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Invalid Input!!");
                continue;
            }

            i++;
        }

    }

    public int get(int pos)
    {
        return arr[pos];
    }

    public String toString()
    {
        String s = "Array : \n";

        for(int i=0;i<size;i++)
        {
            s = s + " " + get(i);
        }

        return s;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    @Override
    public int total()
    {
        int tot = get(0);
        int i = 1;

        while(i<size)
        {
           tot += get(i);
           i++;
        }

        return tot;
    }

    @Override
    public int avg()
    {
        return total()/size;
    }

    @Override
    public int findMax()
    {
        int max = get(0);
        int i = 1;

        while(i<size)
        {
            if(get(i)>max)
            {
                max = get(i);
            }

            i++;
        }

        return max;
    }

    @Override
    public int findMin()
    {
        int min = get(0);
        int i = 1;

        while(i<size)
        {
            if(get(i)<min)
            {
                min = get(i);
            }

            i++;
        }

        return min;
    }

    @Override
    public void sort()
    {
        Arrays.sort(arr);
    }

    @Override
    public boolean search(int sv)
    {
        sort();
        return Arrays.binarySearch(arr,sv)>=0;
    }

}

public class MultilevelInheritance {
    
    public static void main(String[] args){
        
        int opt=0,sv=0;

        Array8 ref = new Array8();
        ref.setData();

        while(true)
        {
            opt = JOptionPane.showOptionDialog(null,"Choose Option","Array Operations",
                   JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE,
                   null, new String[]{"Total","Average","Minimum","Maximum","Sort","Search","Display","Exit"}, 0);
            
            if(opt==7)
            {
                break;
            }

            switch(opt)
            {
                case 0:
                    JOptionPane.showMessageDialog(null,"Total : " + ref.total());
                    break;

                case 1:
                    JOptionPane.showMessageDialog(null,"Average : " + ref.avg());
                    break;

                case 2:
                    JOptionPane.showMessageDialog(null,"Minimum : " + ref.findMin());
                    break;

                case 3:
                    JOptionPane.showMessageDialog(null,"Maximum : " + ref.findMax());
                    break;

                case 4:
                    ref.sort();
                    break;

                case 5:
                    try
                    {
                        sv = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter search value : "));
                    }
                    catch(Exception e){}
                    if(ref.search(sv))
                    {
                        JOptionPane.showMessageDialog(null,"Found");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Not Found");
                    }
                    break;

                case 6:
                    ref.display();
                    break;
                    
            }
        }
        
    }

}


