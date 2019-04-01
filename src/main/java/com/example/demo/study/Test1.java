package com.example.demo.study;

/**
 * Created by Naq on 2019/3/11.
 */
public class Test1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int count = 0;
        int val = 1;
        for (count = 0; ; ) {
            if (count == array.length) {
                int sum = 0;
                for (int i = 0; i < array.length; ++i) {
                    sum = sum + array[i];
                }
                array[0] = sum;
                count = 1;
                break;
            }

            array[count] = val;
            ++count;
        }

        for (Integer number : array) {
            System.out.print(number + " ");
        }
    }

}
