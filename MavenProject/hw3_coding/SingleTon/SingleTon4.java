package bilbili.coding.SingleTon;

public class SingleTon4 {

    private static SingleTon4 instance;

    private static class singleTon4Holder{
        private static final SingleTon4 INSTANCE = new SingleTon4();
    }

    public static SingleTon4 getInstance(){
      return singleTon4Holder.INSTANCE;
    }
}
