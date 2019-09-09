package com.data.structure.practice.leecode;

/**
 * Created by Naqi on 2019/7/24.
 */
public class Solution151 {
    public String reverseWords(String s) {
//        char[] chas = s.toCharArray();

//        String streamStr = String.valueOf(chas);
        String[] arr = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = arr.length-1; i >=0 ; i--) {
            sb.append(String.valueOf(arr[i]));
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution151 solution151 = new Solution151();
        System.out.println(solution151.reverseWords("  hello world!  "));

    }

}
