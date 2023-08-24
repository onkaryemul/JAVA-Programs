
// Writing 
import java.io.*;
import mypkg.Util;

public class WPData {
    
    public static void main(String[] args){
        
        int no=0;
        String nm=new String();
        double mrk=0.0;

        DataOutputStream dos = null;
        FileOutputStream fos = null;

        try
        {
            fos = new FileOutputStream("Stu.dat");
            dos = new DataOutputStream(fos);
        }
        catch(Exception e){}

        while(true)
        {
            no = Util.iInput("Roll NO. : ");
            
            if(no==0)
            {
                break;
            }

            nm = Util.sInput("Name : ");
            mrk = Util.dInput("Marks : ");

            try
            {
                dos.writeInt(no);
                dos.writeUTF(nm);
                dos.writeDouble(mrk);
            }
            catch(Exception e){}

        }

        try 
        {
            dos.close();
            fos.close();
        } catch (Exception e) {}
       

    }

}
