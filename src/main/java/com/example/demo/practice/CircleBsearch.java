package com.example.demo.practice;

/**
 * 二分查找循环有序数组
 * 有三种方法查找循环有序数组:
 * 一： 1. 找到分界下标，分成两个有序数组
 * 2. 判断目标值在哪个有序数据范围内，做二分查找
 * 二：1. 找到最大值的下标 x;
 * 2. 所有元素下标 +x 偏移，超过数组范围值的取模;
 * 3. 利用偏移后的下标做二分查找；
 * 4. 如果找到目标下标，再作 -x 偏移，就是目标值实际下标。
 * 两种情况最高时耗都在查找分界点上，所以时间复杂度是 O(N）。
 * 三：我们发现循环数组存在一个性质：以数组中间点为分区，会将数组分成一个有序数组和一个循环有序数组。
 * 1. 如果首元素小于 mid，说明前半部分是有序的，后半部分是循环有序数组；
 * 2 3 4 5 6 1
 * 2. 如果首元素大于 mid，说明后半部分是有序的，前半部分是循环有序的数组；
 * 5 6 1 2 3 4
 * 3. 如果目标元素在有序数组范围中，使用二分查找；
 * 4。如果目标元素在循环有序数组中，设定数组边界后，使用以上方法继续查找。
 * 时间复杂度为 O(logN)。
 * <p>
 * Created by Naqi on 2019/3/27/5:57.
 */
public class CircleBsearch {

    public int search(int array[], int value) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (value == array[low]) return low;
            if (value == array[high]) return high;
            if (value == array[mid]) return mid;

            if (value > array[mid] && value > array[high] && array[mid] < array[low]) {
                high = mid - 1;
            } else if (value < array[mid] && value < array[low] && array[mid] < array[low]) {
                high = mid - 1;
            } else if (value < array[mid] && value > array[low]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
