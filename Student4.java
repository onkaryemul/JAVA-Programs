
import javax.swing.*;

interface DataIO
{
    void input();
    void display();
}

public class Student4 implements DataIO{
    
    public int no;
    public String nm;
    public float mrk;

    public Student4()
    {
        no = 0;
        nm = new String();
        mrk = 0.0f;
    }

    @Override
    public void input()
    {
        try
        {
            no = Integer.parseInt(JOptionPane.showInputDialog(null,"Roll No. : "));
            nm = JOptionPane.showInputDialog(null,"Name : ");
            mrk = Float.parseFloat(JOptionPane.showInputDialog(null,"Marks : "));
        }
        catch(Exception e){}
    }

    public String toString()
    {
        String s = "Roll No. : " + no + "\nName : " + nm + "\nMarks : " + mrk;
        return s;
    }

    @Override
    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    public void input(int n)
    {
        no = n;

        try
        {
            nm = JOptionPane.showInputDialog(null,"Name : ");
            mrk = Float.parseFloat(JOptionPane.showInputDialog(null,"Marks : "));
        }
        catch(Exception e){}
    }

    public static void main(String[] args){

        Student4 a = new Student4();
        a.input();
        a.display();

        Student4 b = new Student4();
        b.input(12);
        b.display();

        DataIO c = new Student4();
        c.input();
        //c.input(121);
        c.display();
    }
}
