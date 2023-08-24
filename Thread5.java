

class Thrd51 extends Thread
{
    String nm;
    int val;

    Thrd51(String nm,int val)
    {
        super(nm);

        this.nm = nm;
        this.val = val;
        
        start();
    }

    @Override
    public void run()
    {
        int i=1;
        while(i<=val)
        {
            System.out.println(nm + " " + i);

            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}

            i++;
        }
    }

}


class Thrd52 extends Thread
{
    String nm;
    int val;

    Thrd52(String nm,int val)
    {
        super(nm);

        this.nm = nm;
        this.val = val;
        
        start();
    }

    @Override
    public void run()
    {
        int i=1;

        System.out.println("Table");

        while(i<=10)
        {
            System.out.println(nm + " " + (val * i));

            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}

            i++;
        }
    }
    
}


class Thrd53 extends Thread
{
    String nm;
    int val;

    Thrd53(String nm,int val)
    {
        super(nm);

        this.nm = nm;
        this.val = val;
        
        start();
    }

    @Override
    public void run()
    {
        int i=1;

        System.out.println("Fibonacci Series");
        int a=-1;
        int b=1;
        int c=0;

        while(i<=val)
        {
            c = a + b;

            System.out.println(nm + " " + c);

            a = b;
            b = c;

            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}

            i++;
        }
    }
    
}


public class Thread5 {
    
    public static void main(String[] args) {
        
        System.out.println("Main Starts");

        Thrd51 a = new Thrd51("A",5);
        Thrd52 b = new Thrd52("B",23);
        Thrd53 c = new Thrd53("C",10);

        try
        {
            a.join();
            b.join();
            c.join();
        }
        catch(Exception e){}

        System.out.println("Main Ends...");

    }

}




