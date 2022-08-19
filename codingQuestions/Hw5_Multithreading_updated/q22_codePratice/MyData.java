package Hw5_Multithreading_updated.q22_codePratice;

public class MyData {//for ThreadLocalLearn

    ThreadLocal<Integer> threadLocalField = ThreadLocal.withInitial(() -> 0);

    public void add() {
        threadLocalField.set(1 + threadLocalField.get());
    }
}
