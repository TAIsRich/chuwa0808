package SimpleFactory;

public abstract class coffee {

    public abstract String getName();

    public void addSugar() {
        System.out.println("Add Sugar!");
    }

    public void addMilk() {
        System.out.println("Add Milk!");
    }
}
