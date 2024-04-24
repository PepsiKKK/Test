package org.example.Java.JUCTest.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * 邮件方法暂停4秒后，先打印哪个
 * 调用者是同一个，所以是同一个锁，先调用的先执行
 */
public class Lock02 {
    public static void main(String[] args) throws InterruptedException {
        Phone02 phone = new Phone02();
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

    }
}

class Phone02{
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
}

