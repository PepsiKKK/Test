package org.example.Java.JUCTest.LockTest;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量，读取共享资源应该可以同时进行。
 * 但是，如果有一个线程想去写共享资源，就不应该再有其他线程可以对该资源进行读或写。
 * 1. 读-读 可以共存
 * 2. 读-写 不能共存
 * 3. 写-写 不能共存
 *
 * 独占锁（写锁）：一次只能一个线程占有
 * 共享锁（读锁）：多个线程可以同时占有
 */
public class ReadWriteLockDemo {
    public static void main(String[] args) {
        MyCacheLock myCacheLock = new MyCacheLock();
        //写的操作
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCacheLock.put(finalI + "", finalI + "");
            }, String.valueOf(i)).start();
        }
        //读的操作
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            new Thread(() -> {
                myCacheLock.get(finalI + "");
            }, String.valueOf(i)).start();
        }
    }
}

class MyCacheLock{
    //模拟读写缓存操作
    private volatile Map<String, Object> map = new HashMap<>();
    //创建一个读写锁
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    //写的操作
    public void put(String key, Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写入"+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName()+"写入成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读取"+key);
            map.get(key);
            System.out.println(Thread.currentThread().getName()+"读取成功");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

}
