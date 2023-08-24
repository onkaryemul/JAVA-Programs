
import javax.swing.*;
import java.util.*;

interface ISize
{
    int size = 5;
}

interface DataIO
{
    void input();
    void input(int no);
    void display();
}

interface ICalculate
{
    int total();
    int avg();
}


public class Student5 implements ISize,DataIO,ICalculate{

    public int no;
    public int[] mrk;

    public Student5()
    {
        no = 0;
        mrk = new int[size];
    }

    @Override
    public int total()
    {
        int tot = mrk[0];
        int i=1;

        while(i<size)
        {
            tot += mrk[i++];
        }

        return tot;
    }

    @Override
    public int avg()
    {
        return total()/size;
    }

    @Override
    public void input()
    {
        while(true)
        {
            try
            {
                no = Integer.parseInt(JOptionPane.showInputDialog(null,"Enter Roll No. : "));
    
                JOptionPane.showMessageDialog(null,"Enter Marks in 5 subjects");

                int i=0;
    
                while(i<size)
                {
                    try
                    {
                       mrk[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"mrk[" + i + "] : "));
                    }
                    catch(Exception e)
                    {
                        JOptionPane.showMessageDialog(null,"Invalid Input!!\nEnter Again");
                        continue;
                    }
    
                    i++;
                }

                break;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Invalid Input!!\nEnter Again");
            }
    
        }
       
    }

    @Override
    public void input(int no)
    {
        this.no = no;
        
        JOptionPane.showMessageDialog(null,"Enter Marks in 5 subjects");
            
        int i=0;

        while(i<size)
        {
            try
            {
               mrk[i] = Integer.parseInt(JOptionPane.showInputDialog(null,"mrk[" + i + "] : "));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null,"Invalid Input!!\nEnter Again");
                continue;
            }

            i++;
        }

    
    }

    public String toString()
    {
       String s = "\nRoll No. : " + no + 
                  "\nMarks : " + Arrays.toString(mrk) + 
                  "\nTotal : " + this.total() + 
                  "\nAverage : " + this.avg();
       return s;
    }

    @Override 
    public void display()
    {
       JOptionPane.showMessageDialog(null,toString());
    }

    public static void main(String[] args){
        
        Student5 a = new Student5();
        a.input();
        a.display();
        JOptionPane.showMessageDialog(null,"Total : " + a.total() + "\nAverage : " + a.avg());

        Student5 b = new Student5();
        b.input(12);
        b.display();
        JOptionPane.showMessageDialog(null,"Total : " + b.total() + "\nAverage : " + b.avg());

        DataIO c = new Student5();
        c.input();
        c.display();
     // JOptionPane.showMessageDialog(null,"Total : " + c.total() + "\nAverage : " + c.avg());
        c.input(121);
        c.display();

    }
    
}



