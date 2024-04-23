package org.example.Java.ThreadTest.syn;

import java.util.concurrent.locks.ReentrantLock;

public class TestSynBank {

    public static void main(String[] args) {


        Account account = new Account("mine", 500);

        Bank me = new Bank(account, 300);
        Bank she = new Bank(account, 300);
        new Thread(me, "me").start();
        new Thread(she, "she").start();
    }
}

//账户
class Account{
    String name;
    int money;

    public Account(String name, int money) {
        this.name = name;
        this.money = money;
    }
}

//银行
class Bank implements Runnable{
    Account account;
    int takeHowMany;

    public Bank(Account account, int takeHowMany) {
        this.account = account;
        this.takeHowMany = takeHowMany;
    }

    @Override
    public void run() {
/*        synchronized (account) {
            //取钱的操作
            if (account.money - takeHowMany < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.money = account.money - takeHowMany;
            System.out.println(Thread.currentThread().getName() + "取了" + takeHowMany);
            System.out.println("存款为：" + account.money);
        }*/

        ReentrantLock lock = new ReentrantLock();
        //取钱的操作
        lock.lock();
        try {
            if (account.money - takeHowMany < 0) {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.money = account.money - takeHowMany;
            System.out.println(Thread.currentThread().getName() + "取了" + takeHowMany);
            System.out.println("存款为：" + account.money);
        } finally {
            lock.unlock();
        }

    }

}
