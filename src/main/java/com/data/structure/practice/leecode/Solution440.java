package com.data.structure.practice.leecode;

/**
 * step:从1到2需要经过多少个数字
 * https://www.cnblogs.com/grandyang/p/6031787.html
 * Created by Naqi on 2019/7/30.
 */
public class Solution440 {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        --k;
        while (k > 0) {
            long step = 0, first = cur, last = cur + 1;
            while (first <= n) {
                step += Math.min((long) n + 1, last) - first;
                first *= 10;
                last *= 10;
            }
            if (step <= k) {
                ++cur;
                k -= step;
            } else {
                cur *= 10;
                --k;
            }
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution440 solution440 = new Solution440();
        System.out.println(solution440.findKthNumber(103, 4));
    }
}
