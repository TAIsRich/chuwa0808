public class SynchronizedThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread []{
            new AddStudentThread(),
            new AddTeacherThread(),
            new DecStudentThread(),
            new DecTeacherThread()
        };
        for(Thread t : threads){
            t.start();
        }

        for(Thread t : threads){
            t.join();
        }

        System.out.println(Counter.studentCount);
        System.out.println(Counter.teacherCount);
    }
}

class Counter {
    public static final Object LOCK_STUDENT = new Object();
    public static final Object LOCK_TEACHER = new Object();
    public static int studentCount = 0;
    public static int teacherCount = 0;
}

class AddStudentThread extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        for (int i = 0; i < 10000; i++) {
            synchronized (Counter.LOCK_STUDENT) {
                Counter.studentCount += 1;
            }
        }
    }
}

class DecStudentThread extends Thread {
    @Override
    public void run() {
        for(int i = 0;i < 10000;i++){
            synchronized(Counter.LOCK_STUDENT){
                Counter.studentCount--;
            }
        }
    }
}

class AddTeacherThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i < 10000;i++){
            synchronized(Counter.LOCK_TEACHER){
                Counter.teacherCount++;
            }
        }
    }
}

class DecTeacherThread extends Thread{
    @Override
    public void run() {
        for(int i = 0;i < 10000;i++){
            synchronized(Counter.LOCK_TEACHER){
                Counter.teacherCount--;
            }
        }
        
    }
}
