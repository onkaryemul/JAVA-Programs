
import javax.swing.*;
import java.util.*;

public class UseVector3{

    public static void main(String[] args){

        Vector<Integer> a = new Vector<Integer>();

        int val=0,i=0,tot=0;

        while(true)
        {
            try
            {
                val = Integer.parseInt(JOptionPane.showInputDialog(null,"Data : "));
            }
            catch(Exception e)
            {
                continue;
            }

            if(val==0)
            {
                break;
            }

            a.add(val);
        }

        while( i < a.size() )
        {
            try
            {
                val = (a.get(i)).intValue();
            }
            catch(Exception e){}
            
            tot += val;

            i++;
        }

        String str = "Data\n" + a + "\nTotal : " + tot;

        JOptionPane.showMessageDialog(null,str);
        
    }

}