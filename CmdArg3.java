

public class CmdArg3 {

    public static void main(String[] args){

        int n = args.length;

        if( n != 1 )
        {
            System.out.println("Invalid Arguments");
            return;
        }
        
        int rev=0,val=0;

        try
        {
            val = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Invalid");
            return;
        }

        while(val>0)
        {
            rev = rev*10 + (val%10);
            val /= 10;
        }

        System.out.println("Reverse : " + rev);
        
        return;

    }
    
}
