package creationalDesignPattern.builder;

/**
 * @Author: Flora Zhong
 * @ClassName: Builder
 * @Description: 分离了构建部件(Builder负责)和构造产品(即构建部件的顺序，Director负责)，适用于复杂对象的构造过程
 *               实现了构建部件和构造产品(即构建部件的顺序)的decoupling, 让二者可以更好地复用：不同的部件构建、相同的产品构造过程(即部件构建的顺序)，或者相同的部件构建、不同的产品构造过程(即部件构建的顺序)都可以做出不同的复杂对象
 *               将部件构建和产品构成过程(即部件构建的顺序)分开，一步一步创建一个复杂的对象。用户只需指定复杂对象的类型就可以得到该对对象，而无须知道其内部的具体构建部件和构造产品(即构建部件的顺序)的细节
 *
 *               抽象构建者(Builder)：这个接口规定要实现复杂对象的哪些部分的构建，并不涉及具体的部件构建方法
 *               具体构建者(MobileBuilder or OfoBuilder)：实现Builder接口，完成复杂对象的各个部件的具体构建方法。在部件构建完成后提供产品的实例
 *               产品(Bike)：要创建的复杂对象
 *               指挥者(Director)：调用具体构建者来构建复杂对象的各个部分，不涉及复杂对象的具体信息，只负责保证复杂对象各部分完整地按某种顺序构建(即产品构造过程)
 *
 *               优点：封装性好，builder pattern中的产品类的构建者类一般是比较稳定的，因此将主要的业务逻辑封装在指挥者类中对整体而言可以取得比较好的稳定性
 *                    在builder pattern中，客户端不必知道产品内部的组成细节，将产品本身和产品的组件构建、产品的构造解耦，使得不同的部件构建、相同的产品构造过程(即部件构建的顺序)，或者相同的部件构建、不同的产品构造过程(即部件构建的顺序)都可以做出不同的产品
 *                    更加精细地控制产品的创建过程，使复杂对象的创建步骤分解在不同的方法中，使得创建过程更加清晰，也更方便使用程序来控制创建过程
 *                    builder pattern容易进行扩展，如果有新的需求，实现一个新的建造者类就可以完成，基本上不用修改之前已经测试通过的代码，因此就不会对原有功能引入风险，符合open-closed principle
 *               缺点：builder pattern使用范围受到一定限制，它所创建的产品一般具有较多的共同点，部件组成相似，如果产品之间的差异性很大则不适合使用builder pattern
 * @Date: 8/16/22
 */

public abstract class Builder {
    // 声明Bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    public abstract void buildFrame();
    public abstract void buildSeat();
    public abstract Bike buildBike();
}
