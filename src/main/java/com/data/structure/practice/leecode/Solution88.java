package com.data.structure.practice.leecode;

/**
 * Created by Naqi on 2019/7/27.
 */
public class Solution88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pos = m + n - 1;
        while (n > 0) {
            if (m > 0 && nums1[m - 1] > nums2[n - 1]) {
                nums1[pos--] = nums1[--m];
            } else {
                nums1[pos--] = nums2[--n];
            }
        }

    }

    public static void main(String[] args) {
        Solution88 solution88 = new Solution88();
        int[] a = {1, 2, 3, 0, 0, 0};
        int[] b = {2, 5, 6};
        solution88.merge(a, 3, b, 3);
    }
}
