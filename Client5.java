
import java.net.*;
import java.io.*;

public class Client5 {
    
    public static void main(String[] args) throws Exception {

        Socket s = new Socket("localhost",4041);

        DataInputStream dis = new DataInputStream(s.getInputStream());

        String str = "";

        while(true)
        {
            str = dis.readUTF(); // reads message from 

            System.out.println("Message from server : " + str);

            if(str.equals("bye"))
            {
                break;
            }

            Thread.sleep(1000);
        }

        dis.close();
        s.close();

    }

}




