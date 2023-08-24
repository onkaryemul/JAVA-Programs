
import java.util.*;
import javax.swing.*;

public class Student7 implements Comparable<Student7>, Comparator<Student7> {

    public int rno;
    public String nm;
    public int mrk;

    public Student7()
    {
        rno = mrk = 0;
        nm = new String();
    }

    public Student7(int a,String b,int c)
    {
        rno = a;
        nm = b;
        mrk = c;
    }

    public String toString()
    {
        String a = "Roll No. : " + rno + 
                   "\nName : " + nm +
                   "\nMarks : " + mrk;
        return a;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    public int compareTo(Student7 a)
    {
        return this.rno - a.rno;
    }
    
    public int compare(Student7 a,Student7 b)
    {
        return (a.nm).compareTo(b.nm);
    }

    public static void main(String[] args){
        
        LinkedList<Student7> obj = new LinkedList<Student7>();

        obj.add(new Student7(13,"Ajay",87));
        obj.add(new Student7(6,"Amita",92));
        obj.add(new Student7(18,"Vijay",59));
        obj.add(new Student7(26,"Sujata",72));
        obj.add(new Student7(12,"Suhas",72));

        JOptionPane.showMessageDialog(null,obj.toString());

        int n = obj.size();

        Student7[] arr = new Student7[n];

        obj.toArray(arr); // copies list data to array

        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
        Arrays.sort(arr);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
        Arrays.sort(arr,new Student7());
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

    }

}
