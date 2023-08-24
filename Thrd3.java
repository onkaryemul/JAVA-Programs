
// 

class Thread3 extends Thread 
{
    int no;

    public Thread3(int n)
    {
        super();
        no = n;
        start();
    }

    @Override
    public void run()
    {
        int i=1;
        while(i<=no)
        {
            System.out.println("Thread " + i);

            try
            {
                Thread.sleep(500);
            }
            catch(Exception e){}

            i++;
        }
    }

}


public class Thrd3 {

    public static void main(String[] args) {
        
        System.out.println("Main Starts");

        Thread3 a = new Thread3(10);
        Thread3 b = new Thread3(5);
    
        System.out.println("Main ends... ");
    }

}



