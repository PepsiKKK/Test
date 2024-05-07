package org.example.Java.JUCTest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 不安全的集合以及解决方法
 */
public class UnsafeCol {

    public static void main(String[] args) {
        //unsafeList();
        //unsafeSet();
        unsafeMap();
    }

    public static void unsafeList(){
        //原本 new ArrayList<>()，解决方案：三种
        List<String> list = new Vector<>();
        List<String> list2 = Collections.synchronizedList(new ArrayList<>());
        List<String> list3 = new CopyOnWriteArrayList<>();

        //模拟线程
        for (int i = 0; i < 30; i++) {
            int finalInt = i;
            new Thread(() -> {
                list3.add(String.valueOf(finalInt * 10));
                System.out.println(list3);
            }, String.valueOf(i)).start();
        }
    }

    public static void unsafeSet(){
        //原本 new ArrayList<>()，解决方案：三种
        Set<String> set = Collections.synchronizedSet(new HashSet<>());
        Set<String> set2 = new CopyOnWriteArraySet<>();

        //模拟线程
        for (int i = 0; i < 30; i++) {
            int finalInt = i;
            new Thread(() -> {
                set2.add(String.valueOf(finalInt * 10));
                System.out.println(set2);
            }, String.valueOf(i)).start();
        }
    }

    public static void unsafeMap(){
        //hashMap底层是 数组+链表+红黑树
        Map<String,String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            int finalI = i;
            new Thread(()->{
                map.put(Thread.currentThread().getName(), String.valueOf(finalI));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
}
