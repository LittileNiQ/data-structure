package com.example.demo.study;

import java.util.Random;

/**
 * 跳表的一种实现方法。
 * 跳表中存储的是正整数，并且存储的是不重复的。
 * 跳表使用空间换时间的设计思路，通过构建多级索引来提高查询的效率，
 * 实现了基于链表的“二分查找”。跳表是一种动态数据结构，支持快速的插入、删除、查找操作，时间复杂度都是 O(logn)。
 * Created by Naq on 2019/3/27.
 */
public class SkipList {

    private static final int MAX_LEVEL = 16;

    private int levelCount = 1;

    // 带头链表
    // head是一个头结点，它的forward里存的是原链表以及索引层的头结点。
    private Node head = new Node();
    private Random r = new Random();

    // 跳表查找指定值
    public Node find(int value) {
        Node p = head;
        // forward[levelCount-1]:第一层索引的头结点
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            return p.forwards[0];
        } else {
            return null;
        }
    }

    // 跳表插入某个值
    public void insert(int value) {
        // 随机函数生成
        int level = randomLevel();
        // 索引中要插入的节点，保持平衡
        Node newNode = new Node();
        newNode.data = value;
        newNode.maxLevel = level;
        // 定义索引插入的
        Node update[] = new Node[level];
        // 随机函数生成了值 K，那我们就将这个结点添加到第一级到第 K 级这 K 级索引中
        for (int i = 0; i < level; ++i) {
            update[i] = head;
        }

        // record every level largest value which smaller than insert value in update[]
        // 记录下每一级里面比给定值小的数据范围内的最大值
        Node p = head;
        for (int i = level - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            // use update save node in search path
            // 在搜索路径中使用更新保存节点
            update[i] = p;
        }

        // in search path node next node become new node forwords(next)
        // 在搜索路径节点中，下一个节点变为单词的新节点
        for (int i = 0; i < level; ++i) {
            newNode.forwards[i] = update[i].forwards[i];
            update[i].forwards[i] = newNode;
        }

        // update node hight
        // 更新索引高度
        if (levelCount < level) levelCount = level;
    }

    // 跳表删除某个值
    public void delete(int value) {
        Node[] update = new Node[levelCount];
        Node p = head;
        for (int i = levelCount - 1; i >= 0; --i) {
            while (p.forwards[i] != null && p.forwards[i].data < value) {
                p = p.forwards[i];
            }
            update[i] = p;
        }

        if (p.forwards[0] != null && p.forwards[0].data == value) {
            for (int i = levelCount - 1; i >= 0; --i) {
                if (update[i].forwards[i] != null && update[i].forwards[i].data == value) {
                    update[i].forwards[i] = update[i].forwards[i].forwards[i];
                }
            }
        }
    }

    // 随机 level 次，如果是奇数层数 +1，防止伪随机
    private int randomLevel() {
        int level = 1;
        for (int i = 1; i < MAX_LEVEL; ++i) {
            if (r.nextInt() % 2 == 1) {
                level++;
            }
        }

        return level;
    }

    // 打印元素
    public void printAll() {
        Node p = head;
        while (p.forwards[0] != null) {
            System.out.print(p.forwards[0] + " ");
            p = p.forwards[0];
        }
        System.out.println();
    }

    public class Node {
        private int data = -1;

        // 当前节点的所有索引层的下一跳，
        // forward[ 0 ]对应的是原链表里的下一跳，forward[ 1 ]是最后一层节点的下一跳位置
        private Node forwards[] = new Node[MAX_LEVEL];
        private int maxLevel = 0;

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();
            builder.append("{ data: ");
            builder.append(data);
            builder.append("; levels: ");
            builder.append(maxLevel);
            builder.append(" }");

            return builder.toString();
        }
    }

}
