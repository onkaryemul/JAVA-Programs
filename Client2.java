
import java.net.*;
import java.io.*;

public class Client2 {

    public static void main(String[] args) throws Exception {

        if(args.length != 1)
        {
            return;
        }

        Socket s = new Socket("localhost", 4041);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        dos.writeUTF(args[0]); // sends client name to the server

        while(true)
        {
            str = dis.readUTF(); // reads message send by server

            System.out.println("Message from server : " + str );

            if(str.equals("bye"))
            {
                break;
            }

            System.out.print("Message to server : ");
            str=br.readLine();
            System.out.println(str);

            dos.writeUTF(str);

            if(str.equals("bye"))
            {
                break;
            }
        }

        br.close();
        dis.close();
        dos.close();

        s.close();

    }
    
}




