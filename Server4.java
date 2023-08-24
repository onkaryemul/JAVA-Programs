
import java.net.*;
import java.io.*;

public class Server4 {
    
    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(5050);

        Socket s = ss.accept();

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        DataInputStream dis = new DataInputStream(s.getInputStream());

        String fnm = dis.readUTF(); // reads the source file name send by client

        File f = new File(fnm);

        boolean result = f.exists();

        dos.writeBoolean(result);

        if(result ==  false)
        {
            return;
        }

        FileInputStream fis = new FileInputStream(fnm);

        int val = 0;

        while(true)
        {
            val = fis.read();

            dos.write(val); // sends the data to the client

            if(val == -1)
            {
                break;
            }
        }

        ss.close();

        dis.close();
        dos.close();
        fis.close();

        s.close();

    }
    
}
