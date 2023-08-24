
import java.rmi.*;
import java.rmi.server.*;

public class RMIClient1 {
    public static void main(String [] args) throws Exception {
        
        String url="rmi://localhost/abc";   //refernce of the server object

        //methods of interface only should be called by the client
        //instance of interface can be created

        //reference assigned to ref
        Inter1 ref=(Inter1)Naming.lookup(url);
        
        System.out.println("No : "+ref.getNo(100));
    } 
}

//create 3 command prompt windows

//in the first window
//first compile both the Server and Client file
//then type the command "rmiregistry"


//in the 2nd window
//run RMIServer1

//in the 3rd window
//run RMIClient1
