// Synchronization using synchronization method

class TShared1
{
    synchronized void table(int no) // synchronized method
    {
        System.out.println("Table");
        for(int i=1;i<=10;i++)
        {
            System.out.println(no*i);
        }
    }
}


class Thread22 extends Thread
{
    TShared1 obj;
    int no;

    Thread22(TShared1 ref,int n)
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


public class Sync1 {

    public static void main(String[] args){

        System.out.println("Main Starts");

        TShared1 a = new TShared1();
        Thread22 b = new Thread22(a,10);
        Thread22 c = new Thread22(a,20);

        try
        {
            b.join();
            c.join();
        }
        catch(Exception e){}

        System.out.println("Main Ends...");
    }
}




