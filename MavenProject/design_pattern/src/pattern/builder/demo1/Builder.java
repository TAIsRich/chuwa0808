package pattern.builder.demo1;

public abstract class Builder {
    //声明bike类型的变量并赋值

    protected Bike bike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();

    public abstract Bike createBike();

}
