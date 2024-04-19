package org.example.Java.ThreadTest;

public class Main {

    public static void main(String[] args) {

/*        Test01 test01 = new Test01();
        test01.start();*/

        Test02 test02 = new Test02();
/*        Thread thread = new Thread(test02);
        thread.start();*/

        new Thread(test02, "第一个").start();
        new Thread(test02, "第二个").start();
        new Thread(test02, "第三个").start();

        //主线程：
        for (int i = 0; i < 10; i++) {
            System.out.println("主线程：" + i);
        }


    }
}
