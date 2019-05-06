package com.data.structure.study;

/**
 * O(n) 时间复杂度内求无序数组中的第 K 大元素。分治思想。
 * 我们选择数组区间 A[0…n-1] 的最后一个元素 A[n-1] 作为 pivot，
 * 对数组 A[0…n-1] 原地分区，这样数组就分成了三部分，A[0…p-1]、A[p]、A[p+1…n-1]。
 *
 * Created by Naq on 2019/3/25.
 */
public class KthSmallestNum {
    public static int kthSmallest(int[] a, int k) {
        if (a == null || a.length < k) {
            return -1;
        }
        int q = partition(a, 0, a.length - 1); // 获取分区点
        while (q + 1 != k) {
            if (q + 1 < k) {
                q = partition(a, q + 1, a.length - 1);
            } else {
                q = partition(a, 0, q - 1);
            }
        }
        return q;
    }

    // 分区函数
    private static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; ++j) {
            if (a[j] < pivot) {
                if (i == j) {
                    ++i;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }

        // 交换
        int tmp = a[i];
        a[i] = a[r];
        a[r] = tmp;

        System.out.println("i=" + i);
        // 返回合适的下标，作为分区标识
        return i;
    }

}
