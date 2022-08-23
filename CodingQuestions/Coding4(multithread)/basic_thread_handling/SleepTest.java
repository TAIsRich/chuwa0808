public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                System.out.println("t thread starts to sleep 2 second");
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
            }
        });

        System.out.println("Main thread starts...");
        t.start();
        Thread.sleep(3000);
        System.out.println("Main thread starts to sleep 3 seconds");
        System.out.println("Main thread done");

    }
}
