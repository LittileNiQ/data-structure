package com.data.structure.study;

/**
 * 递归
 * 爬楼梯的问题，解决重复计算，采用数据保存方法
 * Created by Naq on 2019/3/26.
 */
public class Recursive {

    private static int helper(int n, int value[]) {

        // 如果当前值不为0，则返回该值，即为所求。
        if (value[n] != 0) {
            return value[n];
        }

        // 递推公式
        value[n] = helper(n - 1, value) + helper(n - 2, value);
        return value[n];
    }


    private static int climbStaris(int n) {

        int res = 0;
        int value[] = new int[n + 1];
        value[0] = 0;
        value[1] = 1;
        value[2] = 2;
        res = helper(n, value);
        return res;
    }

    public static void main(String[] args) {
        System.out.println("--5--" + climbStaris(4));
        System.out.println("--6--" + climbStaris(6));
        System.out.println("--7--" + climbStaris(7));
    }


}
