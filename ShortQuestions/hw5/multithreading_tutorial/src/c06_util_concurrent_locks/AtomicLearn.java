package c06_util_concurrent_locks;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicLearn {
    public int incrementAndGet(AtomicInteger var){
        int prev, next;
        do {
            prev = var.get();
            next = prev +1;
        } while (! var.compareAndSet(prev, next));
        return next;
    }
}

class IDGenerator {
    AtomicLong var = new AtomicLong(0);

    public long getNextID() {
        return var.incrementAndGet();
    }
}
