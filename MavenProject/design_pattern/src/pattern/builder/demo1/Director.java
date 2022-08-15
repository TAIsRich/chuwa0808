package pattern.builder.demo1;

public class Director {

    //声明builder类型的变量

    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public Bike construct(){
        builder.buildSeat();
        builder.buildFrame();
        return builder.createBike();
    }
}
