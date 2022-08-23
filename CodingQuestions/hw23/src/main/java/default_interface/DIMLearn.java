package default_interface;

public interface DIMLearn {
    static final String BLOG = "Hello World!";
    int add(int a, int b);
    default int substract(int a, int b){
        return a - b;
    }
    static String blogName(){
        return BLOG;
    }
}
