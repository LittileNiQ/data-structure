package com.data.structure.practice.leecode;

/**
 * Created by Naqi on 2019/8/3.
 */
public class SolutionOffer1 {
    public int NumberOf1(int n) {
        int count = 0;
        if(n < 0) {
            n = n & 0x7FFFFFFF;
            count ++;
        }
        while(n!=0){
            if((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        SolutionOffer1 solutionOffer1 = new SolutionOffer1();
        solutionOffer1.NumberOf1(11);
    }
}
