package com.xiazhao.newfeature.optional;

import com.sun.istack.internal.NotNull;
import org.junit.jupiter.api.Test;

import javax.annotation.Nullable;
import java.util.Optional;

public class OptionalTest {
    @NotNull
    Node<String> node = new Node<>();

    @Test()
    public void testOptionalWithNotHandleException() {
        Optional<Node> optional = Optional.of(node);
//        Optional<Node> optional1 = Optional.ofNullable(node);
    }

    @Test()
    public void test1() {
        Node node1 = new Node();
        Optional<Node> optional = Optional.of(node1);
        //node1 = null;
        Optional<Node> optional1 = Optional.of(node1);
    }

    @Test
    public void testOfNullable() {
        Node node = new Node();
        Optional<Node> optional = Optional.ofNullable(node);
        System.out.println(optional.get().data);

        node = null;
        Optional<Node> optional1 = Optional.ofNullable(node);
        System.out.println(optional1);
    }

    @Test
    public void testOrElse() {
        Node node = new Node();
        Optional<Node> optional = Optional.ofNullable(node);
        System.out.println(optional.get().data);

        node = null;
        Optional<Node> optional1 = Optional.ofNullable(node);
        System.out.println(optional);

        Node node3 = Optional.ofNullable(node).orElse(new Node());
        node3.setData("hello");
        System.out.println(node3.data);
    }

    private class Node<String> {
        private String data;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }

}
