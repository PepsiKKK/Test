package org.example.Java.ThreadTest;

/**
 * 生产者、消费者模式（线程的应用）
 */
public class TestPC {


}

class Provide {
    Transfer transfer;

    public Provide(Transfer transfer) {
        this.transfer = transfer;
    }
}

class Consumer {
    Transfer transfer;

    public Consumer(Transfer transfer) {
        this.transfer = transfer;
    }
}

class Commodity {
    int id;
    public Commodity(int id) {
        this.id = id;
    }
}

class Transfer {
    //最多放10个商品
    Commodity[] commoditys = new Commodity[10];
    int count;

    //添加商品
    public synchronized void add(Commodity commodity){
        //如果满了通知消费者消费，生产者等待
        if (count == commoditys.length) {

        }
        //不满则加入
        commoditys[count] = commodity;
        count++;
    }
    //卖出商品
    public synchronized Commodity pop(){
        //判断是否可以消费
        if (count == 0) {

        }
        count--;
        Commodity commodity = commoditys[count];
        return commodity;
    }

}
