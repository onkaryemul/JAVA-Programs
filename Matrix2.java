
import java.util.*;
import javax.swing.*;

public class Matrix2{

    public static void main(String[] args){
        
        int x[][] = null; // reference variable to an array

        x = new int[3][]; // memory allocation to hold one-D array references

        int i=0,j=0;

        while(i<x.length)
        {
            x[i] = new int[i+1];
            i++;
        }

        i=0;

        while(i<x.length)
        {
            j=0;
            while(j<x[i].length)
            {
                try
                {
                    x[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,"value"));
                }
                catch(Exception e)
                {
                    continue;
                }

                j++;
            }

            i++;
        }
        
        String s = "Matrix\n";

        for(i=0;i<x.length;i++)
        {
            s = s + Arrays.toString(x[i]) + "\n";
        }

        JOptionPane.showMessageDialog(null,s);
    }

}