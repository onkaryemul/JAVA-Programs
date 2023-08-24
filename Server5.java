
import java.net.*;
import java.io.*;
import java.util.*;

public class Server5 implements Runnable {

    LinkedList<DataOutputStream> ls;

    ServerSocket ss;
    Socket s;

    BufferedReader br;
    DataOutputStream dos;

    public Server5() throws Exception
    {
        ls = new LinkedList<DataOutputStream>();
        
        br = new BufferedReader(new InputStreamReader(System.in));

        ss = new ServerSocket(4041);
        System.out.println("Server Started....");

        while(true)
        {
            try
            {
                s = ss.accept(); // connection establishment

                dos = new DataOutputStream(s.getOutputStream());

                ls.add(dos);

                new Thread(this).start();
            }
            catch(Exception e){}

        }
    }

    @Override
    public void run()
    {
        String str = "";
        
        while(true)
        {
            try
            {
                System.out.println("Type Message : ");
                str = br.readLine();

                int i = 0, n = ls.size();

                while(i<n)
                {
                   dos = ls.get(i);

                   dos.writeUTF(str);

                   i++;
                }
            }
            catch(Exception e){}
           
            if(str.equals("bye"))
            {
                break;
            }
        }

        System.out.println("Server stopped...");
    }

    public static void main(String[] args) throws Exception {    
        Server5 a = new Server5();
    }
    
}




