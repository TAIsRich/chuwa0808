package com.xiazhao.newfeature.default_interface_method;

public class Client {
    public static void main(String[] args) {
        DimlImpl diml = new DimlImpl();
        System.out.println("override method: " + diml.add(2, 3));
        System.out.println("default method: " + diml.substract(3, 4));
        System.out.println("static method: " + Diml.blogName());
    }
}
