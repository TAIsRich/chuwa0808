public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        SingletonEager a = SingletonEager.getInstance();
        SingletonEager b = SingletonEager.getInstance();

        System.out.println(a == b);
    }
}