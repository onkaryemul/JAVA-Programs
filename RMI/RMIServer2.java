//Remote method invocation
//calling server methods from client side

//remotely call kele janare methods are implemented thrrough interface
//a class declared to implement the interface
//object of the above class is created at the server end

import java.rmi.*;
import java.rmi.server.*;

interface Inter2 extends Remote {   //Remote is also an interface
    public int getNo(int no) throws Exception;
    public void setNo(int no) throws Exception;
    public boolean isPrime() throws Exception;
    public int count() throws Exception;
}

class Inter2Impl extends UnicastRemoteObject implements Inter2 {

    int no;

    Inter2Impl() throws RemoteException {
        super();        
    }

    public int getNo(int no) throws Exception {
        return no;
    }

    public void setNo(int no) throws Exception {
        this.no=no;
    }

    public boolean isPrime() throws Exception {
        int i=2;
        while(i<no) {
            if(no%i==0)
                break;
            else
                i++;
        }

        return i==no;
    }

    public int count() {
        int tmp=no,cnt=0;

        while(tmp>0) {
            cnt++;
            tmp/=10;
        }

        return cnt;
    }
}


public class RMIServer2 {
    
    public static void main(String [] args) throws Exception {
        Inter2Impl obj=new Inter2Impl();

        Naming.rebind("abc", obj);

        System.out.println("Server started");
    }
}

