public class Client {

    public static void main(String[] args) {
        SubscriptionSubject subject = new SubscriptionSubject();

        subject.attach(new User("AAA"));
        subject.attach(new User("BBB"));
        subject.attach(new User("CCC"));

        subject.notify("Thank you for subscribing");
    }
}
