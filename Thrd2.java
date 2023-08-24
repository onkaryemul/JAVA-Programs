
// 

public class Thrd2 {

    public static void main(String[] args) {
        
        System.out.println("Main Starts");

        Thread th = Thread.currentThread();

        System.out.println("Name : " + th.getName());
        System.out.println("Priority : " + th.getPriority());
        System.out.println("Isalive? : " + th.isAlive());

        for(int i=1;i<=10;i++)
        {
            System.out.println(i);

            try
            {
                Thread.sleep(100);
            }
            catch(Exception e){}
        }

        System.out.println("Main ends... ");
    }

}



