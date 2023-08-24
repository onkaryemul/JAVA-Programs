
package mypkg;

import java.io.*;
//import mypkg.Util;

public class Student implements Serializable {
    
    public int no;
    public String nm;

    public Student()
    {
        no = 0;
        nm = new String();
    }

    public String toString()
    {
        String s = "\nRoll No : " + no + "\nName : " + nm;
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

    public void setData()
    {
        no = Util.iInput("Roll No. : ");
        nm = Util.sInput("Name : ");
    }

    public void setData(int n)
    {
        no = n;
        nm = Util.sInput("Name : ");
    }
   
  /*  
    public static void main(String[] args){
        
    }
  */
}
