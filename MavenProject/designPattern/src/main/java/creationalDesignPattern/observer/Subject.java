package creationalDesignPattern.observer;

/**
 * @Author: Flora Zhong
 * @ClassNAme: Subject
 * @Description: 也称为publish-subscribe (pub-sub) pattern
 *               定义了一种一对多的关系，让多个观察者对象同时监听某一个主题对象
 *               主题对象状态发生变化时，会通知所有的观察者对象，让观察者对象能自动更新自己
 *               适用于对象间存在一对多的关系，即一个对象的状态发生改变会影响其它对象
 *               适用于一个抽象模型有两个方面且其中一个方面依赖于另一方面时的情形
 *
 *               抽象主题(Subject)：抽象主题把所有观察者对象保存在一个集合里(此时Subject是一个interface, 不能定义一个这样的field, 推迟到子类中实现)，每个主题都可以有任意数量的观察者，抽象主题提供一个接口，可以增加、删除、通知集合里的观察者对象
 *               具体主题(SubscriptionSubject)：具体主题将有关状态存入具体观察者对象，在具体主题的内部状态发生改变时，给所有注册过的观察者发送通知
 *               抽象观察者(Observer)：抽象观察者定义了一个更新接口，使得在得到主题更改通知时更新自己
 *               具体观察者(WeiXinUser)：具体观察者实现抽象观察者定义的更新接口，一边在得到主题更改通知时更新自身的状态
 *
 *               优点：降低了主题与观察者之间的耦合关系，两者之间是抽象耦合(Subject和Observer)
 *                    实现了广播机制：主题对象发送通知，所有注册的观察者对象都会收到消息
 *               缺点：如果观察者对象非常多的话，所有的观察者对象都收到主题对象发送的通知会很耗时，最后一个收到的会比较晚
 *                    如果观察者对象有循环依赖的话，主题对象发送通知会使观察者对象循环调用进而导致系统崩溃
 * @Date: 8/16/22
 */

public interface Subject {
    // 添加订阅者(观察者)
    void attach(Observer observer);

    // 删除订阅者(观察者)
    void detach(Observer observer);

    // 通知订阅者(观察者)更新消息
    void notify(String message);
}
