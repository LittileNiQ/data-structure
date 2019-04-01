package com.example.demo.study;

/**
 * 基于链表实现回文判断：
 * 快慢指针：快慢指针中的快慢指的是移动的步长，即每次向前移动速度的快慢。
 * 例如可以让快指针每次沿链表向前移动2，慢指针每次向前移动1次。
 * <p>
 * Created by Naq on 2019/3/12.
 */
public class SinglyLinkedList2 {
    private Node head = null;

    public static void main(String[] args) {
        SinglyLinkedList2 link = new SinglyLinkedList2();
        System.out.println("hello");
        int data[] = {1, 2, 5, 3, 1};

        for (int i = 0; i < data.length; i++) {
            link.insertTail(data[i]);
        }
        System.out.println("打印原始:");
        link.printAll();
        if (link.isPalindrome()) {
            System.out.println("回文");
        } else {
            System.out.println("不是回文");
        }
    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public void insertTail(int data) {
        Node newNode = new Node(data, null);
        if (head == null) {
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null) {// 找到需要插入的节点，循环遍历查找尾节点
                q = q.next;
            }
            newNode.next = head.next;
            q.next = newNode;
        }
    }

    public boolean isPalindrome() {

        if (head == null) {
            return false;
        } else {
            // 分别定义快慢指针
            Node p = head;
            Node q = head;
            // 只有一个元素
            if (p.next == null) {
                return true;
            }
            // 快慢指针遍历链表开始查找中间节点
            while (q.next != null && q.next.next != null) {
                p = p.next;
                q = q.next.next;
            }
            System.out.println("中间节点" + p.data);
            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null) {
                // p 一定为整个链表的中点，且节点数目为奇数
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
            } else {
                // p q　均为中点
                //p q　均为中点
                rightLink = p.next;
                leftLink = inverseLinkList(p);

            }
            return TFResult(leftLink, rightLink);
        }

    }

    //判断是否回文：true or false
    public boolean TFResult(Node left, Node right) {
        Node l = left;
        Node r = right;

        System.out.println("left_:" + l.data);
        System.out.println("right_:" + r.data);
        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                break;
            }

        }

        System.out.println("什么结果");
        if (l == null && r == null) {
            System.out.println("什么结果");
            return true;
        } else {
            return false;
        }
    }

    // 无头结点的链表翻转
    public Node inverseLinkList(Node p) {

        Node pre = null;
        Node next = null;
        Node r = head;
        System.out.println("z---" + r.data);

        while (r != p) {
            next = r.next;
            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;
        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;

    }
}
