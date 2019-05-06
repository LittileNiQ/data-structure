package com.data.structure.study;

/**
 * 冒泡排序、插入排序、选择排序
 * Created by Naq on 2019/3/22.
 */
public class Sorts {

    // 冒泡排序，a是数组，n表示数组大小
    // 原地排序算法，稳定
    // 每次找到最大的放在尾部
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    // 此次冒泡有数据交换
                    flag = true;
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }


    // 插入排序，a表示数组，n表示数组大小
    // 原地排序算法，稳定
    // 保持现有数组有序，逐渐扩大范围
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找要插入的位置并移动数据，从a[j]开始向前推，
            // 将不符合的数组后移，找到合适的位置插入
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = value;
        }
    }

    // 选择排序，a表示数组，n表示数组大小
    // 原地排序算法，不稳定
    // 每次都找范围内的最小值
    public static void selectionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n - 1; ++i) {
            // 查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }

            // 将最小值与当前值交换
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;

        }
    }


}
