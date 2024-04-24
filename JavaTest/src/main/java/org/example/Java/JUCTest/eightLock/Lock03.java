package org.example.Java.JUCTest.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * 定义一个未同步的hello方法，先打印哪个
 * 由于不是同步方法，不会被锁影响，先执行hello
 */
public class Lock03 {
    public static void main(String[] args) throws InterruptedException {
        Phone03 phone = new Phone03();
        new Thread(()->{
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                phone.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

    }
}

class Phone03{
    public synchronized void sendEmail() throws Exception{
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }
    public synchronized void sendSMS() throws Exception{
        System.out.println("sendSMS");
    }

    public void hello(){
        System.out.println("hello");
    }
}

