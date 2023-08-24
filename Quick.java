
import javax.swing.*;

public class Quick implements Runnable {

    public static int[] arr; // for common memory space static is used (belongs to class)
   
    public int l, r;

    static 
    {
        arr = new int[10];
    }

    public Quick() 
    {
        l = 0;
        r = 9;
    }

    public Quick(int a, int b) 
    {
        l = a;
        r = b;
    }

    public void input() 
    {
        for (int i = 0; i < 10; i++)
        {
            try 
            {
                arr[i] = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter number"));
            } 
            catch (Exception e){}
        }
    }

    public void display() 
    {
        String s = "Data\n";

        for (int i = 0; i < 10; i++) 
        {
            s = s + " " + arr[i];
        }
        
        JOptionPane.showMessageDialog(null, s);
    }

    public void pivot() 
    {
        if (arr[l] > arr[r]) 
        {
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
    }

    synchronized public int partition() 
    {
        pivot();

        int i = l, j = r, k = arr[l];

        do 
        {
            do
            {
                i++;
            } while (arr[i] < k);

            do
            {
                j--;
            } while (arr[j] > k);

            if (i < j) 
            {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }

        } while (i < j);

        int tmp = arr[l];
        arr[l] = arr[j];
        arr[j]= tmp;

        return j;
    }

    synchronized public void quickSort()
    {
        int k = 0;

        if (l<r)
        {
            k = partition();

            Thread t1 = new Thread(new Quick(l , k-1));
            t1.start();
            try{
                t1.join();
            }
            catch(Exception e1){}

            //control will come here only when t1 is complete
            Thread t2 = new Thread(new Quick(k+1 , r));
            t2.start();
            try
            {
                t2.join();
            }
            catch(Exception e2){}
        }
    }

    @Override
    public void run()
    {
        quickSort();
    }

    public static void main(String args[]) {

        Quick a = new Quick();
        a.input();
        a.display();

        Thread b = new Thread(a); // run method of a will be called
        b.start();

        try
        {
            b.join();
        }
        catch(Exception e){}

        a.display();
    }

}




