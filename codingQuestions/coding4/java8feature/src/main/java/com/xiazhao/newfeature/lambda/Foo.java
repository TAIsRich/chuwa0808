package com.xiazhao.newfeature.lambda;

@FunctionalInterface
public interface Foo extends Bar, Baz {

    @Override
    default String defaultCommon() {
//        return Baz.super.defaultCommon();
        String s = "defaultCommon from Foo";
        System.out.println(s);
        return s;
    }
}
