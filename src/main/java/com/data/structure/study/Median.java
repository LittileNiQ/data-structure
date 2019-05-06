package com.data.structure.study;

import java.util.PriorityQueue;

/**
 * 利用堆求动态数组中位数
 * 利用基于优先级堆的无界队列来实现
 * 我们需要维护两个堆，一个大顶堆，一个小顶堆。大顶堆中存储前半部分数据，
 * 小顶堆中存储后半部分数据，且小顶堆中的数据都大于大顶堆中的数据。
 * Created by Naq on 2019/4/4.
 */
public class Median {

    /**
     * 大顶堆，用来存储前半部分的数据，如果完整为100，那此存储的为0-50
     * 自定义排序方法，实现从大到小排序以满足大顶堆的定义
     */
    private PriorityQueue<Integer> firstBigHeap =
            new PriorityQueue<>(
                    51,
                    (o1, o2) -> {
                        if (o1 < o2) {
                            return 1;
                        } else if (o1 > o2) {
                            return -1;
                        }
                        return 0;
                    });

    /**
     * 小顶堆,用来存储后半部分的数据，如果完整为100,那此存储的为51-100
     * 利用优先队列来实现，priorityQueue默认自然排序，从小到大
     */
    private PriorityQueue<Integer> afterLittleHeap = new PriorityQueue<>(51);

    /**
     * 元素的个数
     */
    private int count;

    /**
     * 插入数据
     *
     * @param num 当前动态的数据集
     */
    public void putNum(int num) {

        count++;

        // 1,如果堆为空，则插入大顶堆中
        if (firstBigHeap.isEmpty() && afterLittleHeap.isEmpty()) {
            firstBigHeap.offer(num);
            return;
        }

        // 2.如果数据当前元素比大顶堆中的元素大，则插入小顶堆中
        if (firstBigHeap.peek() < num) {
            afterLittleHeap.offer(num);
        }
        // 3.如果元素的数据比大顶堆中的元素小，则插入大顶堆中
        else {
            firstBigHeap.offer(num);
        }

        int countValue = count / 2;
        int firstBigHeapSize = firstBigHeap.size();
        int afterLittleHeapSize = afterLittleHeap.size();

        // 如果大顶堆中的数据超过了中位数，则需要要移动,
        // 因为大顶堆中存储的数据为n/2+1个当n为奇数的情况下，所以每次取数，仅返回大顶堆中的数据即可
        // 大顶堆是奇数，小顶堆是偶数不需要移动，大顶堆是偶数且比n/2大，则需要移动
        if (firstBigHeapSize > countValue && firstBigHeapSize % 2 != 1) {
            move(firstBigHeap, afterLittleHeap, firstBigHeap.size() - countValue);
            System.out.println("大顶堆：");
            firstBigHeap.forEach(c -> {
                System.out.print(c + " ");
            });
            System.out.println("小顶堆：");
            afterLittleHeap.forEach(c -> {
                System.out.print(c + " ");
            });

            return;
        }
        // 如果小顶堆中的数据超过了中位数，也需要移动
        if (afterLittleHeapSize > countValue) {
            move(afterLittleHeap, firstBigHeap, afterLittleHeap.size() - countValue);
            System.out.println("大顶堆：");
            firstBigHeap.forEach(c -> {
                System.out.print(c + " ");
            });
            System.out.println("小顶堆：");
            afterLittleHeap.forEach(c -> {
                System.out.print(c + " ");
            });

            return;
        }
    }

    /**
     * 返回中位数的数据
     *
     * @return
     */
    public int getMidValue() {
        return firstBigHeap.peek();
    }

    /**
     * 从一个堆向另一个堆中移动元素
     *
     * @param src
     * @param out
     */
    private void move(PriorityQueue<Integer> src, PriorityQueue<Integer> out, int runNum) {
        for (int i = 0; i < runNum; i++) {
            out.offer(src.poll());
        }
    }

    public static void main(String[] args) {
        Median median = new Median();
        for (int i = 0; i < 10; i++) {
            int num = (int) (Math.random() * 100);
            median.putNum(num);
            System.out.println(median.getMidValue());
        }

    }

}
