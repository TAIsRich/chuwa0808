package builder;

public class Director {
    private Builder b;
    public Director(Builder b){
        this.b = b;
    }

    public Bike consBike(){
        b.buildSeat();
        b.buildFrame();
        return b.createBike();
    }
}
