public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        SingletonLazy a = SingletonLazy.getInstance();
        SingletonLazy b = SingletonLazy.getInstance();
        

        System.out.println(a == b);
    }
}