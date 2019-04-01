package com.example.demo.study;

/**
 * 二分查找(用最省内存的方式实现快速查找功能)
 * 时间复杂度：O(logn)
 *
 * 分析链表存储的二分查找时间复杂度：
 * 假设链表长度为n，二分查找每次都要找到中间点(计算中忽略奇偶数差异):
 * 第一次查找中间点，需要移动指针n/2次；
 * 第二次，需要移动指针n/4次；第三次需要移动指针n/8次；
 * 以此类推，一直到1次为值。最后算法时间复杂度是：O(n-1)，忽略常数，记为O(n)，时间复杂度和顺序查找时间复杂度相同
 * 但是稍微思考下，在二分查找的时候，由于要进行多余的运算，严格来说，会比顺序查找时间慢。
 * Created by Naq on 2019/3/26.
 */
public class BinarySearch {

    // 二分查找的递归实现
    public int bsearchRecursive(int[] a, int n, int val) {
        return bsearchInternally(a, 0, n - 1, val);
    }

    private int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

    // 二分查找非递归
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }


}
