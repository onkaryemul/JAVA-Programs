
import java.util.*;
import java.io.*;

public class Array3 {

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
        
    }

}
