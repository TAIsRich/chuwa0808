package singletondemo5;

import singletondemo4.Singleton;

public class Client {
    public static void main(String[] args) {
singletondemo4.Singleton instance = singletondemo4.Singleton.getInstance();
        singletondemo4.Singleton instance1 = Singleton.getInstance();
        System.out.println(instance == instance1);
    }
}
