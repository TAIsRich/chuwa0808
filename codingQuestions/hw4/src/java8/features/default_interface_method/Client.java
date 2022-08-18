package java8.features.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DIMImpl di = new DIMImpl();
        System.out.println("Override method: " + di.add(1, 2));
        System.out.println("Default method: " + di.subtract(1, 2));
        System.out.println("Static method: " + DIMImpl.BLOG);
    }
}
