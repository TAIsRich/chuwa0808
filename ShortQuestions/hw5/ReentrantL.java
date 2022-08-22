import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantL {

    public static void main(String[] args) {
        CounterReentrant counterReentrant = new CounterReentrant();

        Thread t1 = new Thread(() -> {
            int n = 5;
            while ( n-- > 0){
                counterReentrant.add(1);
                System.out.println("t1: " + counterReentrant.getCount());
            }
        });

        Thread t2 = new Thread(() -> {
            int n = 5;
            while ( n-- > 0){
                counterReentrant.add(1);
                System.out.println("t2: " + counterReentrant.getCount());
            }
        });

        t1.start();
        t2.start();
    }

}

class CounterSynchronized {
    private int count;

    public void add(int n){
        synchronized (this){
            count += n;
        }
    }

    public int getCount() {
        return count;
    }
}

class CounterReentrant{
    private final Lock lock = new ReentrantLock();
    private int count = 0;

    public void add (int n){
        lock.lock();
        try{
            count += n;
        } finally {
            lock.unlock();
        }
    }

    public int getCount() {
        return count;

    }
}
