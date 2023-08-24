
import java.lang.Math;

public class Table1 {
    public static void main(String[] args) {
        
        String str = "Table\n";
        
        int n = (int)(Math.random()*100);

        for(int i=1;i<=10;i++)
        {
            str = str + " " + (n*i);
        }

        System.out.println(str);
    }
    
}
