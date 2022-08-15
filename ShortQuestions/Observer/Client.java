package Observer;

public class Client {
    public static void main(String[] args) {
        SubscriptionSubject mSubscriptionSubject=new SubscriptionSubject();

        WeixinUser user1=new WeixinUser("sunwukong");
        WeixinUser user2=new WeixinUser("zhubajie");
        WeixinUser user3=new WeixinUser("shawujing");
        //订阅公众号
        mSubscriptionSubject.attach(user1);
        mSubscriptionSubject.attach(user2);
        mSubscriptionSubject.attach(user3);

        mSubscriptionSubject.notify("update information");
    }
}
