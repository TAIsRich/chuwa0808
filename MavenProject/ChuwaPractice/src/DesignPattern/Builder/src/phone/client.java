package phone;

import jdk.nashorn.internal.runtime.arrays.IntElements;

public class client {

    Phone phone = new Phone.Builder()
            .cpu("Intel")
            .screen("Apple")
            .mainboard("Mainboard")
            .memory("Kingston")
            .build();
}
