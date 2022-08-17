package exercise.Java8.defaultInterface;

public interface DIML {
    static final String BLOG = "is Chuwa a";

    int add(int a, int b);

    default int substract(int a, int b){
        return a-b;
    }

    static String blogName(){
        return BLOG;
    }
}
