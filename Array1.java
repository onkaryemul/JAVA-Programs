
import java.io.*;


public class Array1 {
    
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

        String str = "Data\n";

        for(i=0;i<x.length;i++)
        {
            str = str + " " + x[i];
        }

        System.out.println(str);
        
    }

}
