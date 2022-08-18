package hw.hw4.lambda;

public interface Foo {

    String method(String str);

    default String defaultBaz() {
        String s = "default Baz method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
//        return Baz.super.defaultCommon();
        String s = "defaultCommon from Foo";
        System.out.println(s);
        return s;
    }
}
