package com.data.structure.practice.leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by Naqi on 2019/7/27.
 */
public class Solution77 {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        for (String item : path.split("/")) {
            if (item.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!item.isEmpty() && !item.equals(".")) stack.push(item);
        }
        String res = "";
        for (String d : stack)
            res = "/" + d + res;
        return res.isEmpty() ? "/" : res;
    }

    public static void main(String[] args) {
        Solution77 solution77 =new Solution77();
        solution77.simplifyPath("/a/./b/../../c/d/");
    }
}
