package org.example.DataStructure.LinkedList;


public class MySingleLinkedList {

    int size;
    ListNode head;

    public MySingleLinkedList() {
        //相当与头节点没有存放数据，也就是没有头
        size = 0;
        head = new ListNode(0);
    }

    /**
     * 根据下标获取节点
     * @param index 
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.data;
    }

    public int[] getAll() {
        int[] res = new int[size];
        ListNode pred = this.head;
        for (int i = 0; i < size; i++) {
            res[i] = pred.next.data;
            pred = pred.next;
        }
        return res;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        //大于长度，无法添加
        if (index > size) {
            return;
        }
        //小于长度，在链表头部添加
        index = Math.max(0, index);
        //需要对链表进行遍历，找到添加处
        size += 1;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode newNode = new ListNode(val);
        //理解：先尊重别人才可以得到别人的尊重
        newNode.next = pred.next;
        pred.next = newNode;

    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        //将上一个节点指向下一个节点
        pred.next = pred.next.next;

    }
}

/**
 * 定义内部节点类
 */
class ListNode {
    /**
     * 节点数据
     */
    int data;

    /**
     * 下一个节点指针
     */
    ListNode next;

    /**
     * 参数构造器
     * @param data
     */
    public ListNode(int data) {
        this.data = data;
    }
    public ListNode(int data, ListNode next) {
        this.data = data;
        this.next = next;
    }

}
