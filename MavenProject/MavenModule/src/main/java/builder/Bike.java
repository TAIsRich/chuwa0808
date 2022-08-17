package builder;

public class Bike {
    private String frame;
    private String seat;

    public void setFrame(String f){
        this.frame = f;
    };
    public void setSeat(String s){
        this.seat = s;
    };

    public String getFrame(){
        return this.frame;
    }
    public String getSeat(){
        return this.seat;
    }
}
