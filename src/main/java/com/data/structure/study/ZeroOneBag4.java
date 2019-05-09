package com.data.structure.study;

/**
 * 0-1背包升级版 ：回溯
 * 包括背包重量和物品重量与物品价值
 * Created by Naqi on 2019/5/9.
 */
public class ZeroOneBag4 {
    private int maxV = Integer.MIN_VALUE; // 结果放到 maxV 中
    private int[] weight = {2, 2, 4, 6, 3};  // 物品的重量
    private int[] value = {3, 4, 8, 9, 6}; // 物品的价值
    private int n = 5; // 物品个数
    private int w = 9; // 背包承受的最大重量

    public void f(int i, int cw, int cv) { // 调用 f(0, 0, 0)
        if (cw == w || i == n) { // cw==w 表示装满了，i==n 表示物品都考察完了
            if (cv > maxV) maxV = cv;
            return;
        }
        f(i + 1, cw, cv); // 选择不装第 i 个物品
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i], cv + value[i]); // 选择装第 i 个物品
        }
    }

}
