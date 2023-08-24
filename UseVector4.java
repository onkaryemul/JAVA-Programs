
import javax.swing.*;
import java.util.*;

public class UseVector4 {

    public static void main(String[] args){

        Vector<Integer> a = new Vector<Integer>();

        int val=0,i=0;

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
        
        // Option 1
        JOptionPane.showMessageDialog(null,"Data : \n" + a);

        // Option 2
        String str = "Data\n";

        while( i < a.size() )
        {
            str = str + "  " + a.get(i);
            i++;
        }

        JOptionPane.showMessageDialog(null,str);

        // Option 3 --> Using Iterator
        Iterator<Integer> it = a.iterator();

        str = "Data : \n";

        while(it.hasNext())
        {
            str = str + "  " + it.next();
        }

        JOptionPane.showMessageDialog(null,str);
        
        // Option 4 --> Using ListIterator
        ListIterator<Integer> ait = a.listIterator();

        str = "Data : \n";

        while(ait.hasNext())
        {
            str = str + "  " + ait.next();
        }

        JOptionPane.showMessageDialog(null,str);

        str = "Data : \n";

        while( ait.hasPrevious() )
        {
            str = str + "  " + ait.previous();
        }

        JOptionPane.showMessageDialog(null,str);

    }
    
}
