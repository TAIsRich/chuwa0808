package pattern.singleton.demo1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Client {

    public static void main(String[] args) throws Exception {
        readObjectFromFile();
        readObjectFromFile();
    }

    public static void readObjectFromFile() throws Exception {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Think\\Desktop\\a.txt"));
        Singleton instance = (Singleton) ois.readObject();

        System.out.println(instance);

        ois.close();
    }

    public static void writeObject2File() throws Exception {
        Singleton instance = Singleton.getInstance();
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Think\\Desktop\\a.txt"));
        oos.writeObject(instance);

        oos.close();
    }

}
