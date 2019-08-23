package com.data.structure.practice.leecode;

/**
 * Created by Naqi on 2019/8/15.
 */
public class Solution233 {
    public int countDigitOne(int n) {
        int num=n,i=1,s=0;

        while(num!=0)
        {
            if(num%10==0)
                s=s+(num/10)*i;

            if(num%10==1)
                s=s+(num/10)*i+(n%i)+1;

            if(num%10>1)
                s=s+(int)Math.ceil(num/10.0)*i;

            num=num/10;
            i=i*10;
        }
        return s;
    }

    public static void main(String[] args) {
        Solution233 solution233 =new Solution233();
        solution233.countDigitOne(1234);
    }
}
