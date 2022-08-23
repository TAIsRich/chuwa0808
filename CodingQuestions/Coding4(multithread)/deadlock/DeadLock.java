public class DeadLock {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            while(true){
                Counter1.add();
            }
            
        });

        Thread t2 = new Thread(()->{
            while(true){
                Counter1.dec();
            }
            
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("main end");
    }
}

class Counter1{
    private static final Object LOCK1 = new Object();
    private static final Object LOCK2 = new Object();

    private static int num1 = 0;
    private static int num2 = 0;

    public static void add(){
        synchronized(LOCK1){
            num1++;
            synchronized(LOCK2){
                num2++;
            }
        }
        System.out.println("num1 is: " + num1 + ", num2 is: " + num2);
    }

    public static void dec(){
        synchronized(LOCK2){
            num2--;
            synchronized(LOCK1){
                num1--;
            }
        }
        System.out.println("num1 is: " + num1 + ", num2 is: " + num2);
    }




}