
import mypkg.Util;
import java.io.*;

public class RBStream {
    
    public static void main(String[] args) throws Exception {
         
        int no=0;

        File f = new File("num.dat");

        if(f.exists() == false)
        {
            Util.display("File Not Found");
            return;
        }

        FileInputStream fis = new FileInputStream(f);

        while(true)
        {
            no = fis.read(); // reads the next byte of the data from this input stream. The value byte is returned as an int in the range of 0 - 255 . If no byte is available because the end of the file is reached because the value -1 is returned. This method blocks until input data is available.

            if(no == -1)
            {
                break;
            }

            Util.display("Data : " + no);
        }

        fis.close();

    }

}
