package com.data.structure.practice.leecode;

/**
 * Created by Naqi on 2019/7/24.
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int end = s.length;
        int half = end / 2;
        end = end - 1;
        for (int i = 0; i < half && end >= 0; ++i, --end) {
            s[i] ^= s[end];
            s[end] ^= s[i];
            s[i] ^= s[end];
        }
    }

    public static void main(String[] args) {
        Solution344 solution344 = new Solution344();
        char[] charArray ={ 'h', 'e', 'l', 'l', 'o' };
        solution344.reverseString(charArray);
    }
}
