package com.data.structure.study;

import java.util.Scanner;

/**
 * 基于链表实现 LRU 缓存淘汰算法
 *
 * 我们维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，
 * 我们从链表头开始顺序遍历链表。
 *  1. 如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，
 *  并将其从原来的位置删除，然后再插入到链表的头部。
 *  2. 如果此数据没有在缓存链表中，又可以分为两种情况：
 *   ——如果此时缓存未满，则将此结点直接插入到链表的头部；
 *   ——如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部。
 *   https://blog.csdn.net/u012321457/article/details/80714640
 *   https://www.cnblogs.com/Dhouse/p/8615481.html 0527补充
 * Created by Naq on 2019/3/12.
 */

public class LrubaseLinkedList<T> {

    /**
     * 默认链表容量
     */
    private final static Integer DEFAULT_CAPACITY = 10;

    /**
     * 头结点
     */
    private Snode<T> headNode;

    /**
     * 链表长度
     */
    private Integer length;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LrubaseLinkedList() {
        this.headNode = new Snode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.length = 0;
    }


    public void add(T data) {
        // 获取查找元素的前一个结点
        Snode preNode = findPreNode(data);

        // 链表中存在，删除原数据，再插入到链表的头部
        if (preNode != null) {
            deleteElemOptim(preNode);
            intsertElemAtBegin(data);
        } else {
            if (length >= this.capacity) {
                //删除尾结点
                deleteElemAtEnd();
            }
            intsertElemAtBegin(data);
        }
    }

    /**
     * 删除preNode结点下一个元素
     *
     * @param preNode
     */
    private void deleteElemOptim(Snode preNode) {
        Snode temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp = null;
        length--;
    }

    /**
     * 链表头部插入节点
     *
     * @param data
     */
    private void intsertElemAtBegin(T data) {
        Snode next = headNode.getNext();
        // 将对应指针和value值的结点插入
        headNode.setNext(new Snode(data, next));
        length++;
    }

    /**
     * 查找是否存在该结点，存在后
     * 获取查找到元素的前一个结点
     *
     * @param data
     * @return
     */
    private Snode findPreNode(T data) {
        Snode node = headNode;
        while (node.getNext() != null) {
            if (data.equals(node.getNext().getElement())) {
                return node;
            }
            node = node.getNext();
        }
        return null;
    }

    /**
     * 删除尾结点
     */
    private void deleteElemAtEnd() {
        Snode ptr = headNode;
        // 空链表直接返回
        if (ptr.getNext() == null) {
            return;
        }

        // 倒数第二个结点
        while (ptr.getNext().getNext() != null) {
            // 倒数第二个
            ptr = ptr.getNext();
        }

        Snode tmp = ptr.getNext();
        ptr.setNext(null);
        tmp = null;
        length--;
    }

    private void printAll() {
        Snode node = headNode.getNext();
        while (node != null) {
            System.out.print(node.getElement() + ",");
            node = node.getNext();
        }
        System.out.println();
    }

    public class Snode<T> {

        private T element;

        private Snode next;

        public Snode(T element) {
            this.element = element;
        }

        public Snode(T element, Snode next) {
            this.element = element;
            this.next = next;
        }

        public Snode() {
            this.next = null;
        }

        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public Snode getNext() {
            return next;
        }

        public void setNext(Snode next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        LrubaseLinkedList list = new LrubaseLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }

}