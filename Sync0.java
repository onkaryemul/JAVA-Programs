// Synchronization 

// No synchronization

class TShared 
{
    void table(int no)
    {
        System.out.println("Table");
        for(int i=1;i<=10;i++)
        {
            System.out.println(no*i);
        }
    }
}


class Thread21 extends Thread
{
    TShared obj;
    int no;

    Thread21(TShared ref,int n)
    {
        super();
        obj = ref;
        no = n;
        start();
    }

    @Override
    public void run()
    {
        obj.table(no);
    }
}


public class Sync0 {

    public static void main(String[] args){

        System.out.println("Main Starts");

        TShared a = new TShared();
        Thread21 b = new Thread21(a,10);
        Thread21 c = new Thread21(a,20);

        try
        {
            b.join();
            c.join();
        }
        catch(Exception e){}

        System.out.println("Main Ends...");
    }
}




