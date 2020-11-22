package DailyExercises._20年9月;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @ClassName _347前K个高频元素
 * @Date 上午10:44 20-9-7
 * @Version 1.0.0
 * @Author lerrylee
 * @Description 前 K 个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 **/
public class _347前K个高频元素 {
    /**
     * 解法1：哈希表+排序
     * 解法2：哈希表+链表/数组（维护K个元素）
     * 解法3：哈希表+小顶堆（维护K个元素）
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for (Integer key : hashMap.keySet()) {
            if (heap.size() < k) heap.offer(new int[]{key, hashMap.get(key)});
            else {
                if (hashMap.get(key) > heap.peek()[1]) {
                    heap.poll();
                    heap.offer(new int[]{key, hashMap.get(key)});
                }
            }
        }
        int[] res = new int[k];
        int i = k - 1;
        while (!heap.isEmpty()) {
            res[i--] = heap.poll()[0];
        }
        return res;
    }
}
