package com.example.demo.practice.leecode;

/**
 * Leecode17
 * 最长连续子串最大和
 * 很多动态规划算法非常像数学中的递推。我们如果能找到一个合适的递推公式，就能很容易的解决问题。
 * 我们用dp[n]表示以第n个数结尾的最大连续子序列的和，于是存在以下递推公式：dp[n] = max(0, dp[n-1]) + num[n]。
 * 仔细思考后不难发现这个递推公式是正确的，则整个问题的答案是max(dp[m]) | m∈[1, N]。
 * 时间复杂度 O(n)
 * Created by Naq on 2019/4/2.
 */
public class MAxSumSubSeq {
    public static void main(String[] args) {
        int[] a = {1, 10, -4, 5, -5, 32};
        getMaxSumSeq(a);
    }

    private static void getMaxSumSeq(int[] a) {
        int rmax = Integer.MIN_VALUE;
        int sum = Integer.MIN_VALUE;
        int start = -1;
        int end = -1;
        int temp = -1;
        for (int i = 0; i < a.length; i++) {

            if (sum > 0) {
                sum += a[i];
            } else {
                sum = a[i];
                temp = i;
            }
            if (sum > rmax) {
                start = temp;
                rmax = sum;
                end = i;
            }
            System.out.println(sum + "--" + rmax);
        }
        for (int j = start; j <= end; j++) {
            System.out.print(a[j] + " ");
        }
        System.out.println("\nsum:" + rmax);
    }

}
