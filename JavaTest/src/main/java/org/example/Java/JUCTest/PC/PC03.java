package org.example.Java.JUCTest.PC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 这次按顺序实现A-》B-》C
 */
public class PC03 {
    public static void main(String[] args) {
        Resources resources = new Resources();
        new Thread(()->{
            for (int i = 1; i <=3; i++) {
                resources.printA();
            }
        },"AA").start();
        new Thread(()->{
            for (int i = 1; i <=3; i++) {
                resources.printB();
            }
        },"BB").start();
        new Thread(()->{
            for (int i = 1; i <=3; i++) {
                resources.printC();
            }
        },"CC").start();

    }
}

class Resources {
    private int number = 1;
    //使用Condition操作ABC
    private final Lock lock = new ReentrantLock();
    private final Condition c1 = lock.newCondition();
    private final Condition c2 = lock.newCondition();
    private final Condition c3 = lock.newCondition();

    public void printA(){
        lock.lock();
        try {
            while (number != 1) {
                c1.await();
            }
            for (int i = 0; i < 1; i++) {
                System.out.println(Thread.currentThread().getName()+'\t'+i);
            }
            //通知B
            number = 2;
            c2.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB(){
        lock.lock();
        try {
            while (number != 2) {
                c2.await();
            }
            for (int i = 0; i < 2; i++) {
                System.out.println(Thread.currentThread().getName()+'\t'+i);
            }
            //通知C
            number = 3;
            c3.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC(){
        lock.lock();
        try {
            while (number != 3) {
                c3.await();
            }
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+'\t'+i);
            }
            //通知C
            number = 1;
            c1.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
