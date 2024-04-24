package org.example.Java.JUCTest.PC;

/**
 * 生产者消费者模式
 * synchronized版
 *
 * 两个线程，对一个
 */
public class PC01 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(() -> {
            try {
                for (int i = 0; i < 11; i++) {
                    data.increment();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "A").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "B").start();
    }
}

/**
 * 资源类
 */
class Data {
    private int number = 0;
    public synchronized void increment() throws InterruptedException {
        // 不等于0时，不用增加，等待
        while (number >= 10) this.wait();
        // 等于0时，进行加一，并通知
        number++;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
        Thread.sleep(100);
    }

    public synchronized void decrement() throws InterruptedException {
        // 不等于0时，不用增加，等待
        while (number == 0) this.wait();
        // 等于0时，进行加一，并通知
        number--;
        System.out.println(Thread.currentThread().getName()+"\t"+number);
        this.notifyAll();
        Thread.sleep(100);
    }
}
