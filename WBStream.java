
import mypkg.Util;
import java.io.*;

public class WBStream {
    
    public static void main(String[] args) throws Exception {
        
        int no=0;

        FileOutputStream fos = new FileOutputStream("num.dat");
        
        while(true)
        {
           no = Util.iInput("No : ");

           if(no==0)
           {
              break;
           }

           fos.write(no);
        }

        fos.close();
    }

}
