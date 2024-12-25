// package example.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("10.40.4.177", 1099);
            HelloInterface hello = (HelloInterface) Naming.lookup("rmi://10.40.4.177:1099/HelloService");
            String response = hello.sayHello();
            int n,m;
            Scanner sc = new Scanner(System.in);
            n = sc.nextInt();
            m = sc.nextInt();
            int sumresponce = hello.addnumber(n,m);
            System.out.println("The Sum of Above two numbers :" + sumresponce);

            System.out.println("Response from server: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
