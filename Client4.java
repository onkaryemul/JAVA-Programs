
import java.net.*;
import java.io.*;

import mypkg.Util;

public class Client4 {
    
    public static void main(String[] args) throws Exception {
        
        Socket s = null;

        FileOutputStream fos = null;

        DataInputStream dis = null;
        DataOutputStream dos = null;

        String snm = "";
        String dnm = "";

        int val = 0;

        boolean result = true;

        s = new Socket("localhost",5050);

        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());

        snm = Util.sInput("Enter Source File Name");
        dos.writeUTF(snm); // sends the source file name to the server

        result = dis.readBoolean(); // reads results send by server regarding file existance
        
        if(result == false)
        {
            Util.display("Source file is missing");
            return;
        }

        dnm = Util.sInput("Enter Destination File Name");
        
        fos = new FileOutputStream(dnm);
        
        while(true)
        {
            val = dis.read();

            if(val == -1)
            {
                break;
            }

            fos.write(val);
        }

        fos.close();

        dos.close();
        dis.close();

        s.close();

    }
    
}
