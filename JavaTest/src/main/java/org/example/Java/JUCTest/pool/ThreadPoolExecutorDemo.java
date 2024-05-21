package org.example.Java.JUCTest.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {

    private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 10;
    private static final Long KEEP_ALIVE_TIME = 1L;

    public static void main(String[] args) {

        // 创建线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(QUEUE_CAPACITY),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());

        //创建线程运行
        try {
            for (int i = 0; i < 13; i++) {
                int finalI = i;
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "运行了" + finalI);
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //关闭线程池
            threadPoolExecutor.shutdown();
        }
    }
}
