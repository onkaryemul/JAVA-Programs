
import mypkg.Util;
import java.io.*;

public class WCStream1 {
    
    public static void main(String[] args) throws Exception {
        
        FileWriter fw = new FileWriter("note.txt");

        String str = "";

        while(true)
        {
            str = Util.sInput("Message : ");

            if(str.equals("bye"))
            {
                break;
            }

            fw.write(str); // Write a single character. The argument int specifying a character to be written.
            fw.write("\n");
        }
        
        fw.close();
    }
    
}
