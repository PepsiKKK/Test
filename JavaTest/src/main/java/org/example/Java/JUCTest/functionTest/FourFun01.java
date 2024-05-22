package org.example.Java.JUCTest.functionTest;

import java.util.function.Function;

/**
 * 函数式接口01：
 * Function<T, R> 函数型接口
 * R apply(T t); 传入T，返回R
 */
public class FourFun01 {

    public static void main(String[] args) {
        //传统创建
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 1024;
            }
        };
        //lambda
        Function<String, Integer> functionLambda = (s) -> 1024;
        /*
        几种Lambda写法
        s -> 1024
        s -> {return 1024;}
        (s) -> {return 1024;}
         */
        System.out.println(function.apply("aaa"));
    }
}
