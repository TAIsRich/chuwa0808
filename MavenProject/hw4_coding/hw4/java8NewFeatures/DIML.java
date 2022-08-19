package hw.hw4.java8NewFeatures;

public interface DIML {
    static final String BLOG = "is Chuwa a";

    int add(int a , int b);

    default int subtract(int a, int b){
        return a- b;
    }

    static String blogName(){
        return BLOG;
    }
}
