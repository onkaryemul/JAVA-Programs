
import java.util.*;
import javax.swing.*;

public class UseVector2 {

    public static void main(String[] args){
        
        Vector<Integer> x = new Vector<Integer>();

        int val = 0;

        while(true)
        {
            try
            {
                val = Integer.parseInt(JOptionPane.showInputDialog(null,"value"));
            }
            catch(Exception e)
            {
                continue;
            }

            if(val==0)
            {
                break;
            }

            x.add(val);
        }

        int i=0,n=x.size();

        while(i<n)
        {
            JOptionPane.showMessageDialog(null,"Data : " + x.get(i));
            i++;
        }

    }
    
}
