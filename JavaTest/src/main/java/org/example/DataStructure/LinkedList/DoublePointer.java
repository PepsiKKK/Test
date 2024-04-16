package org.example.DataStructure.LinkedList;

public class DoublePointer {

    /**
     * 环形链表
     * 给你一个链表的头节点 head ，判断链表中是否有环。
     * @tips 双指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //因为本身有可能是null，所以需要判断本身，在判断下一个值
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    /**
     * 环形链表2
     * 返回入环的第一个节点
     * 输入：head = [3,2,0,-4], pos = 1
     * 输出：返回索引为 1 的链表节点
     * 解释：链表中有一个环，其尾部连接到第二个节点。
     * @tips 复杂一点，需要找出如循环头，当找到fast = slow时，该位置不一定是入环位
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        //因为本身有可能是null，所以需要判断本身，在判断下一个值
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }

    /**
     * 相交链表
     * 双指针；长度不相同：A先走上再走下，B先走下再走上，这样长度就相同了
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            A = (A == null ? headB : A.next);
            B = (B == null ? headA : B.next);
        }
        return A;
    }

    /**
     * 删除链表的倒数第N个节点
     * 使用双指针
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
