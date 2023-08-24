
import java.net.*;
import java.io.*;

public class Client1 {
    public static void main(String[] args) throws Exception{

        Socket s = new Socket("localhost",2000);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String str = dis.readUTF(); // reads message send by server

        System.out.println("Message from server : " + str);

        str = "Thank you";

        dos.writeUTF(str); // sends message to server

        dis.close();
        dos.close();

        s.close();

    }
    
}



