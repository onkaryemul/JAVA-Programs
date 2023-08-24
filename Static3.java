
import java.util.*;
import java.io.*;

public class Static3 {
    
    static int x[][];
    static BufferedReader br;
    
    // static blocks are used to initialize static fields
    static
    {
        x = new int[3][3];
        try
        {
           br = new BufferedReader(new InputStreamReader(System.in));
        }
        catch(Exception e){}
    }

    static void input()
    {
        int i=0,j=0;

        while(i<3)
        { 
            j=0;

            while(j<3)
            {
                System.out.println("Data : ");
                try
                {
                    x[i][j] = Integer.parseInt(br.readLine());
                }
                catch(Exception e)
                {
                    continue;
                }

                j++;
            }

            i++;
        }
    }

    public static String toStringObject(){
        String a = "Matrix\n" + Arrays.toString(x[0]) + "\n" + Arrays.toString(x[1]) + "\n" + Arrays.toString(x[2]) + "\n";
        return a;
    }
    
    public static void display()
    {
        System.out.println(toStringObject());
    }


    public static void main(String[] args)
    {
        input();
        
        display();
    }

}

