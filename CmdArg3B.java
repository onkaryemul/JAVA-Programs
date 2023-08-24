

public class CmdArg3B {

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

        StringBuffer s = new StringBuffer(""+val);

        StringBuffer d = s.reverse();

        String a = d.toString();

        System.out.println("String : " + a);

        return;
    }
    
}
