package PublisherSubscriber.observer;

public class Client {

    public static void main(String[] args){

        //1.创建公众号对象
        SubscriptionSubjects subject = new SubscriptionSubjects();

        //2.订阅公众号
        subject.attach(new weiXinUser("孙悟空"));
        subject.attach(new weiXinUser("猪悟能"));
        subject.attach(new weiXinUser("沙悟净"));

        //3. 公众号更新，发出消息给订阅者（观察者对象
        subject.notify("某某专栏更新了!");


    }
}
