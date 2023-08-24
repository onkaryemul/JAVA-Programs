// Regular class in other package

package bank;

import mypkg.Util;
import mypkg.DataIO;
import java.io.*;

public class Account implements DataIO, Serializable{

    int no;
    String nm;
    int balance;

    public Account()
    {
        no = 0;
        nm = new String();
        balance = 0;
    }

    public void setData()
    {
        no = Util.iInput("A/c No. : ");
        nm = Util.sInput("Name : ");
        balance = Util.iInput("Balance : ");
    }

    public void setData(int n)
    {
        no = n;
        nm = Util.sInput("Name : ");
        balance = Util.iInput("Balance : ");
    }

    public String toString()
    {
        String s = "A/c No. : " + no + "\nName : " + nm + "\nBalance : " + balance;
        return s;
    }

    public void display()
    {
        Util.display(toString());
    }

    public int getNo()
    {
        return no;
    }

    public String getName()
    {
        return nm;
    }

    public int getBalance()
    {
        return balance;
    }
    
 /* 
    public static void main(String[] args){
         
    }
 */
}