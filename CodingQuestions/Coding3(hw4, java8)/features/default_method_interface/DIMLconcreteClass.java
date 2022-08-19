public class DIMLconcreteClass implements DIML {
    @Override
    public int add(int a, int b) {
        System.out.println("test super: " + DIML.super.substract(a, b));
        return a + b;
    }
}
