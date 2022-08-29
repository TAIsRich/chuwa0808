public class Singleton {
    // 1, static volatile variable
    private static volatile Singleton instance;
    // 2, make constructor be private
    // 保证不能new， ⼀旦可以new, 就可以建造很多instance， 则就不再是singleton。
    private Singleton() {
    }
    // 3. static synchronized getInstance method
    // static保证在没有instance的情况下，可以调该⽅法。
    public static Singleton getInstance() {
// 4, make sure thread safe, improve performance
        if (instance == null) { // 可能是多个线程
            synchronized (Singleton.class) { // 保证正能进⼊⼀个线程
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}