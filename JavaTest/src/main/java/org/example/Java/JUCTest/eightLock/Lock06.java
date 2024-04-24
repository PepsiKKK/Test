package org.example.Java.JUCTest.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * 两个静态方法，两部手机
 * 都是静态方法，不看手机，都是为同一个对象，同一个锁
 */
public class Lock06 {
    public static void main(String[] args) throws InterruptedException {
        Phone06 phoneAA = new Phone06();
        Phone06 phoneBB = new Phone06();
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
                phoneBB.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                Phone06.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

    }
}

class Phone06{
    public static synchronized void sendEmail() throws Exception{
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }
    public static synchronized void sendSMS() throws Exception{
        System.out.println("sendSMS");
    }

    public static void hello(){
        System.out.println("hello");
    }
}

