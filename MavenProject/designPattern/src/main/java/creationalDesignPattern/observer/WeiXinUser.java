package creationalDesignPattern.observer;

/**
 * @Author: Flora Zhong
 * @ClassNAme: WeiXinUser
 * @Description: 具体观察者的角色
 * @Date: 8/16/22
 */

public class WeiXinUser implements Observer{
    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);
    }
}
