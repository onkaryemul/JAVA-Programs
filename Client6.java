
import java.io.*;
import java.net.*;

public class Client6 {
    
    public static void main(String[] args) throws Exception {

        if(args.length != 1)
        {
            return;
        }

        Socket s = new Socket("localhost", 6061);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dos.writeUTF(args[0]); // sends client name to the server

        String str = "";

        while(true)
        {
            System.out.println("Message to Server : ");
            str = br.readLine();
            dos.writeUTF(str);

            if(str.equals("bye"))
            {
                break;
            }

            str = dis.readUTF(); // reads message send by server

            System.out.println("From Server : " + str);

            if(str.equals("bye"))
            {
                break;
            }

            Thread.sleep(1000);
        }

        dos.close();
        dis.close();
        
        s.close();

        br.close();
    }

}


