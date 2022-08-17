package PublisherSubscriber.observer;

//具体的观察者角色类

public class weiXinUser implements Observer{

    private String name;

    public weiXinUser(String name) {
        this.name = name;
    }

    public void update(String message){
        System.out.println(name + "-" + message);
    }
}
