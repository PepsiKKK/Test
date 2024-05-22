package org.example.Java.JUCTest.functionTest;

import java.util.function.Supplier;

/**
 * 函数式接口04：
 * Supplier<T> 供给型接口
 * T get(); 无传入，返回T
 */
public class FourFun04 {

    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "aaa";
            }
        };
        Supplier<String> supplierLambda = () -> {
            return "aaa";
        };

        System.out.println(supplier.get());
        System.out.println(supplierLambda.get());
    }
}
