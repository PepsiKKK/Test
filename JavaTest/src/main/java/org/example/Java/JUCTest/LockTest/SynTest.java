package org.example.Java.JUCTest.LockTest;

/**
 * 三个售票员
 * 使用synchronized
 */
public class SynTest {
    public static void main(String[] args) {
        Ticket1 t = new Ticket1();
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    t.sale();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "A").start();        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    t.sale();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "B").start();        new Thread(() -> {
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

class Ticket1 {
    private int number = 30;

    public synchronized void sale() throws InterruptedException {
        if (number > 0) {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + number--);
            Thread.sleep(100);
        } else {
            System.out.println("票卖完了");
        }

    }
}

