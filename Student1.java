
import javax.swing.*;

public class Student1{

    public int no;
    public String nm;

    public Student1(){
        no = 0;
        nm = "";
    }
    public Student1(int a,String b){
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

        Student1 a = new Student1();

        a.setData();
        a.display();

    }

}