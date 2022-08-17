package pattern.builder.demo1;

//director 在建造者模式十分重要，用于指导具体构建者如何构建产品
public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());
        //让指挥者指挥组装自行车
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
