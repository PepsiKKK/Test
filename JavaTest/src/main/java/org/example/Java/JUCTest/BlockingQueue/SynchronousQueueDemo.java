package org.example.Java.JUCTest.BlockingQueue;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueDemo {

    public static void main(String[] args) {
        /**
         * 正常是队列put三次后队出，但这里是一次一次put、take
         */
        BlockingQueue<String> queue = new SynchronousQueue<>();
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName()+" put A");
                queue.put("A");
                System.out.println(Thread.currentThread().getName()+" put B");
                queue.put("B");
                System.out.println(Thread.currentThread().getName()+" put C");
                queue.put("C");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread01").start();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" => "+queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" => "+queue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+" => "+queue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "Thread02").start();
    }
}
