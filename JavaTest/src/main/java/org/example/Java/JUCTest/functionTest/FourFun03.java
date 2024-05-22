package org.example.Java.JUCTest.functionTest;

import java.util.function.Consumer;

/**
 * 函数式接口03：
 * Consumer<T> 消费型接口
 * void accept(T t); 传入T，无返回
 */
public class FourFun03 {

    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String o) {
                System.out.println("没有返回值，这是自己输出");
            }
        };
        Consumer<String> consumerLambda = o -> {
            System.out.println("没有返回值，这是自己输出");
        };

        consumer.accept("aaa");
        consumerLambda.accept("aaa");
    }
}
