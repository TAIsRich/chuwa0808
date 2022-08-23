import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLearn {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        int i = ai.getAndIncrement();
        System.out.println(i + " " + ai);
    }
}
