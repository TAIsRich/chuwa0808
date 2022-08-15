package Builder.demo1;

//指挥者类
//一种拓展是可将builder与director合并，这样的确简化了系统结构，但这样加重了builder类的职责，也比较不符合单一职责原则
//若construct()过于复杂，还是建议分开
//将产品本身与产品的创建解耦

public class Director {

    //声明builder类型的变量
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    //组装自行车
    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
