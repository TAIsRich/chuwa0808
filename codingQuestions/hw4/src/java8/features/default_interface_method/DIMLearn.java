package java8.features.default_interface_method;

public interface DIMLearn {

    static final String BLOG = "is Chuwa";

    int add(int a, int b);

    default int subtract(int a, int b){
        return a - b;
    }

    static String blogName(){
        return BLOG;
    }
}
