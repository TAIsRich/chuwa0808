package java8.features.lambda;

@FunctionalInterface
public interface Foo extends Baz, Bar {
    @Override
    default String defaultCommon() {
        String s = "defaultCommon from foo";
        System.out.println(s);
        return s;
    }
}
