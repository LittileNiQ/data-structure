package com.data.structure.practice.leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Naqi on 2019/8/4.
 */
public class Solution46 {

    List<List<Integer>> lists=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
          Permutation(nums);
        return lists;
    }

    public List<List<Integer>> Permutation(int[] arr) {
        List<List<Integer>> res = new ArrayList<>();
        if (arr != null && arr.length > 0) {
            PermutationHelper(arr, 0, res);
            // Collections.sort(res);
        }
        return  res;
    }

    public void PermutationHelper(int[] cs, int i, List<List<Integer>> list) {
        if (i == cs.length - 1) {

            List<Integer> val=new ArrayList<>();
            for (int x:cs) {
                val.add(x);
            }
            if (!list.contains(val))
                lists.add(val);
        } else {
            for (int j = i; j < cs.length; j++) {
                swap(cs, i, j);
                PermutationHelper(cs, i+1, list);
                swap(cs, i, j);
            }
        }
    }

    public void swap(int[] cs, int i, int j) {
        int temp = cs[i];
        cs[i] = cs[j];
        cs[j] = temp;
    }

    public static void main(String[] args) {
        Solution46 p = new Solution46();
        int a[] ={1,2,3};
        System.out.println(p.Permutation(a));

    }
}
