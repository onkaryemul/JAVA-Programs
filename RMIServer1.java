
//Remote method invocation
//calling server methods from client side

//remotely call kele janare methods are implemented through interface
//a class declared to implement the interface
//object of the above class is created at the server end

import java.rmi.*;
import java.rmi.server.*;

interface Inter1 extends Remote {   //Remote is also an interface
    public int getNo(int no) throws Exception;
}

class Inter1Impl extends UnicastRemoteObject implements Inter1 {

    Inter1Impl() throws RemoteException {
        super();        
    }

    public int getNo(int no) throws Exception {
        return (int)(Math.random()*no);
    }
}

public class RMIServer1 {
    
    public static void main(String [] args) throws Exception {

        Inter1Impl obj=new Inter1Impl();

        Naming.rebind("abc", obj);

        System.out.println("Server started");

    }

}


