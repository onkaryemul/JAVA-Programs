import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

public class RMIClient2 {
    public static void main(String [] args) throws Exception {
        String url="rmi://localhost/abc";   //refernce of the server object

        //methods of interface only should be called by the client
        //instance of interface can be created

        /*
         * Example: we have interface A and class B implements A
         * 
         * then we can create instance of A by:
         *  
         *  A obj=(A) new B();
         * 
         * ps:check B.java
         * 
         */

        //reference assigned to ref
        Inter2 ref=(Inter2)Naming.lookup(url);

        Scanner s=new Scanner(System.in);
        int no=0;
        try {
            no=s.nextInt();
        }catch(Exception e){}

        ref.setNo(no);

        System.out.println("No : "+ref.getNo(no));

        if(!ref.isPrime())
            System.out.println("Not a prime");
        else    
            System.out.println("Is a prime");

        System.out.println("Length of number: " + ref.count());
    } 
}


//create 3 command prompt windows

//in the first window
//first compile both the Server and Client file
//then type the command "rmiregistry"


//in the 2nd window
//run RMIServer2

//in the 3rd window
//run RMIClient2
