package org.example.Java.ThreadTest;

public class Test01 extends Thread{
    @Override
    public void run() {
        print(10);
    }

    private void print(int n){
        for (int i = 0; i < n; i++) {
            System.out.println("线程一:" + i);
        }
    }
}
