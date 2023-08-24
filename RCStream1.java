
import mypkg.Util;
import java.io.*;

public class RCStream1 {
    
    public static void main(String[] args) throws Exception {
        
        FileReader fr = new FileReader("note.txt");

        char[] arr = new char[100];

        while(true)
        {
            int n = fr.read(arr);

            System.out.println(n);

            if(n == -1)
            {
                break;
            }

            Util.display(new String(arr));
        }

        fr.close();
        
    }

}
