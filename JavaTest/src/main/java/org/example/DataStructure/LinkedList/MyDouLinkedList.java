package org.example.DataStructure.LinkedList;

public class MyDouLinkedList {
    int size;
    DouListNode head;
    DouListNode tail;

    /**
     * 构造器的定义
     */
    public MyDouLinkedList() {
        size = 0;
        head = new DouListNode(0);
        tail = new DouListNode(0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        DouListNode curr;
        if (index + 1 < size - index) {
            curr = head;
            for (int i = 0; i <= index; i++) {
                curr = curr.next;
            }
        } else { //添加else比较从头还是尾遍历哪个比较快
            curr = tail;
            for (int i = 0; i < size - index; i++) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        //若小于0从头部增加
        index = Math.max(0, index);
        DouListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index; i++) {
                succ = succ.prev;
            }
            pred = succ.prev;
        }
        size++;
        DouListNode toAdd = new DouListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        DouListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            succ = pred.next.next;
        } else {
            succ = tail;
            for (int i = 0; i < size - index - 1; i++) {
                succ = succ.prev;
            }
            pred = succ.prev.prev;
        }
        size--;
        pred.next = succ;
        succ.prev = pred;
    }



}

class DouListNode {
    int val;
    DouListNode prev;
    DouListNode next;

    public DouListNode(int val) {
        this.val = val;
    }

    public DouListNode(int val, DouListNode prev, DouListNode next) {
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}
