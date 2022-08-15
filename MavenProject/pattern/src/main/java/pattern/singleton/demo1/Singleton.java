package pattern.singleton.demo1;

import java.io.Serializable;

public class Singleton implements Serializable {

    private Singleton() {
    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Object readResolve() {
        return SingletonHolder.INSTANCE;
    }

}
