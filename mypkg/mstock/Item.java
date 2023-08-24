
package mypkg.mstock;

import java.io.*;
import mypkg.Util;
//import mypkg.mstock.NewDataIO;

public class Item implements Serializable, NewDataIO {
    
    int no;
    String nm;
    int qty;
    double rate;
    boolean state;

    public Item()
    {
        no = qty = 0;
        rate = 0.0;
        state = true;
        nm = new String();
    }

    public String toString()
    {
        String s = "\nItem Detail No. : " + no + "\nName : " + nm + "\nOpening Qty : " + qty + "\nRate : " + rate + "\nState : " + state;
        return s;
    }

    public void setData(int n)
    {
        no = n;
        nm = Util.sInput("Item Name : ");
        qty = Util.iInput("Opening Qty : ");
        rate = Util.dInput("Price Per Unit : ");
        state = true;
    }

    public void setData()
    {
        int a = Util.iInput("Item ID : ");
        setData(a);
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

    public int getOpnQty()
    {
        return qty;
    }

    public double getRate()
    {
        return rate;
    }

    public boolean getState()
    {
        return state;
    }

    public void delRecord()
    {
        state = false;
    }

}
