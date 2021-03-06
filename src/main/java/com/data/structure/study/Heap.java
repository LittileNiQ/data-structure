package com.data.structure.study;

/**
 * 堆及堆排序
 * 我们知道，一个包含+nn+个节点的完全二叉树，树的高度不会超过+log2n 。堆化的过程是顺着节点所在路径比较交换的，
 * 所以堆化的时间复杂度跟树的高度成正比，也就是+O(logn)。插入数据和删除堆顶元素的主要逻辑就是堆化，
 * 所以，往堆中插入一个元素和删除堆顶元素的时间复杂度都是+O(logn)。
 *
 * 建堆的时间复杂度：O(n)
 * Created by Naq on 2019/4/3.
 */
public class Heap {
    private int[] a; // 数组，从下标 1 开始存储数据
    private int n;  // 堆可以存储的最大数据个数
    private int count; // 堆中已经存储的数据个数

    public Heap(int capacity) {
        a = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    // 往堆中插入一个数据
    public void insert(int data) {
        if (count >= n) return; // 堆满了
        ++count;
        a[count] = data;
        int i = count;
        while (i / 2 > 0 && a[i] > a[i / 2]) { // 自下往上堆化
            swap(a, i, i / 2); // swap() 函数作用：交换下标为 i 和 i/2 的两个元素
            i = i / 2;
        }
    }

    // 交换数组中的两个数据
    public void swap(int a[], int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    // 删除堆顶元素
    public void removeMax() {
        if (count == 0)
            return; // 堆中没有数据
        a[1] = a[count];
        --count;
        heapify(a, count, 1);
    }

    private void heapify(int[] a, int n, int i) { // 自上往下堆化
        while (true) {
            int maxPos = i;
            if (i * 2 <= n && a[i] < a[i * 2]) maxPos = i * 2;
            if (i * 2 + 1 <= n && a[maxPos] < a[i * 2 + 1]) maxPos = i * 2 + 1;
            if (maxPos == i) break;
            swap(a, i, maxPos);
            i = maxPos;
        }
    }

    private void buildHeap(int[] a, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(a, n, i);
        }
    }

    // n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
    public void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }

}

