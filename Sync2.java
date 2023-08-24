// Synchronization using synchronized code block

class TShared2
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


class Thread23 extends Thread
{
    TShared2 obj;
    int no;

    Thread23(TShared2 ref,int n)
    {
        super();
        obj = ref;
        no = n;
        start();
    }

    @Override
    public void run()
    {
        synchronized(obj)  // synchronized code block
        {
            obj.table(no);
        }
    }

}


public class Sync2 {

    public static void main(String[] args){

        System.out.println("Main Starts");

        TShared2 a = new TShared2();
        Thread23 b = new Thread23(a,10);
        Thread23 c = new Thread23(a,20);

        try
        {
            b.join();
            c.join();
        }
        catch(Exception e){}

        System.out.println("Main Ends...");
    }
}




