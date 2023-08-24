
import java.net.*;
import java.io.*;

public class Server2 {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(4041);

        System.out.println("Server Started...");

        Socket s = ss.accept(); // Server is waiting for client
        
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cnm = dis.readUTF(); // cnm - client ; reads client name

        String str = cnm + " Welcomes You!";

        while(true)
        {
            dos.writeUTF(str); // sends message to client

            if(str.equals("bye"))
            {
                break;
            }

            str = dis.readUTF(); // reads message send by client

            System.out.println("Message from " + cnm + " : " + str);

            if(str.equals("bye"))
            {
                break;
            }

            System.out.print("Message to client : ");

            str=br.readLine();

            System.out.println(str);
        }

        br.close();
        dos.close();
        dis.close();

        ss.close();
        s.close();

    }
    
}



