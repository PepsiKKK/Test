package org.example.Java.JUCTest.PC;

/**
 * 生产者消费者：使用lock和Condition
 * 卖商品的案例
 * 多线程中，为了防止多线程的虚假唤醒，判断不使用if使用while
 */
// TODO: 2024/4/23 不理解为什么不行，跟PC01相比
public class PC02 {
    public static void main(String[] args) {
        Reception reception = new Reception();
        Provide provide = new Provide();
        Customer customer = new Customer();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    provide.add(reception);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "provide").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    customer.buy(reception);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "customer").start();
    }
}

class Reception {
    final int MAX_NUM = 10;
    int count = 0;

}
class Provide {
    public synchronized void add(Reception reception) throws InterruptedException {
        while (reception.count >= reception.MAX_NUM) {
            System.out.println("生产者" + Thread.currentThread().getName() + "，仓库已满");
            this.wait();
        }
        reception.count++;
        System.out.println("生产了，剩余" + reception.count);
        this.notifyAll();
        Thread.sleep(100);
    }
}

class Customer {
    public synchronized void buy(Reception reception) throws InterruptedException {
        while (reception.count == 0) {
            System.out.println("消费者" + Thread.currentThread().getName() + "，仓库为空");
            this.wait();
        }
        reception.count--;
        System.out.println("消费者" + "，还剩" + reception.count);
        this.notifyAll();
        Thread.sleep(100);
    }
}


