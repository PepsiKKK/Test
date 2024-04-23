package org.example.Java.ThreadTest.syn;

public class TestSynTicket {
    //模拟异步请求
    public static void main(String[] args) throws InterruptedException {
        Ticket ticket = new Ticket();
        while (ticket.flag) {
            new Thread(ticket, "aaa").start();
            new Thread(ticket, "bbb").start();
            new Thread(ticket, "ccc").start();
        }
    }
}

class Ticket implements Runnable{
    int ticketNums = 10;
    boolean flag = true;

    @Override
    public void run() {
        try {
            buyTicket();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private  void buyTicket() throws InterruptedException {

            if (ticketNums <= 0) flag = false;
            System.out.println(Thread.currentThread().getName()+"买了第"+ ticketNums--);
            Thread.sleep(100);

    }
}
