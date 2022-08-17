package bike;

public class Director {

    private Builder builder;

    public  Director(Builder bUilder){
        this.builder = bUilder;
    }

    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
