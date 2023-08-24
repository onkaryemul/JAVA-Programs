
import mypkg.Util;
import java.io.*;

public class ImageCopy {

    public static void main(String[] args) throws Exception {

        File f = new File("fish.jpg");

        if(f.exists() == false)
        {
            Util.display("File Not Found");
            return;
        }

        FileInputStream fis = new FileInputStream("fish.jpg");
        FileOutputStream fos = new FileOutputStream("shark.jpg");

        int no = 0;

        while(true)
        {
            no = fis.read();

            if(no == -1)
            {
                break;
            }

            fos.write(no);
        }

        Util.display("Image Copied Successfully!!");
        
        fis.close();
        fos.close();

    }
    
}
