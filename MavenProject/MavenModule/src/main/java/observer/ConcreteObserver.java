package observer;

public class ConcreteObserver implements Observer{
    private String name;

    public ConcreteObserver(String name){
        this.name = name;
    }

    public void update(String msg) {
        System.out.println(name + msg);
    }
}
