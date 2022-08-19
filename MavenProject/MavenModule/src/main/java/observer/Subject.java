package observer;

public interface Subject {
    void attach(Observer b);

    void detach(Observer b);

    void notify(String msg);
}
