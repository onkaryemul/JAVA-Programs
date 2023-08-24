

class TDemo implements Runnable
{
    int no;
    
    TDemo(int a)
    {
        no = a;
    }

    @Override
    public void run()
    {
        int i = 1;
        while(i<=10)
        {
            System.out.println(" " + no*i);
            try
            {
                Thread.sleep(1000);
            }
            catch(Exception e){}

            i++;
        }
    }

}


public class RunnableDemo {

    public static void main(String[] args){
         
        System.out.println("Main starts");

        TDemo obj = new TDemo(15);

        Thread th = new Thread(obj);
        th.start();

        System.out.println("Main ends...");
    }
    
}




