import java.util.ArrayList;
import java.util.List;

public class SubscriptionSubject implements Subject{

    private List<Observer> subscriber = new ArrayList<>();

    @Override
    public void attach(Observer observer) {
        subscriber.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        subscriber.remove(observer);
    }

    @Override
    public void notify(String message) {
        for (Observer observer : subscriber) {
            observer.update(message);
        }
    }
}
