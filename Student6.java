
import java.util.*;
import javax.swing.*;

public class Student6 implements Comparable<Student6> {

    public int rno;
    public String nm;
    public int mrk;

    public Student6()
    {
        rno = mrk = 0;
        nm = new String();
    }

    public Student6(int a,String b,int c)
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

    public int compareTo(Student6 a)
    {
        return this.rno - a.rno;
    }
    

    public static void main(String[] args){
        
        LinkedList<Student6> obj = new LinkedList<Student6>();

        obj.add(new Student6(13,"Ajay",87));
        obj.add(new Student6(6,"Amita",92));
        obj.add(new Student6(18,"Vijay",59));
        obj.add(new Student6(26,"Sujata",72));
        obj.add(new Student6(12,"Suhas",72));

        JOptionPane.showMessageDialog(null,obj.toString());

        int n = obj.size();

        Student6[] arr = new Student6[n];

        obj.toArray(arr); // copies list data to array

        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

        Arrays.sort(arr);

        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

    }

}
