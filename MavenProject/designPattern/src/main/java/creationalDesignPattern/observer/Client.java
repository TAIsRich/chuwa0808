package creationalDesignPattern.observer;

public class Client {
    public static void main(String[] args) {
        // 创建公众号对象
        Subject subject = new SubscriptionSubject();

        // 添加对订阅者
        WeiXinUser apple = new WeiXinUser("apple");
        WeiXinUser peach = new WeiXinUser("peach");
        WeiXinUser melon = new WeiXinUser("melon");
        subject.attach(apple);
        subject.attach(peach);
        subject.attach(melon);

        // 公众号更新，发出消息给订阅者
        subject.notify("I will pick you.");

        // 删除订阅者
        subject.detach(melon);
        subject.notify("Melon has found a SDE job, and you are our candidates now.");
    }
}
