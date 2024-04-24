package org.example.Java.JUCTest.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * 一个普通同步 方法，一个静态同步方法，两部手机
 * 不是同一个锁
 *
 */
public class Lock08 {
    public static void main(String[] args) throws InterruptedException {
        Phone08 phoneAA = new Phone08();
        Phone08 phoneBB = new Phone08();
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
                Phone08.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

    }
}

class Phone08{
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

