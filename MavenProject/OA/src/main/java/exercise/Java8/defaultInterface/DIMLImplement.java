package exercise.Java8.defaultInterface;

public class DIMLImplement implements DIML{
    /**
     *   只需要override add, substract 是default方法，不override也不会报错。
     *   但是如果不override add, 就会报错
     */
    @Override
    public int add(int a, int b){
        return a+b;
    }
}
