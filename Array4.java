
import java.util.*;
import java.io.*;

public class Array4 {
       
    public static void main(String[] args){
        
        int[] x = new int[5];

        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        catch(Exception e){}

        int i=0;

        while( i < x.length)
        {
            try
            {
                x[i] = Integer.parseInt(br.readLine());
            }
            catch(Exception e)
            {
                continue;
            }

            i++;
        }

        String str = "Data\n" + Arrays.toString(x);
        System.out.println(str);

        Arrays.sort(x);
        str = "Data\n" + Arrays.toString(x);
        System.out.println(str);

        int res = Arrays.binarySearch(x, 23);

        if(res < 0)
        {
            System.out.println("Not Found");
        }
        else
        {
            System.out.println("Found at position " + res);
        }
        
    }

}
