package observer;

import java.util.*;

public class ConcreteSubject implements Subject{

    List<Observer> listOfObserver = new ArrayList<Observer>();

    public void attach(Observer b) {
        listOfObserver.add(b);
    }

    public void detach(Observer b) {
        listOfObserver.remove(b);
    }

    public void notify(String msg) {
        for(Observer ob : listOfObserver){
            ob.update(msg);
        }
    }
}