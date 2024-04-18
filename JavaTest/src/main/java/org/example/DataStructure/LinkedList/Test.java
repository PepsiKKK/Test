package org.example.DataStructure.LinkedList;

import java.util.List;
import java.util.Stack;

public class Test {

    /**
     * 反转链表（最基础）
     * @param head
     * @return
     */
    public ListNode reverseList01(ListNode head) {
        //第一种，使用栈解决
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        if (stack.isEmpty()) return null;
        //创建一个指针
        ListNode node = stack.pop();
        ListNode res = node;
        while (!stack.isEmpty()) {
            ListNode temp = stack.pop();
            node.next = temp;
            node = node.next;
        }
        node.next = null;
        return res;
    }

    public ListNode reverseList02(ListNode head) {
        //第二种，双链表
        ListNode newNode = null;
        while (head != null) {
            //先保存下一个节点的数据
            ListNode next = head.next;
            //将原链表当前的头指向新的头
            head.next = newNode;
            //将缓过来的节点作为新链表的头
            newNode = head;
            //将原链表的头设置为下一个节点
            head = next;
        }
        return newNode;
    }

    /**
     * 移除链表元素
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode pre = new ListNode(0, head);
        ListNode temp = pre;
        while (temp.next != null) {
            if (temp.next.data == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head.next;
    }

    /**
     * 回文链表
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        //使用栈解决
        ListNode pre = head;
        Stack<Integer> stack = new Stack<>();
        while (pre!= null) {
            stack.push(pre.data);
            pre = pre.next;
        }

        while (head != null) {
            if (stack.pop() != head.data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 链表的逆序打印
     * @param head
     */
    private void printListNode(ListNode head) {
        if (head == null)
            return;
        printListNode(head.next);
        System.out.println(head.data);
    }

    /**
     * 奇偶链表
     * 输入: head = [2,1,3,5,6,4,7]
     * 输出: [2,3,6,7,1,5,4]
     * @param head
     * @return
     */
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode temp = head.next;
        while (fast != null && fast.next != null) {
            slow.next = slow.next.next;
            fast.next = (fast.next.next == null ? null : fast.next.next);
            if (slow.next != null) slow = slow.next;
            fast = fast.next;
        }
        slow.next = temp;
        return head;
    }



}
