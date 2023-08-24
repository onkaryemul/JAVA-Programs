
// 

public class Thrd1 {

    public static void main(String[] args) {
        
        System.out.println("Main Starts");

        Thread th = Thread.currentThread();

        System.out.println("Name : " + th.getName());
        System.out.println("Priority : " + th.getPriority());
        System.out.println("Isalive? : " + th.isAlive());

        System.out.println("Main ends... ");
    }

}



