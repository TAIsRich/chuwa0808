package default_interface_method;

public class Client {
    public static void main(String[] args) {
        DIMImpl dim = new DIMImpl();

        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("Override method: " + dim.substract(1, 2));
        System.out.println("Override method: " + dim.BLOG);
    }
}
