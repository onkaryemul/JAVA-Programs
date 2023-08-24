
import java.io.*;

public class KBD4 {

    public static void main(String[] args){

        InputStreamReader isr = null;
        BufferedReader br = null;

        try
        {
            isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);
        }
        catch(Exception e){}

        int no=0;

        System.out.println("Enter a number : ");
        try
        { 
            no = Integer.parseInt(br.readLine());
        }
        catch(Exception e)
        {
            System.out.println("Invalid!!");
            return;
        }

        System.out.println("Result : " + Integer.toBinaryString(no));
        
       /* 
        String str = "";

        while(no>0)
        {
            str = "" + (no%2) + str;
            no /= 2;
        }

        System.out.println("Result : " + str);
       */
    }
    
}
