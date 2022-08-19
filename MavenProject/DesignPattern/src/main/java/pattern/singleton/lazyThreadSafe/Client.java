package pattern.singleton.lazyThreadSafe;

import pattern.singleton.lazyThreadUnsafe.Singleton;

public class Client {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance1 = Singleton.getInstance();

        System.out.println(instance == instance1);
    }
}
