
import mypkg.Util;
import java.io.*;

public class WCStream {
    
    public static void main(String[] args) throws Exception {
        
        FileWriter fw = new FileWriter("abc.txt");

        int no=0;

        while(true)
        {
            no = Util.iInput("No : ");

            if(no==0)
            {
                break;
            }

            fw.write(no); // Write a single character. The argument int specifying a character to be written.
        }
        
        fw.close();
    }
    
}
