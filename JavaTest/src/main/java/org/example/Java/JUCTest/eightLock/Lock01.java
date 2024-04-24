package org.example.Java.JUCTest.eightLock;

/**
 * 标准访问 先打印哪个
 * 结论：被synchronized修饰的方法，锁的对象是方法的调用者。
 * 因为两个方法的调用者是同一个，所以两个方法用的是同一个锁，先调用方法的先执行。
 */
/*
* 问题汇总：：
* 多线程的8锁
* 1、标准访问，请问先打印邮件还是短信？
* 2、邮件方法暂停4秒钟，请问先打印邮件还是短信？
* 3、新增一个普通方法hello()没有同步,请问先打印邮件还是hello？
* 4、两部手机、请问先打印邮件还是短信？
* 5、两个静态同步方法，同一部手机，请问先打印邮件还是短信？
* 6、两个静态同步方法，2部手机，请问先打印邮件还是短信？
* 7、一个普通同步方法，一个静态同步方法，同一部手机，请问先打印邮件还是短信？
* 8、一个普通同步方法，一个静态同步方法，2部手机，请问先打印邮件还是短信？
* */
public class Lock01 {
    public static void main(String[] args) throws InterruptedException {
        Phone01 phone = new Phone01();
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

class Phone01{
    public synchronized void sendEmail() throws Exception{
        System.out.println("sendEmail");
    }
    public synchronized void sendSMS() throws Exception{
        System.out.println("sendSMS");
    }
}
