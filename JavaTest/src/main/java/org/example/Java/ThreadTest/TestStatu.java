package org.example.Java.ThreadTest;

public class TestStatu {

    public static void main(String[] args) throws InterruptedException {
        //新建线程
        Thread thread = new Thread(() -> {
            //该创建线程的lambda相当于run()
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + i);
            }
        }, "lambda创建的线程");

        //新建状态
        Thread.State state = thread.getState();
        System.out.println(state);

        //就绪状态
        thread.start();
        state = thread.getState();
        System.out.println(state);

        //销毁状态
        Thread.sleep(1000);
        state = thread.getState();
        System.out.println(state);

        int maxPriority = Thread.MAX_PRIORITY; // 10
        int normPriority = Thread.NORM_PRIORITY; // 5
        int minPriority = Thread.MIN_PRIORITY; // 1


    }
}
