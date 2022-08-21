package creationalDesignPattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Flora Zhong
 * @ClassNAme: SubscriptionSubject
 * @Description: 具体主题的角色
 * @Date: 8/16/22
 */

public class SubscriptionSubject implements Subject{
    // 定义一个集合，用来存储多个观察者对象
    private List<Observer> weiXinUserList = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : weiXinUserList) {
            // 调用观察这对象的update方法
            observer.update(message);
        }
    }
}
