package org.example.DataStructure.LinkedList;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MySingleLinkedListTest {

    MySingleLinkedList mySingleLinkedList = new MySingleLinkedList();
    @Test
    public void test01() {
        mySingleLinkedList.addAtTail(1);
        mySingleLinkedList.addAtTail(2);
        mySingleLinkedList.addAtTail(3);
        System.out.println(Arrays.toString(mySingleLinkedList.getAll())); // [1, 2, 3]
        System.out.println(mySingleLinkedList.get(1)); // 2
        mySingleLinkedList.addAtHead(4);
        System.out.println(Arrays.toString(mySingleLinkedList.getAll())); // [4, 1, 2, 3]
        mySingleLinkedList.addAtIndex(1, 100);
        System.out.println(Arrays.toString(mySingleLinkedList.getAll())); // [4, 100, 1, 2, 3]
        mySingleLinkedList.deleteAtIndex(1);
        System.out.println(Arrays.toString(mySingleLinkedList.getAll())); // [4, 1, 2, 3]
    }

}