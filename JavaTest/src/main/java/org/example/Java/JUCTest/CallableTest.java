package org.example.Java.JUCTest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //线程对象
        MyThread myThread = new MyThread();
        //适配类
        FutureTask<Integer> futureTask = new FutureTask<>(myThread);
        //启动线程
        new Thread(futureTask, "A").start();
        //获取返回值
        Integer i = futureTask.get();

        System.out.println(i);
    }

}
class MyThread implements Callable<Integer> {
    /**
     * 泛型为需要的返回值类型
     * @return
     * @throws Exception
     */
    @Override
    public Integer call() throws Exception {
        System.out.println("call()");
        return 1024;
    }
}
