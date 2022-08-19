package com.xiazhao.newfeature.default_interface_method;

public interface Diml {
    static final String BLOG = "is Chuwa a";

    int add(int a, int b);

    default int substract(int a, int b) {
        return a - b;
    }

    static String blogName() {
        return BLOG;
    }
}
