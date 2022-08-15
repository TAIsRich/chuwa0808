package singletondemo3;

public class Singleton {
    private Singleton(){}
    private static  Singleton instance;

   public static synchronized Singleton getInstance(){

       if(instance == null) {
           instance = new Singleton();
       }
       instance = new Singleton();
       return instance;
   }
}
