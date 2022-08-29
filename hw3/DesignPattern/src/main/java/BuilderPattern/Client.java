package BuilderPattern;

import BuilderPattern.Director;
import BuilderPattern.HuaweiBuilder;
import BuilderPattern.Phone;

public class Client {

    public static void main(String[] args) {
        // Director director = new Director(new IphoneBuilder());
        // 想要换Huawei啦 只需要换成HuaweiBuilder 即可，而不需要修改其他代码
        Director director = new Director(new HuaweiBuilder());
        Phone phone = director.construct();
        System.out.println(phone);
    }
}