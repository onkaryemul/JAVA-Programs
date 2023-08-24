
import javax.swing.*;
import java.util.*;

public class Student3{

    public int no;
    public String nm;

    public Student3(){
        no = 0;
        nm = "";
    }
    public Student3(int a,String b){
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

        ArrayList<Student3> p = new ArrayList<Student3>();

        int no = 0;

        while(true)
        {
            try
            {
                no = Integer.parseInt(JOptionPane.showInputDialog(null,"Roll No.: "));
            }
            catch(Exception e)
            {
                continue;
            }

            if(no==0)
            {
                break;
            }

            Student3 a = new Student3();
            a.setData(no);
            
            p.add(a);
        }

        Iterator<Student3> it = p.iterator();

        while(it.hasNext())
        {
            Student3 k = it.next();
            k.display();
        }

        JOptionPane.showMessageDialog(null,"Data : \n" + p);
    }

}


