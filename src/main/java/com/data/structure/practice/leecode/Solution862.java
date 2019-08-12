package com.data.structure.practice.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Naqi on 2019/8/12.
 */
public class Solution862 {
    public int shortestSubarray(int[] A, int K) {
        int len = A.length;
        int sum = 0, begin = 0, res = -1;
        for (int i = 0; i < len; i++) {
            if (A[i] >= K) return 1;
            sum += A[i];
            if (sum < 1) {
                sum = 0;
                begin = i + 1;
                continue;
            }
            for (int j = i - 1; A[j + 1] < 0; j--) {
                A[j] = A[j + 1] + A[j];
                A[j + 1] = 0;
            }
            if (sum >= K) {
                while (sum - A[begin] >= K || A[begin] <= 0)
                    sum -= A[begin++];
                int length = i - begin + 1;
                if (res < 0 || res > length)
                    res = length;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution862 solution862 = new Solution862();
        int a[] = {2, 2, -1, 4, -2, 4, -1};
        solution862.shortestSubarray(a, 5);
    }
}
