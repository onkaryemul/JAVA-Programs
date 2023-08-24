

class Thrd61 extends Thread
{
    String nm;
    long val;
    volatile boolean flg;

    Thrd61(String nm,int priority)
    {
        super(nm);

        this.nm = nm;
        setPriority(priority);
    }

    @Override
    public void run()
    {
        val = 1;
        while(flg == true)
        {
            val++;
        }
    }

    public void tStart()
    {
        flg = true;
        start();
    }

    public void tStop()
    {
        flg = false;
    }
}


public class Thread6 {
    
    public static void main(String[] args) {
        
        System.out.println("Main Starts");

        Thrd61 a = new Thrd61("A",1);
        Thrd61 b = new Thrd61("B",5);
        Thrd61 c = new Thrd61("C",10);

        a.tStart();
        b.tStart();
        c.tStart();
    
        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e){}

        a.tStop();
        b.tStop();
        c.tStop();

        try
        {
            a.join();
            b.join();
            c.join();
        }
        catch(Exception e){}

        System.out.println("a.val : " + a.val);
        System.out.println("b.val : " + b.val);
        System.out.println("c.val : " + c.val);

        System.out.println("Main Ends...");

    }

}




