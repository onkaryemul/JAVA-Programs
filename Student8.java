
import java.util.*;
import javax.swing.*;

public class Student8 implements Comparable<Student8>, Comparator<Student8>{
    
    public int no;
    public String nm;
    public String tnm;
    public String cnm;

    public Student8()
    {
        no = 0;
        nm = "";
        tnm = "";
        cnm = "";
    }

    public String toString()
    {
        String s = "\nRoll No. : " + no +
                   "\nName : " + nm +
                   "\nTrade : " + tnm +
                   "\nCity : " + cnm;
        return s;
    }

    public void display()
    {
        JOptionPane.showMessageDialog(null,toString());
    }

    public void setData(int a)
    {
        no = a;

        String[] trade = new String[]{"CSE","IT","TRON","TRIC","CIVIL","MECH"};

        String[] city = new String[]{"Sangli","Kolhapur","Belgavi","Dharwad","Barshi","Beed","Nagpur"};

        try
        {
            nm = JOptionPane.showInputDialog(null,"Name");

            tnm = trade[JOptionPane.showOptionDialog(null,"Choose Trade","Trade",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,trade,0)];

            cnm = city[JOptionPane.showOptionDialog(null,"Choose City","City",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE,null,city,0)];

        }
        catch(Exception e){}

    }

    @Override
    public int compareTo(Student8 a)
    {
        return this.no - a.no;
    }

    @Override
    public int compare(Student8 a,Student8 b)
    {
        return (a.nm).compareTo(b.nm);
    }

    // user defined comparator
    public static Comparator<Student8> orderTrade = new Comparator<Student8>(){

        @Override
        public int compare(Student8 a,Student8 b)
        {
            return (a.tnm).compareTo(b.tnm);
        }
    };

    public static Comparator<Student8> orderTradeNo = new Comparator<Student8>(){

        @Override
        public int compare(Student8 a,Student8 b)
        {
            int res = (a.tnm).compareTo(b.tnm);

            if(res == 0)
            {
                return a.no - b.no;
            }

            return res;
        }
    };

    public static Comparator<Student8> orderCity = new Comparator<Student8>(){

        @Override
        public int compare(Student8 a,Student8 b)
        {
            return (a.cnm).compareTo(b.cnm);
        }
    };

    public static Comparator<Student8> orderCityTrade = new Comparator<Student8>(){

        @Override
        public int compare(Student8 a,Student8 b)
        {
            int res = (a.cnm).compareTo(b.cnm);

            if(res == 0)
            {
                return (a.tnm).compareTo(b.tnm);
            }

            return res;
        }
    };


    public static void main(String[] args){

        LinkedList<Student8> a = new LinkedList<Student8>();

        int n=0;

        while(true)
        {
            try
            {
                n = Integer.parseInt(JOptionPane.showInputDialog(null,"Roll No. : "));
            }
            catch(Exception e)
            {
                continue;
            }

            if(n==0)
            {
                break;
            }

            Student8 b = new Student8();
            b.setData(n);
            
            a.add(b);
        }

        JOptionPane.showMessageDialog(null,"Data : \n" + a);

        n = a.size();

        Student8[] arr = new Student8[n];
        a.toArray(arr); // copy linked list to array

        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

        Arrays.sort(arr);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

        Arrays.sort(arr,new Student8());
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
       
        Arrays.sort(arr,Student8.orderTrade);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
       
        Arrays.sort(arr,Student8.orderTradeNo);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));
        
        Arrays.sort(arr,Student8.orderCity);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

        Arrays.sort(arr,Student8.orderCityTrade);
        JOptionPane.showMessageDialog(null,Arrays.toString(arr));

    }

}

