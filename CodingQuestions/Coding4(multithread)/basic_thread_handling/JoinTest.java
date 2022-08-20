public class JoinTest {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println("thread starts");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            System.out.println("Thread end");
        });

        System.out.println("Main start");
        t.start();

        System.out.println("Main thread is stopped and waiting for t thread end");
        try {
            t.join();
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        
        System.out.println("Main stop");
    }
}
