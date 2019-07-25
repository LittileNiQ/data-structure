package com.data.structure.practice.leecode;

/**
 * Created by Naqi on 2019/7/24.
 */
public class Solution203 {
    private ListNode head = null;

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeElements(ListNode head, int val) {
        //删除值相同的头结点后，可能新的头结点也值相等，用循环解决
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null)
            return head;

        ListNode prev = head;
        //确保当前结点后还有结点
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }


    public void insertTail(int value) {

        ListNode newNode = new ListNode(value );
        //空链表，可以插入新节点作为head，也可以不操作
        if (head == null) {
            head = newNode;

        } else {
            ListNode q = head;
            while (q.next != null) {
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    public static void main(String[] args) {
        Solution203 solution203 = new Solution203();
        ListNode node = null;
        int data[] = {1, 2, 5, 3, 1};

        for (int i = 0; i < data.length; i++) {
            //link.insertToHead(data[i]);
            solution203.insertTail(data[i]);
        }
        node = solution203.head;
        solution203.removeElements(node, 2);
    }

}
