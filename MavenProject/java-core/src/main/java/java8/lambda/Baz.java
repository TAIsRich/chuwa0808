package java8.lambda;

public interface Baz {

    default String defaultBaz() {
        String s = "defaultBaz method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "defaultCommon from Baz";
        System.out.println(s);
        return s;
    }
}
