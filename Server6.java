
import java.net.*;
import java.io.*;

class Thread6 extends Thread 
{
    String str, cnm;

    Socket s;

    DataOutputStream dos;
    DataInputStream dis;

    BufferedReader br;

    public Thread6(Socket s , String t) throws Exception
    {
        super(t); // naming to the thread

        cnm = t;

        this.s = s;

        br = new BufferedReader(new InputStreamReader(System.in));

        dis = new DataInputStream(s.getInputStream());
        dos = new DataOutputStream(s.getOutputStream());

        start();
    }

    @Override
    public void run()
    {
        while(true)
        {
            try
            {
                talk();
            }
            catch(Exception e1){}
        }
    }

    synchronized void talk() throws Exception
    {
        str = dis.readUTF(); // read message send by client

        System.out.println("From " + cnm + " : " + str);

        System.out.println("Message to " + cnm + " : ");
        str = br.readLine();
        dos.writeUTF(str);
    }

}


public class Server6 {

    public static void main(String[] args) throws Exception {
        
        ServerSocket ss = new ServerSocket(6061);

        while(true)
        {
            Socket s = ss.accept();

            DataInputStream dis = new DataInputStream(s.getInputStream());

            String str = dis.readUTF(); // reads client name

            Thread6 ts = new Thread6(s,str);
        }

    }
    
}




