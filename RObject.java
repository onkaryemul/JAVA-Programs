
import mypkg.Student;
import java.io.*;

public class RObject {
 
    public static void main(String[] args) {
        
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try
        {
            fis = new FileInputStream("Stu.dat");
            ois = new ObjectInputStream(fis);
        }
        catch(Exception e){}

        Student s = null;

        while(true)
        {
            try
            {
                s = (Student)ois.readObject();
            }
            catch(Exception e)
            {
                break;
            }

            s.display();
        }

        try
        {
            fis.close();
            ois.close();
        }
        catch(Exception e){}

    }

}
