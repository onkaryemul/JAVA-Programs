
import javax.swing.*;
import java.util.*;

class Student9
{
    public int no;
    public String nm;

    public Student9()
    {
        no = 0;
        nm =  "";
    }

    public Student9(int a, String b)
    {
        no = a;
        nm = b;
    }

    public String toString()
    {
        return new String("\nRoll No. : " + no + "\nName : " + nm);
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

}

class MyList extends LinkedList<Student9>
{
    public MyList()
    {
        super();
    }

    public Student9 search(int no)
    {
        Student9 ref = null;
        int i=0, n = size();

        while(i<n)
        {
            ref = get(i);
            
            if(ref.no == no)
            {
                break;
            }

            i++;
        }

        if(i==n)
        {
            ref = null;
        }

        return ref;
    }

}


public class StudentList {
    
    public static void main(String[] args){
        
        MyList a = new MyList();

        int no = 0;

        while(true)
        {
            try
            {
                no = Integer.parseInt(JOptionPane.showInputDialog(null,"No. : "));
            }
            catch(Exception e)
            {
                continue;
            }

            if(no==0)
            {
                break;
            }

            Student9 ref = a.search(no);

            if(ref != null)
            {
                JOptionPane.showMessageDialog(null,"Record Exists");
            }
            else
            {
                ref = new Student9(no,JOptionPane.showInputDialog(null,"Name : "));
                a.add(ref);
            }

        }

        JOptionPane.showMessageDialog(null,"Data : \n" + a);
    }

}

