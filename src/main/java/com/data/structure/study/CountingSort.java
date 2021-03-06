package com.data.structure.study;

/**
 * 计数排序。
 * <p>
 * Created by Naq on 2019/3/25.
 */
public class CountingSort {

    // 计数排序，a是数组，n是数组大小。假设数组中存储的都是非负整数。
    public void countingSort(int[] a, int n) {
        if (n <= 1) return;

        // 查找数组中数据的范围，查找最大值
        int max = a[0];
        for (int i = 1; i < n; ++i) {
            if (max < a[i]) {
                max = a[i];
            }
        }

        // 申请一个计数数组c，下标大小[0,max]
        int[] c = new int[max + 1];
//        for (int i = 0; i < max + 1; ++i) {
//            c[i] = 0;
//        }

        // 计算每个元素的个数，放入c中
        for (int i = 0; i < n; ++i) {
            c[a[i]]++;
        }

        // 依次累加
        for (int i = 1; i < max + 1; ++i) {
            c[i] = c[i - 1] + c[i];
        }

        // 临时数组r，存储排序之后的结果
        int[] r = new int[n];

        // 计算排序的关键步骤了，有点难理解
        // 从后往前以便保持稳定性。从前往后就不是稳定排序了
        for (int i = n - 1; i >= 0; --i) {
            int index = c[a[i]] - 1;
            r[index] = a[i];
            c[a[i]]--;
        }

        // 将结果拷贝会a数组
        for (int i = 0; i < n; ++i) {
            a[i] = r[i];
        }
    }

    public static void main(String[] args) {
        CountingSort sort1 = new CountingSort();
        int s[] = {2, 5, 3, 0, 2, 3, 0, 3};
        sort1.countingSort(s, 8);
        for (int i : s) {
            System.out.print(" " + i);
        }

    }

}
