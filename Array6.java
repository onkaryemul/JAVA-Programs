
import java.util.*;
import javax.swing.*;

public class Array6 {

    public static void main(String[] args) {
        
        float[] K = new float[5];

        int i = 0;

        while(i<K.length)
        {
            try
            {
                K[i] = Float.parseFloat(JOptionPane.showInputDialog(null,"Data"));
            }
            catch(Exception e)
            {
                continue;
            }

            i++;
        }

        JOptionPane.showMessageDialog(null,Arrays.toString(K));
        
    }
    
}
