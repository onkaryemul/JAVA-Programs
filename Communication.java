

class Shared 
{
    int data,flg;

    public Shared() 
    {
        data = flg = 0;
    }

    synchronized public void produce() 
    {
        if(flg == 0) 
        {
            flg = 1;

            try
            {
                wait();
            }
            catch(Exception e){}
        }

        try 
        {
            Thread.sleep(1000);
        }
        catch(Exception e){}

        data=(int)(Math.random()*100);

        notify();
    }

    synchronized public void consume() 
    {
        if(flg == 1)
           notify();
        else    
           flg=1;

        try 
        {
           wait();
        }
        catch(Exception e){}

        String s="Table\n";

        for(int i=1;i<=10;i++)
            s=s+" "+(data*i);

        System.out.println(s);
    }
}


class T1 extends Thread 
{
    Shared obj;

    public T1(Shared obj) 
    {
        super();
        this.obj=obj;
        start();
    }

    @Override
    public void run() 
    {
        obj.consume();
    }
}


class T2 extends Thread 
{
    Shared obj;

    public T2(Shared obj) 
    {
        super();
        this.obj=obj;
        start();
    }

    @Override
    public void run() 
    {
        obj.produce();
    }
}


public class Communication {

    public static void main(String [] args) {

        //first consumer then producer
        Shared a=new Shared();

        T1 b=new T1(a);
        T2 c=new T2(a);

        try 
        {
            b.join();
            c.join();
        }
        catch(Exception e1){}


        //first producer then consumer
        Shared d = new Shared();

        T2 f=new T2(d);
        T1 e=new T1(d);

        try 
        {
            f.join();
            e.join();
        }
        catch(Exception e2) {}
        
        System.out.println("Main ends");
    }
    
}




