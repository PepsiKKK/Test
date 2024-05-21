package org.example.Java.JUCTest.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreeMethod {

    /**
     * 三大方法
     * Executors.newSingleThreadExecutor(); 创建一个只有一个线程的线程池
     * Executors.newFixedThreadPool(5); 创建一个有n个线程的线程池
     * Executors.newCachedThreadPool(); 执行很多短期异步任务，线程池根据需要进行创建新线程，
     *      但在先构建的线程可用时将重用他们。扩容，遇强则强
     */
    public static void main(String[] args) {
        ExecutorService pool01 = Executors.newSingleThreadExecutor();
        Single();

        ExecutorService pool02 = Executors.newFixedThreadPool(5);
        Fixed();

        ExecutorService pool03 = Executors.newCachedThreadPool();
        Cached();
    }

    public static void Single(){
        //有且仅有一个固定的线程
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //模拟10个顾客，只有一个窗口
        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"来了");
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }

    public static void Fixed(){
        //池子大小为5
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"来了");
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }

    public static void Cached(){
        //可扩容，遇强则强
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"来了");
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            threadPool.shutdown();
        }
    }
}
