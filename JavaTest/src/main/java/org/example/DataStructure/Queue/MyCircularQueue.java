package org.example.DataStructure.Queue;

import java.util.ArrayList;

/**
 * 循环队列：数组实现
 * 一个循环数组只能有n-1个队列元素
 */
public class MyCircularQueue {
    int[] arr; // 一个固定的数组，用于存放队列元素
    int n; // 循环队列的最大容量，可容纳元素的数量
    int front; // 队列首元素的数组索引
    int rear; // 队列尾元素的索引的下一个索引

    public MyCircularQueue(int k) {
        n = k + 1;
        arr = new int[n];
        rear = front = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        arr[rear] = value;
        rear = (rear + 1) % n;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % n;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return arr[(rear - 1 + n) % n];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return ((rear + 1) % n) == front;
    }
}
