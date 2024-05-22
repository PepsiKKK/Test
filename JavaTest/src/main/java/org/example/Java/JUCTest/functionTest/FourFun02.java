package org.example.Java.JUCTest.functionTest;

import java.util.function.Predicate;

/**
 * 函数式接口02：
 * Predicate<T> 断定型接口
 * boolean test(T t); 传入T，返回boolean
 */
public class FourFun02 {

    public static void main(String[] args) {
        //传统创建
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };
        //lambda
        Predicate<String> predicateLambda = s -> false;

        System.out.println(predicate.test("aaa"));
        System.out.println(predicateLambda.test("bbb"));
    }
}
