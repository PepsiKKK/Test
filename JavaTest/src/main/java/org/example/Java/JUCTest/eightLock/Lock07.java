package org.example.Java.JUCTest.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * 一个普通方法，一个静态同步方法，同一部手机
 *
 */
public class Lock07 {
    public static void main(String[] args) throws InterruptedException {
        Phone07 phoneAA = new Phone07();
        new Thread(()->{
            try {
                phoneAA.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                phoneAA.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

    }
}

class Phone07{
    public static synchronized void sendEmail() throws Exception{
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    public synchronized void hello(){
        System.out.println("hello");
    }
}

