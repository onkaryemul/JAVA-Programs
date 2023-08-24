
import java.util.*;
import javax.swing.*;

/* 
   Class Name: 
       Matrix3

   Field: 
       int[][] x;

   Methods:
       constructors
       set
       toString()
       display()

*/
class Matrix3{

    public int[][] x;

    public Matrix3()
    {
        x = new int[3][3];
    }

    public Matrix3(int n)
    {
        x = new int[n][n];
    }

    public void set()
    {
        for(int i=0;i<x.length;i++)
        {
            for(int j=0;j<x[i].length;)
            {
                try
                {
                    x[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,"x["+i+"]["+j+"] : "));
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null,"Invalid Input!!\nEnter Again");
                    continue;
                }

                j++;
            }

        }

    }

    public String toString()
    {
        StringBuffer sb = new StringBuffer("");

        for(int i=0;i<x.length;i++)
        {
            sb.append(Arrays.toString(x[i]) + "\n");
        }

        return sb.toString();
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

}


/* 
   Class Name: 
       MatrixOperations

   Field:
       Matrix3 a,b,c

   Methods:
       constructors()
       add
       sub
       mul
       menu()
       output()

*/
public class MatrixOperations {
    
    public Matrix3 a,b,c;

    public MatrixOperations()
    {
        a = new Matrix3();
        b = new Matrix3();
        c = new Matrix3();
    }

    public MatrixOperations(int n)
    {
        a = new Matrix3(n);
        b = new Matrix3(n);
        c = new Matrix3(n);
    }

    public void add(Matrix3 a, Matrix3 b)
    {
        for(int i=0;i<a.x.length;i++)
        {
            for(int j=0;j<a.x[i].length;j++)
            {
                c.x[i][j] = a.x[i][j] + b.x[i][j];
            }

        }

    }

    public void sub(Matrix3 a, Matrix3 b)
    {
        for(int i=0;i<a.x.length;i++)
        {
            for(int j=0;j<a.x[i].length;j++)
            {
                c.x[i][j] = a.x[i][j] - b.x[i][j];
            }

        }

    }

    public void mul(Matrix3 a,Matrix3 b)
    {
        for(int i=0;i<a.x.length;i++)
        {
            for(int j=0;j<b.x[i].length;j++)
            {
                c.x[i][j] = 0;

                for(int k=0;k<a.x.length;k++)
                {
                    c.x[i][j] += (a.x[i][k] * b.x[k][j]);
                }
            }
        }
    }

    public void output()
    {
        JOptionPane.showMessageDialog(null, "Matrix C : \n" + c.toString() );
    }

    public void menu()
    {
        int opt;

        String[] option = new String[]{"Set Matrix a","Set Matrix b","Add Matrix a and b","Substract Matrix a and b","Multiply Matrix a and b","Display Matrix a","Display Matrix b","Output Matrix c","Exit"};

        while(true)
        {
            opt = JOptionPane.showOptionDialog(null,"Choose One","Matrix Operations",
                  JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,option,0);

            if(opt == 8)
            {
                break;
            }

            switch(opt)
            {
                case 0:
                    a.set();
                    break;

                case 1:
                    b.set();
                    break;

                case 2:
                    add(a, b);
                    break;

                case 3:
                    sub(a, b);
                    break;

                case 4:
                    mul(a, b);
                    break;

                case 5:
                    a.display();
                    break;

                case 6:
                    b.display();
                    break;
            
                case 7:
                    c.display();
                    break;
            }

        }

    }


    public static void main(String[] args){
        
        MatrixOperations matop = new MatrixOperations();
        matop.menu();
    }

}


