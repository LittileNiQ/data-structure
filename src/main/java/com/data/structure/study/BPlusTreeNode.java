package com.data.structure.study;

/**
 * Created by Naqi on 2019/4/20.
 */
/**
 * 这是 B+ 树非叶子节点的定义。
 *
 * 假设 keywords=[3, 5, 8, 10]
 * 4 个键值将数据分为 5 个区间：(-INF,3), [3,5), [5,8), [8,10), [10,INF)
 * 5 个区间分别对应：children[0]...children[4]
 *
 * m 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
 * PAGE_SIZE = (m-1)*4[keywordss 大小]+m*8[children 大小]
 */
public class BPlusTreeNode {
    public static int m = 5; // 5 叉树
    public int[] keywords = new int[m-1]; // 键值，用来划分数据区间
    public BPlusTreeNode[] children = new BPlusTreeNode[m];// 保存子节点指针
}

/**
 * 这是 B+ 树中叶子节点的定义。
 *
 * B+ 树中的叶子节点跟内部结点是不一样的,
 * 叶子节点存储的是值，而非区间。
 * 这个定义里，每个叶子节点存储 3 个数据行的键值及地址信息。
 *
 * k 值是事先计算得到的，计算的依据是让所有信息的大小正好等于页的大小：
 * PAGE_SIZE = k*4[keyw.. 大小]+k*8[dataAd.. 大小]+8[prev 大小]+8[next 大小]
 */
  class BPlusTreeLeafNode {
    public static int k = 3;
    public int[] keywords = new int[k]; // 数据的键值
    public long[] dataAddress = new long[k]; // 数据地址

    public BPlusTreeLeafNode prev; // 这个结点在链表中的前驱结点
    public BPlusTreeLeafNode next; // 这个结点在链表中的后继结点
}
