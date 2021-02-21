package _每日一题._2021年._21年2月;

import java.util.*;

/**
 * @ClassName: _1438绝对差不超过限制的最长连续子数组
 * @Author: lerry_li
 * @CreateTime: 2021/02/21
 * @Description
 */
public class _1438绝对差不超过限制的最长连续子数组 {
    /**
     * 解法1：滑动窗口+大小顶堆+延迟删除 时间O(NlogN) 空间O(N)
     */
    public int longestSubarray(int[] nums, int limit) {
        if (limit < 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        //小顶堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        //大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //记录延迟删除的元素
        Map<Integer, Integer> hashMap = new HashMap<>();
        //滑动窗口，[left,right)
        int left = 0, right = 0;
        //结果
        int maxSubLen = 0;
        while (right < len) {

            //判断是否弹出堆顶元素
            prune(minHeap, hashMap);
            prune(maxHeap, hashMap);

            //添加右窗口元素
            minHeap.offer(nums[right]);
            maxHeap.offer(nums[right]);
            hashMap.put(nums[right], hashMap.getOrDefault(nums[right], 0) + 1);
            right++;

            //v1.0
//            //判断窗口是否满足要求，满足则记录窗口长度，否则left窗口右移
//            if (maxHeap.peek() - minHeap.peek() <= limit) {
//                maxSubLen = right - left;
//            } else {
//                //否则，延迟弹出left窗口的值
//                int count = hashMap.get(nums[left]);
//                hashMap.put(nums[left], count - 1);
//                left++;
//            }

            //v2.0
            //由于我隐式的维护了窗口的大小递增，所以可以不用记录窗口的最大长度，最后返回窗口长度即可
            if (maxHeap.peek() - minHeap.peek() > limit) {
                //否则，延迟弹出left窗口的值
                int count = hashMap.get(nums[left]);
                hashMap.put(nums[left], count - 1);
                left++;
            }
        }
//        return maxSubLen;
        return right - left;
    }

    public void prune(PriorityQueue<Integer> heap, Map<Integer, Integer> hashMap) {
        while (!heap.isEmpty() && hashMap.containsKey(heap.peek())) {
            if (hashMap.get(heap.peek()) > 0) {
                return;
            }
            heap.poll();
        }
    }

    /**
     * 解法2：滑动窗口+有序集合TreeMap 时间O(NlogN) 空间O(N)
     */
    public int longestSubarray2(int[] nums, int limit) {
        if (limit < 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        //Java自带有序二叉树
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        //滑动窗口
        int left = 0, right = 0;
        int maxSubLen = 0;
        while (right < len) {
            //添加右窗口
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            right++;

            //v1.0
//            //判断窗口是否满足要求
//            if (treeMap.lastKey() - treeMap.firstKey() <= limit) {
//                maxSubLen = right - left;
//            }
//            //否则，左窗口右移一位
//            else {
//                int count = treeMap.get(nums[left]);
//                if (count == 1) {
//                    treeMap.remove(nums[left]);
//                } else {
//                    treeMap.put(nums[left], count - 1);
//                }
//                left++;
//            }

            //v2.0
            //判断窗口是否满足要求
            //由于我隐式的维护了窗口的大小递增，所以可以不用记录窗口的最大长度，最后返回窗口长度即可
            if (treeMap.lastKey() - treeMap.firstKey() > limit) {
                int count = treeMap.get(nums[left]);
                if (count == 1) {
                    treeMap.remove(nums[left]);
                } else {
                    treeMap.put(nums[left], count - 1);
                }
                left++;
            }

        }
//        return maxSubLen;
        return right - left;
    }

    /**
     * 解法3：滑动窗口+单调队列 时间O(N) 空间O(N)
     */
    public int longestSubarray3(int[] nums, int limit) {
        if (limit < 0 || nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        //单调队列，一个维护最大值（大于当前值的元素），一个维护最小值（小雨当前值的元素）
        Deque<Integer> maxQue = new LinkedList<>();
        Deque<Integer> minQue = new LinkedList<>();
        //滑动窗口
        int left = 0, right = 0;
        int maxSubLen = 0;
        while (right < len) {
            //maxQue维护大于当前值的元素
            while (!maxQue.isEmpty() && maxQue.peekLast() < nums[right]) {
                maxQue.pollLast();
            }
            maxQue.offerLast(nums[right]);
            //minQue维护小于当前值的元素
            while (!minQue.isEmpty() && minQue.peekLast() > nums[right]) {
                minQue.pollLast();
            }
            minQue.offerLast(nums[right]);
            right++;

            //v1.0
//            //判断窗口是否满足要求
//            if (maxQue.peekFirst() - minQue.peekFirst() <= limit) {
//                maxSubLen = right - left;
//            } else {
//                if (maxQue.peekFirst() == nums[left]) {
//                    maxQue.pollFirst();
//                }
//                if (minQue.peekFirst() == nums[left]) {
//                    minQue.pollFirst();
//                }
//                left++;
//            }

            //v2.0
            //由于我隐式的维护了窗口的大小递增，所以可以不用记录窗口的最大长度，最后返回窗口长度即可
            if (maxQue.peekFirst() - minQue.peekFirst() > limit) {
                if (maxQue.peekFirst() == nums[left]) {
                    maxQue.pollFirst();
                }
                if (minQue.peekFirst() == nums[left]) {
                    minQue.pollFirst();
                }
                left++;
            }
        }
//        return maxSubLen;
        return right - left;
    }

    public static void main(String[] args) {
        _1438绝对差不超过限制的最长连续子数组 instance = new _1438绝对差不超过限制的最长连续子数组();
        int[] nums1 = {8, 2, 4, 7};
        System.out.println(instance.longestSubarray3(nums1, 4));
        int[] nums2 = {10, 1, 2, 4, 7, 2};
        System.out.println(instance.longestSubarray3(nums2, 5));
        int[] nums3 = {4, 2, 2, 2, 4, 4, 2, 2};
        System.out.println(instance.longestSubarray3(nums3, 0));
    }
}
