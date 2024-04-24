package org.example.Java.JUCTest.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * 两部手机，什么顺序
 * 两个方法不是用同一个锁，后面调用的方法不需要等待前面的方法
 */
public class Lock04 {
    public static void main(String[] args) throws InterruptedException {
        Phone04 phoneAAA = new Phone04();
        Phone04 phoneBBB = new Phone04();
        //AAA
        new Thread(()->{
            try {
                phoneAAA.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"phoneAAA").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                phoneBBB.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"phoneBBB").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                phoneAAA.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"phoneAAA").start();

    }
}

class Phone04{
    public synchronized void sendEmail() throws Exception{
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " sendEmail");
    }
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getName() + " sendSMS");
    }

    public void hello(){
        System.out.println(Thread.currentThread().getName() + " hello");
    }
}

