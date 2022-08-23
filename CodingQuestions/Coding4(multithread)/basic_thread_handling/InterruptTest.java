public class InterruptTest {
    public static void main(String[] args)throws InterruptedException {
        // testIsInterrupted();
        // testInterruptWhileTrue();
        testInterruptSleep();
    }

    public static void testIsInterrupted() throws InterruptedException {
        Thread t = new MyThreadWithIsInterrupted();
        execute(t);
    }

    public static void testInterruptWhileTrue() throws InterruptedException {
        Thread t = new WhileTrue();
        execute(t);
    }

    public static void testInterruptSleep() throws InterruptedException {
        Thread t = new SleepForever();
        execute(t);
    }


    private static void execute(Thread t) throws InterruptedException {
        t.start();
        Thread.sleep(1); // 暂停2毫秒. Question, who sleep?
        t.interrupt(); // 中断t线程. Question, who is interrupted? 一定会被成功中断么？
        t.join(); // 等待t线程结束. Question, who is running, and who stopped?
        System.out.println("end");
    }

}


class MyThreadWithIsInterrupted extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int n = 0;
        while(!isInterrupted()){
            n++;
            System.out.println(n + " hello!");
        }
    }
}

class WhileTrue extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        int n = 0;
        while(true){
            n++;
            System.out.println(n + " hello!");
        }

    }
}

class SleepForever extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            Thread.sleep(5000*100000);
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println("t thread is interrupted");
            e.printStackTrace();
        }
        
    }
}