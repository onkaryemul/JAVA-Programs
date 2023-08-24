
import java.util.*;
import java.io.*;

public class Static2 {
    
    static int x[];
    static BufferedReader br;
    
    static
    {
        x = new int[5];
        try
        {
           br = new BufferedReader(new InputStreamReader(System.in));
        }
        catch(Exception e){}
    }

    static void input()
    {
        for(int i=0;i<x.length;i++)
        {
            try
            {
                x[i] = Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
                x[i] = 0;
            }
        }
    }

    static int total()
    {
        int tot = x[0];
        int i=1;

        while(i<x.length)
        {
            tot += x[i];
        }

        return tot;
    }

    static int avg()
    {
        return total() / x.length;
    }

    static void search()
    {
        int sv = 0;

        System.out.println("Search Value : ");
        try
        {
            sv = Integer.parseInt(br.readLine());
        }
        catch(Exception e)
        {
            return;
        }

        Arrays.sort(x);

        if(Arrays.binarySearch(x, sv) < 0)
        {
            System.out.println("Not Found");
        }
        else
        {
            System.out.println("Found");
        }
    }


    public static void main(String[] args)
    {
        input();
        
        String a = "Data\n" + Arrays.toString(x) +"\nTotal : " + total() + "\nAvg : " + avg();

        System.out.println(a);

        search();
    }

}

