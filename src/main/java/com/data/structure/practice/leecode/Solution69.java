package com.data.structure.practice.leecode;

/**
 * Created by Naqi on 2019/7/23.
 */
public class Solution69 {
    public static final double ENUM = 0.000001;

    public double mySqrt(int x) {
        if(x==1)
            return 1;
        double start = 0.0;
        double end = x*1.0;
        double mid = 0.0;
        while (true) {
            mid = (start + end) / 2;
            if (((mid * mid - x) <= ENUM) && ((mid * mid - x) >= -ENUM)) {
                return mid;
            }

            if ((mid * mid - x) > ENUM) {
                end = mid;
            } else {
                 start = mid;
            }
        }
    }

    public static void main(String[] args) {
        Solution69 solution69=new Solution69();

        System.out.println((int)solution69.mySqrt(25));
    }
}
