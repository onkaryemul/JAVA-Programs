
import javax.swing.*;
import java.util.*;

public class Student2{

    public int no;
    public String nm;

    public Student2(){
        no = 0;
        nm = "";
    }
    public Student2(int a,String b){
       no = a;
       nm = b;
    }

    public void setData()
    {
        try
        {
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"Roll No.:"));
            nm = JOptionPane.showInputDialog(null,"Name : ");
        }
        catch(Exception e){}
    }

    public void setData(int no){
        this.no = no;
        nm = JOptionPane.showInputDialog(null,"Name : ");
    }

    public String toString(){
        String s = "Roll No. : " + no + "\nName : " + nm;
        return s;
    }

    public void display(){
       JOptionPane.showMessageDialog(null,"Data : \n" + toString());
    // JOptionPane.showMessageDialog(null,"Data : \n" + this);
    }

    public static void main(String[] args){

        Student2 a[] = new Student2[5];

        int i=0;

        while( i < a.length)
        {
            a[i] = new Student2();
            a[i].setData(i+1);
            i++;
        }

        JOptionPane.showMessageDialog(null,Arrays.toString(a));

    }

}