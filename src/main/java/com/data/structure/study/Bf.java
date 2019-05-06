package com.data.structure.study;

import java.util.Scanner;

/**
 * 普通的模式匹配算法,暴力匹配
 * Created by Naq on 2019/5/5.
 */
public class Bf {

    public static int b(String ts, String ps) {
        char[] t = ts.toCharArray();// 主串
        char[] p = ps.toCharArray();// 模式串
        int i = 0;// 主串
        int j = 0;// 模式串
        while (i < t.length && j < p.length) {
            if (t[i] == p[j]) {// 当两个字符相同，就继续比较下一个
                i++;
                j++;
            } else {
                i = i - j + 1;// 不匹配则i后退
                j = 0;// j归０
            }
        }
        if (j == p.length) {
            return i - j;// 匹配成功，返归子串在主串中的第一个字符出现的位置
        } else {
            return -1;// 最终匹配不成功，返回－１
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入主串：");
        String p = sc.nextLine();
        System.out.println("请输入子串：");
        String s = sc.nextLine();
        int i = b(p, s);// 静态的方法main()只能调用静态的方法b(),因为静态方法早于对象而创建，
        // 调用非静态方法时要提前创建对象，非静态方法要等对象创建之后才能被创建
        System.out.println("子串在主串中的位置：" + i);
    }
}
