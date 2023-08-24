
import mypkg.Util;
import mypkg.Student;
import java.io.*;

public class WObject {
    
    public static void main(String[] args) throws Exception {
        
        FileOutputStream fos = new FileOutputStream("Stu.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        while(true)
        {
            int no = Util.iInput("Roll No. : ");

            if(no==0)
            {
                break;
            }

            Student s = new Student();
            s.setData(no);

            oos.writeObject(s);
        }

        fos.close();
        oos.close();

    }

}
