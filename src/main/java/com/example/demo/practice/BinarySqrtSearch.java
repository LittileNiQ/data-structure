package com.example.demo.practice;

import java.util.Scanner;

/**
 * 利用二分法求一个数的平方根，精确到小数点后6位。
 * Created by Naq on 2019/3/26.
 */
public class BinarySqrtSearch {

    public static final double ENUM = 0.000001;

    public static double mybsearch(double num) {
        double start = 1.0;
        double end = num;
        double mid = 0.0;
        while (true) {
            mid = (start + end) / 2;
            if (((mid * mid - num) <= ENUM) && ((mid * mid - num) >= -ENUM)) {
                return mid;
            }

            if ((mid * mid - num) > ENUM) {
                end = mid;
            } else {
                start = mid;
            }
        }
    }

    public static void main(String[] args) {
        double num = 0.0;
        Scanner sc = new Scanner(System.in);
        double szWelcome = sc.nextDouble();
        System.out.println(szWelcome + "lf的平方根是" + mybsearch(szWelcome));
    }

}
