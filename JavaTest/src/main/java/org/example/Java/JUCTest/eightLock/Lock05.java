package org.example.Java.JUCTest.eightLock;

import java.util.concurrent.TimeUnit;

/**
 * 都是静态方法的话，使用的也是同一个class，因此是同一个锁
 */
public class Lock05 {
    public static void main(String[] args) throws InterruptedException {
        //Phone05 phone = new Phone05();
        new Thread(()->{
            try {
                Phone05.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                Phone05.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();

        Thread.sleep(200);
        new Thread(()->{
            try {
                Phone05.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"C").start();

    }
}

class Phone05{
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

