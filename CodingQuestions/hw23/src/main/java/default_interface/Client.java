package default_interface;

public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();
        System.out.println("Override: " + dim.add(1, 2));
        System.out.println("Default: " + dim.substract(1, 2));
        System.out.println("Static: " + DIMLearn.blogName());
    }
}
