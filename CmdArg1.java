

public class CmdArg1 {

    public static void main(String[] args){

        int n = args.length;

        if(n==0)
        {
            System.out.println("Invalid Arguments");
            return;
        }
        
        int i=0,val=0,tot=0;

        while(i<n)
        {
            try
            {
                val = Integer.parseInt(args[i]);
            }
            catch(Exception e)
            {
                i++;
                continue;
            }

            tot += val;
            i++;
        }

        System.out.println("Total : " + tot);

    }

}
