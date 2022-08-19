package exercise.Java8.defaultInterface;

public class Client {
    public static void main(String[] args){
        DIMLImplement dim = new DIMLImplement();
        System.out.println("Override method: " + dim.add(1, 2));
        System.out.println("default method: " + dim.substract(1, 2));
        System.out.println("static method: " + DIML.blogName());
    }
}
