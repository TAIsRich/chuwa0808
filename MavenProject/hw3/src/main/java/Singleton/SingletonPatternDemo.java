package Singleton;

public class SingletonPatternDemo {
    public static void main(String[] args) {
        //this is wrong
        //SingleObject object = new SingleObject();

        SingleObject object = SingleObject.getInstance();
        object.showMessage();

        //or
        SingleObject.getInstance().showMessage();
    }
}
