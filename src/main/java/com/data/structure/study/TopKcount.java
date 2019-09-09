package com.data.structure.study;

/**
 * Created by Naq on 2019/4/4.
 */

import java.util.PriorityQueue;

/**
 * 进行求topK的问题:
 * { 如何在一个包含+n+个数据的数组中，查找前+K+大数据呢？我们可以维护一个大小为+K+的小顶堆，
 * 顺序遍历数组，从数组中取出取数据与堆顶元素比较。如果比堆顶元素大，我们就把堆顶元素删除，
 * 并且将这个元素插入到堆中；如果比堆顶元素小，则不做处理，继续遍历数组。
 * 这样等数组中的数据都遍历完之后，堆中的数据就是前+K+大数据了 }
 *
 * 遍历数组需要+O(n)+的时间复杂度，一次堆化操作需要+O(logK)+的时间复杂度，
 * 所以最坏情况下，n+个元素都入堆一次，所以时间复杂度就是+O(nlogK)。--自己建堆
 * 利用PriorityQueue
 * Created by Naq on 2019/4/4.
 */
public class  TopKcount {

    /**
     * 求数据中前K大数据
     *
     * @param data
     * @param k
     * @return
     */
    public int[] topk(int[] data, int k) {

        // 构建一个基于优先级堆的无界队列（相当于构建一个k大小的小顶堆）
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < data.length; i++) {
            if (queue.size() < k) {
                queue.offer(data[i]);
            } else {
                int value = queue.peek();
                // 如果发现数据比堆顶元素大，则加入到小顶堆中
                if (data[i] > value) {
                    // 删除堆顶元素并替换为data[i]
                    queue.poll();
                    queue.offer(data[i]);
                }
            }
        }


        int[] result = new int[k];
        int index = 0;
        // 遍历完成后，小顶堆的数据就为需要求得的topk的数据
        while (!queue.isEmpty()) {
            result[index++] = queue.poll();
        }

        return result;
    }
}