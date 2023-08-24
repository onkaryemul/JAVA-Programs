
import java.util.*;
import javax.swing.*;

class Result2 {
    
    public int no; // roll no
    public int arr[];  // 

    public Result2()
    {
        no = 0;
        arr = new int[5];
    }

    public Result2(int n)
    {
        no = 0;
        arr = new int[n];
    }

    public Result2(int n,int m)
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

    public boolean isMax(Result2 k)
    {
        return this.total() > k.total();
    }

    public boolean isMin(Result2 k)
    {
        return this.total() < k.total();
    }

    public static void bubbleSort(Result2[] arr)
    {
        int flag=0;
        int n=arr.length;

        for(int i=0;i<n-1;i++)
        {
            flag=0;

            for(int j=0;j<n-i-1;j++)
            {
                if(arr[j].isMax(arr[j+1]))
                {
                    Result2 temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    flag=1;
                }
            }
            
            if(flag==0)
            {
                break;
            }
        }

    }

   /*     
        Result2[] arr = new Result2[5];

        JOptionPane.showMessageDialog(null,"Enter details of 5 Students");
        for(int i=0;i<5;i++)
        {
            arr[i] = new Result2();
            arr[i].setData();
        }

        JOptionPane.showMessageDialog(null,"Before Sorting : ");
        for(int i=0;i<5;i++)
        {
            arr[i].display();
        }

        bubbleSort(arr);

        JOptionPane.showMessageDialog(null,"After Sorting : ");
        for(int i=0;i<5;i++)
        {
            arr[i].display();
        }
      
      
  */
    
}


public class Result2List {
    
    public static void main(String[] args){
       
        // Sorting based on roll no
      /* 
        Result2[] a = new Result2[5];

        int i=0,j=0,pos=0;

        while(i<5)
        {
            a[i] = new Result2();
            a[i].setData();

            i++;
        }

        JOptionPane.showMessageDialog(null,Arrays.toString(a));

        for(i=0;i<4;i++)
        {
            pos = i;

            for(j=i+1;j<5;j++)
            {
                if(a[j].no < a[pos].no)
                {
                    pos = j;
                }
            }

            if( i != pos )
            {
                Result2 t = a[i];
                a[i] = a[pos];
                a[pos] = t;
            }

        }

        JOptionPane.showMessageDialog(null,Arrays.toString(a));

      */

        // Sorting based on total marks
        Result2[] a = new Result2[5];

        int i=0,j=0,pos=0;

        while(i<5)
        {
          a[i] = new Result2();
          a[i].setData();

          i++;
        }

        JOptionPane.showMessageDialog(null,Arrays.toString(a));

        for(i=0;i<4;i++)
        {
            pos = i;

            for(j=i+1;j<5;j++)
            {
                if(a[j].isMin(a[pos]))
                {
                    pos = j;
                }
            }

            if( i != pos )
            {
                Result2 t = a[i];
                a[i] = a[pos];
                a[pos] = t;
            }

        }

        JOptionPane.showMessageDialog(null,Arrays.toString(a));


    }

}
