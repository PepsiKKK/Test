package org.example.Java.JUCTest.LockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个售票员
 * 使用ReentrantLock
 */
public class LockTest {
    public static void main(String[] args) {
        Ticket2 t = new Ticket2();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    t.sale();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    t.sale();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    t.sale();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "C").start();
    }
}

class Ticket2 {
    private int number = 30;

    private final Lock lock = new ReentrantLock();

    public void sale() throws InterruptedException {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + number--);
                Thread.sleep(100);
            } else {
                System.out.println("票卖完了");
            }
        } finally {
            lock.unlock();
        }

    }
}

