// Use of Command Line Arguments

public class Table3 {

     public static void main(String[] args)
     {
        if(args.length != 1)
        {
            System.out.println("Invalid Arguments!!");
            return;
        }

        int no=0,i=1;

        try
        {
            no = Integer.parseInt(args[0]);
        }
        catch(Exception e)
        {
            System.out.println("Invalid Data!!");
            return;
        }

        System.out.println("Table\n");

        for(i=1;i<=10;i++)
        {
             System.out.print(" " + (no*i));
        }
        
     }
}
