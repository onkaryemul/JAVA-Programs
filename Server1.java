
import java.net.*;
import java.io.*;

public class Server1 {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(2000);

        System.out.println("Server Started...");

        Socket s = ss.accept(); // server is waiting for client

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String str = "Welcomes you";

        dos.writeUTF(str); // sends messaage to client

        str = dis.readUTF(); // reads message send by client

        System.out.println("Message from client : " + str);

        dos.close();
        dis.close();

        s.close();
        ss.close();
    }
    
}



