package com.data.structure.study;

/**
 * 1) 单链表反转
 * 2) 链表中环的检测:
 *    两种方法：https://maimai.cn/article/detail?fid=1293112579&efid=z2gGFNbPJFXzOKM6ieLpfg
 * 3) 两个有序的链表合并
 * 4) 删除链表倒数第n个结点
 * 5) 求链表的中间结点
 * leetcode:206，141，21，19，876
 */
public class LinkListAlgo {


    /**
     * 单链表反转(就地反转法1)
     * 1个头结点，2个指针，4行代码
     * 注意初始状态和结束状态，体会中间的图解过程。
     * https://www.cnblogs.com/byrhuangqiang/p/4311336.html 写的很好！
     *
     * @param head
     * @return
     */
    public Node reverseList1(Node head) {
        if (head == null)
            return head;
        Node dummy = new Node(-1, null);
        dummy.next = head;
        Node prev = dummy.next;
        Node pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy.next;
    }


    /**
     * 单链表反转 2
     * https://blog.csdn.net/qq_35807952/article/details/80622296 图解
     */
    public static Node reverse(Node list) {

        Node headNode = null;

        Node previousNode = null;

        Node currentNode = list;
        while (currentNode != null) {
            Node nextNode = currentNode.next;
            // 头指针
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }

        return headNode;
    }


    /**
     * 检测环
     * 1.快慢指针检测
     * https://blog.csdn.net/u010983881/article/details/78896293 写的很好
     *
     * @param list
     * @return
     */
    public static boolean checkCircle(Node list) {
        if (list == null) return false;

        Node fast = list.next;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }


    /**
     * 有序链表合并
     *
     * @param la
     * @param lb
     * @return
     */
    public static Node mergeSortedLists(Node la, Node lb) {
        if (la == null) return lb;
        if (lb == null) return la;

        // 标记指针
        Node p = la;
        Node q = lb;
        // 确定头指针
        Node head;
        // 确定头指针
        if (p.data < q.data) {
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }

        // 标记指针r
        Node r = head;

        // 对链表数据依次进行排序
        while (p != null && q != null) {
            if (p.data < q.data) {
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }

        if (p != null) {
            r.next = p;
        } else {
            r.next = q;
        }

        return head;
    }


    /**
     * 删除倒数第K个结点
     * https://www.cnblogs.com/edisonchou/p/4769164.html
     * <p>
     * （1）第一个指针从链表的头指针开始遍历向前走k-1，第二个指针保持不动；
     * （2）从第k步开始，第二个指针也开始从链表的头指针开始遍历；
     * （3）由于两个指针的距离保持在k-1，当第一个（走在前面的）指针到达链表的尾结点时，
     * 第二个指针（走在后面的）指针正好是倒数第k个结点。
     * <p>
     * 有两种情况1.多个节点
     * 2.只有两个结点
     *
     * @param list
     * @param k
     * @return
     */
    public static Node deleteLastKth(Node list, int k) {
        Node fast = list;
        int i = 1;
        // 第一个指针 fast :先找到正数第k个结点,走k-1步
        while (fast != null && i < k) {
            fast = fast.next;
            ++i;
        }

        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        while (fast.next != null) {
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }

        // 有两种情况1.多个节点 2.只有1个结点
        if (prev == null) {
            list = list.next;
        } else {
            prev.next = prev.next.next;
        }
        return list;
    }

    // 求中间结点
    public static Node findMiddleNode(Node list) {
        if (list == null) return null;

        Node fast = list;
        Node slow = list;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static Node createNode(int value) {
        return new Node(value, null);
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


    // 插入排序，a 表示数组，n 表示数组大小
    public void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }


    public static void main(String[] args) {
        LinkListAlgo s = new LinkListAlgo();
//        s.insertionSort();
    }

    /**
     * 单向链表反转（倒置）问题
     * https://blog.csdn.net/qq_35807952/article/details/80622296 源代码
     *
     * @param head
     * @return
     */
    public static Node reverseNew(Node head) {

        Node p, q, pr;
        p = head.next;
        q = null;
        head.next = null;

        while (p != null) {
            pr = p.next;
            p.next = q;
            q = p;
            p = pr;
        }

        head.next = q;
        return head;
    }

}