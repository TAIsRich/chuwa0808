package bilbili.coding.SingleTon;

public class Main {
    public static void main(String[] args) {

        SingleTon instance = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();

        System.out.println(instance == instance2);
    }
}
