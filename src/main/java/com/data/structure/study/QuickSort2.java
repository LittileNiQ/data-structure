package com.data.structure.study;

/**
 * Created by Naq on 2019/7/22.
 */
public class QuickSort2 {

    // 快速排序，a是数组，n表示数组的大小
    public static void quickSort(int[] a, int n) {
        quickSortInternally(a, 0, n - 1);
    }

    // 快速排序递归函数，p,r为下标
    private static void quickSortInternally(int[] s, int l, int r) {
        if (l< r)
        {
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j]>= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];
                while(i < j && s[i]< x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quickSortInternally(s, l, i - 1); // 递归调用
            quickSortInternally(s, i + 1, r);
        }
    }
}
