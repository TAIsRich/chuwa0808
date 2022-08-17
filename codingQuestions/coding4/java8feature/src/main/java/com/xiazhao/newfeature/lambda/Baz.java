package com.xiazhao.newfeature.lambda;

public interface Baz {
    default String defaultBaz() {
        String s = "default baz method";
        System.out.println(s);
        return s;
    }

    default String defaultCommon() {
        String s = "defaultCommon baz method";
        System.out.println(s);
        return s;
    }
}
