public class LazyLoadSingleton {
    private static volatile LazyLoadSingleton instance;
    private LazyLoadSingleton() {
    }
    public static LazyLoadSingleton getInstance() {
        if (instance == null) { // 可能是多个线程
            synchronized (LazyLoadSingleton.class) { // 保证正能进⼊⼀个线程
                if (instance == null) {
                    instance = new LazyLoadSingleton();
                }
            }
        }
        return instance;
    }
}