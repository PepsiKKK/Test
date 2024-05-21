package org.example.Java.JUCTest.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Demo01 {

    /**
     * 测试BlockingQueue四种API
     */
    public static void main(String[] args) throws InterruptedException {
//        throwException01();
//        returnValue02();
//        alwaysBlocking03();
        exitOverTime04();
    }

    public static void throwException01(){
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("a"));
        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        blockingQueue.remove();
        //Exception in thread "main" java.util.NoSuchElementException
    }

    public static void returnValue02(){
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("a"));
        //true  false
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        //true false
    }

    public static void alwaysBlocking03() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        //阻塞

        blockingQueue.take();
    }

    public static void exitOverTime04() throws InterruptedException {
        BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
        blockingQueue.offer("a", 3, TimeUnit.SECONDS);
        blockingQueue.offer("a", 3, TimeUnit.SECONDS);
        blockingQueue.offer("a", 3, TimeUnit.SECONDS);
        blockingQueue.offer("a", 3, TimeUnit.SECONDS);
        blockingQueue.poll(3, TimeUnit.SECONDS);
        blockingQueue.poll(3, TimeUnit.SECONDS);
        blockingQueue.poll(3, TimeUnit.SECONDS);
    }
}
