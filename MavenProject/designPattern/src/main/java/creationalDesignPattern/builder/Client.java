package creationalDesignPattern.builder;

public class Client {
    public static void main(String[] args) {
        // 创建指挥者对象
        Director director = new Director(new OfoBuilder());
        // 让指挥者构造自行车
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
