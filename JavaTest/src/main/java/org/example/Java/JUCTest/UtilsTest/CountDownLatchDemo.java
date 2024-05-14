package org.example.Java.JUCTest.UtilsTest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    /**
     * CountDownLatch两个主要的方法：
     * 调用await的线程会阻塞
     * 调用CountDown方法会将计数器-1，并不会被阻塞
     * await会当计数器变为0时，唤醒当前线程
     */
    public static void main(String[] args) throws InterruptedException {
        //CountDownLatch是一个减法计数器 一个参数：为线程的个数
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            //创建线程
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"开启了");
                //计数器-1
                countDownLatch.countDown();
            }, String.valueOf(i+1)).start();
        }
        //阻塞等待计数器归零
        countDownLatch.await();
        //目的：为了达到最后输出“main结束了”（否则结果诡异）
        System.out.println(Thread.currentThread().getName()+"结束了");
    }
}
