
import javax.swing.*;
import java.util.*;

public class Matrix1 {
    
    public static void main(String[] args) {

        int x[][] = new int[3][3];

        int i=0,j=0;

        while(i<3)
        {
            j=0;

            while(j<3)
            {
                try
                {
                    x[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null,"x["+i+"]["+j+"]"));
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

        for(i=0;i<3;i++)
        {
            s = s + Arrays.toString(x[i]) + "\n";
        }

        JOptionPane.showMessageDialog(null,s);
        
    }

}
