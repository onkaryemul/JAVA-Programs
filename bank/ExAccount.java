
package bank;

import bank.Account;
import java.io.*; // for serializable
import mypkg.Util;
import mypkg.DataIO;


public class ExAccount extends Account implements Serializable {
    
    boolean state;

    public ExAccount()
    {
        super();
        state = true;
    }
    
    public boolean getState()
    {
        return state;
    }

    public void delete()
    { 
        state = false;
    }

    public String toString()
    {
        String s = super.toString() + "\nState : " + state ;
        return s;
    }

    public void display()
    {
        Util.display(toString());
    }

  /*  
    public static void main(String[] args){

    }
  */
}
