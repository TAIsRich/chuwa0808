package c06_util_concurrent_locks;

import java.util.concurrent.locks.StampedLock;

public class StampedLockLearn {
    public static void main(String[] args) {
        Point point = new Point();
        Thread twrite = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                point.move(100, 200);
            }
            System.out.println("Write done");
        });

        Thread tRead = new Thread (() -> System.out.println(point.distanceFromOrigin()));

        twrite.start();
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tRead.start();
    }
}

class Point {
    private final StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    public void move(double deltaX, double deltaY){
        long stamp = stampedLock.writeLock();
        try{
            x += deltaX;
            y += deltaY;
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    public double distanceFromOrigin() {
        long stamp = stampedLock.tryOptimisticRead();

        double currentX = x;
        double currentY = y;

        if(!stampedLock.validate(stamp)){
            stamp = stampedLock.readLock();
            try {
                currentX = x;
                currentY = y;
            } finally {
                stampedLock.unlockRead(stamp);
            }
        }

        return Math.sqrt(currentX * currentX + currentY * currentY);
    }
}
