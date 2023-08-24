
// Reading 
import java.io.*;
import mypkg.Util;

public class RPData {
    
    public static void main(String[] args){
        
        int no=0;
        String nm=new String();
        double mrk=0.0;

        FileInputStream fis = null;
        DataInputStream dis = null;

        try
        {
            fis = new FileInputStream("Stu.dat");
            dis = new DataInputStream(fis);
        }
        catch(Exception e){}

        while(true)
        {
            try
            {
                no = dis.readInt();
                nm = dis.readUTF();
                mrk = dis.readDouble();
            }
            catch(Exception e)
            {
                break;
            }
 
            String s = "Roll No. : " + no +"\nName : " + nm + "\nMark : " + mrk;
            
            Util.display(s);
        }

        try
        {
            fis.close();
            dis.close();
        }
        catch(Exception e){}

    }

}
