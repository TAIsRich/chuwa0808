import builder.Bike;
import builder.Director;
import builder.MobileBuilder;
import factory.AmericanCoffeeFactory;
import factory.Coffee;
import factory.CoffeeFactory;
import factory.CoffeeStore;
import observer.ConcreteObserver;
import observer.ConcreteSubject;
import observer.Observer;
import observer.Subject;
import singleton.Singleton;

public class test {
    public static void main(String[] args){
        //Singleton
        System.out.println("-----SingletonSingletonSingleton-----");
        Singleton s1 =  Singleton.getInstance();
        Singleton s2 =  Singleton.getInstance();
        System.out.println(s1 == s2);
        System.out.println("-----SingletonSingletonSingleton-----");


        System.out.println("-----FactoryFactoryFactoryFactory-----");
        CoffeeStore cs = new CoffeeStore();
        CoffeeFactory factory = new AmericanCoffeeFactory();
        cs.setCoffeeFactory(factory);
        

        Coffee c = cs.orderCoffee();
        System.out.println(c.getMsg());
        System.out.println("-----FactoryFactoryFactoryFactory-----");



        System.out.println("-----BuilderBuilderBuilderBuilder-----");
        Director d = new Director(new MobileBuilder());
        Bike b = d.consBike();

        System.out.println(b.getFrame());
        System.out.println(b.getSeat());
        System.out.println("-----BuilderBuilderBuilderBuilder-----");

        System.out.println("-----ObserverObserverObserverObserver-----");
        Subject subject = new ConcreteSubject();
        Observer user1 = new ConcreteObserver("Yilin Zhou");
        Observer user2 = new ConcreteObserver("Jiahui Wang");

        subject.attach(user1);
        subject.attach(user2);
        subject.notify(" you get married");





        System.out.println("-----ObserverObserverObserverObserver-----");




        
    }
}
