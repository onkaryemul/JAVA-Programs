
class Thrd41 extends Thread
{
    String nm;
    int val;

    Thrd41(String nm,int val)
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


class Thrd42 extends Thread
{
    String nm;
    int val;

    Thrd42(String nm,int val)
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


class Thrd43 extends Thread
{
    String nm;
    int val;

    Thrd43(String nm,int val)
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


public class Thread4 {
    
    public static void main(String[] args){
        
        System.out.println("Main Starts");

        Thrd41 a = new Thrd41("A",5);
        Thrd42 b = new Thrd42("B",23);
        Thrd43 c = new Thrd43("C",10);

        System.out.println("Main Ends...");

    }

}



