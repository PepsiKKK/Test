package org.example.Java.ThreadTest;

public class TestSleep {

    public static void main(String[] args) throws InterruptedException {
        //表示当前线程阻塞1s
        Sleep sleep = new Sleep();



        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }

        new Thread(sleep).start();
    }
}

class Sleep implements Runnable{

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            sleep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }

    }
    private void sleep(){
        System.out.println("睡觉");
    }

}
