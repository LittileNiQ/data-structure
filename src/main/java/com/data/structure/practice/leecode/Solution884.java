package com.data.structure.practice.leecode;

import java.util.Stack;

/**
 * Created by Naqi on 2019/7/21.
 */
public class Solution884 {
    public boolean backspaceCompare(String S, String T) {
        return convert(S).equals(convert(T));
    }

    public String convert(String s) {
        Stack<Character> content = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (content.size() > 0) {
                    content.pop();
                }
            } else {
                content.push(s.charAt(i));
            }
        }

        String result = "";
        for (char x : content) {
            result += x;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution884 solution884 = new Solution884();
        solution884.backspaceCompare("a#c", "b");
    }
}
