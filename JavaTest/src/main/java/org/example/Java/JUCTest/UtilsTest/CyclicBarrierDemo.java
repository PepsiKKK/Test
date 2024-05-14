package org.example.Java.JUCTest.UtilsTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

    /**
     * CyclicBarrier：篱栅
     * 与CountDownLatch相反，这个是加法计数器
     */
    public static void main(String[] args) {

        //累计执行完7个线程之后就会运行这个线程
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("success");
        });

        for (int i = 0; i < 7; i++) {
            int finalI = i;
            new Thread(() -> {
                System.out.println("第"+ (finalI + 1) +"次召唤");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }

    }
}
