package com.xiazhao.newfeature.lambda;

@FunctionalInterface
public interface Bar {
    String method(String string);

    default String defaultBar() {
        String s = "default bar method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "defaultCommon from bar";
        System.out.println(s);
        return s;
    }
}
