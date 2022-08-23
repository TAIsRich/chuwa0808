package c07_executor_framework;

import java.util.concurrent.Executor;

public class ThreadExecutorExample {

    public static void main(String[] args) {
        DumdExecutor myExecutor = new DumdExecutor();
        MyTask myTask = new MyTask();
        myExecutor.execute(myTask);
    }

    static class DumdExecutor implements Executor{

        @Override
        public void execute(Runnable command) {
            Thread newThread = new Thread(command);
            newThread.start();
        }
    }

    static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println("Mytask is running now ...");
        }
    }
}
