
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import mypkg.Util;

public class Student10 implements Serializable {

    public int no;
    public String nm;
    public String tnm;

    public Student10()
    {
        no = 0;
        nm = new String();
        tnm = new String();
    }

    public Student10(int a, String b, String c)
    {
        no = a;
        nm = b;
        tnm = c;
    }

    public String toString()
    {
        String s = "\nRoll No. : " + no + "\nName : " + nm + "\nTrade : " + tnm;
        return s;
    }

    public void display()
    {
        Util.display(toString());
    }
    
}
