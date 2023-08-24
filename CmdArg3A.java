

public class CmdArg3A {
      
    public static void main(String[] args){

        int n = args.length;

        if( n != 1 )
        {
            System.out.println("Invalid Arguments");
            return;
        }
        
        int val=0;

        try
        {
            val = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Invalid");
            return;
        }

        String rev = ""; // null string

        while(val>0)
        {
            rev = rev + (val%10);
            val /= 10;
        }

        System.out.println("Reverse : " + rev);
        
        return;

    }
    
}
