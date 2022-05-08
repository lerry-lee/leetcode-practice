package _每日一题._2022年._5月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/08
 * @Description
 */
public class _1438_绝对差不超过限制的最长连续子数组 {

    public static void main(String[] args) {
        _1438_绝对差不超过限制的最长连续子数组 instance = new _1438_绝对差不超过限制的最长连续子数组();
        int[] nums = new int[]{8,2,4,7};
        int limit = 4;
        System.out.println(instance.new Solution2().longestSubarray(nums, limit));
    }

    /**
     * 解法1：滑动窗口 时间O(N^2) 空间O(N)
     */
    class Solution {
        public int longestSubarray(int[] nums, int limit) {
            //特判
            if (nums == null || nums.length == 0) return 0;
            //滑动窗口[l,r)
            int l = 0, r = 0;
            int res = 0;//滑动窗口最大值/最长连续子数组的长度
            while (r < nums.length) {
                //1.检查右窗口的元素是否合法
                //若合法，则右窗口+1
                if (check(nums, l, r, limit)) {
                    r++;
                }
                //否则，循环判断，左窗口不断+1，直到窗口内部元素满足要求
                else {
                    while (!check(nums, l, r, limit)) {
                        l++;
                    }
                }
                //2.更新窗口最大值
                res = Math.max(res, r - l);
            }
            return res;
        }

        private boolean check(int[] nums, int start, int end, int limit) {
            int maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                maxNum = Math.max(nums[i], maxNum);
                minNum = Math.min(nums[i], minNum);
                if (maxNum - minNum > limit) return false;
            }
            return true;
        }
    }

    /**
     * 解法2：滑动窗口+二分搜索
     */
    class Solution2 {
        public int longestSubarray(int[] nums, int limit) {
            //特判
            if (nums == null || nums.length == 0) return 0;
            //滑动窗口[l,r)
            int l = 0, r = 0;
            int res = 0;//滑动窗口最大值/最长连续子数组的长度
            //单调数组
            List<Integer> windowsSortedNums = new ArrayList<>();
            while (r < nums.length) {
                //1.右窗口+1
                binarySearchAndInsert(windowsSortedNums, nums[r]);
                r++;
                //检查右窗口的元素是否合法
                //若不合法，循环判断，左窗口不断+1，直到窗口内部元素满足要求
                while (!check(windowsSortedNums, limit)) {
                    binarySearchAndRemove(windowsSortedNums, nums[l]);
                    l++;
                }
                //2.更新窗口最大值
                res = Math.max(res, r - l);
            }
            return res;
        }

        private boolean check(List<Integer> windowsSortedNums, int limit) {
            if (windowsSortedNums.size() < 2) return true;
            return windowsSortedNums.get(windowsSortedNums.size() - 1) - windowsSortedNums.get(0) <= limit;
        }


        private void binarySearchAndRemove(List<Integer> windowsSortedNums, int curNum) {
            int l = 0, r = windowsSortedNums.size() - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (windowsSortedNums.get(mid) == curNum) {
                    l = mid;
                    break;
                } else if (windowsSortedNums.get(mid) < curNum) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            windowsSortedNums.remove(l);
        }

        private void binarySearchAndInsert(List<Integer> windowsSortedNums, int curNum) {
            if (windowsSortedNums.size() == 0) {
                windowsSortedNums.add(curNum);
                return;
            }
            int l = 0, r = windowsSortedNums.size() - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (windowsSortedNums.get(mid) <= curNum) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if (windowsSortedNums.get(l) >= curNum) windowsSortedNums.add(l,curNum);
            else windowsSortedNums.add(curNum);
        }
    }

    /**
     * 解法3：滑动窗口+treeMap 时间O(NlogN) 空间O(N)
     * 思路：
     * treeMap有两个功能：
     * 一是保持元素有序：迅速判断窗口是否合法（直接最大值和最小值的差值）
     * 二是可以直接获取某个key：迅速删除掉做窗口的元素（直接get）
     */
    class Solution3 {
        public int longestSubarray(int[] nums, int limit) {
            //treeMap，保存元素和它的数量
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = nums.length;
            int left = 0, right = 0;
            int res = 0;
            while (right < n) {
                //每次将right窗口的元素添加到treeMap里
                map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
                //right窗口+1
                right++;
                //检查窗口是否合法：treeMap的最大值和最小值的差值是否<=limit，如果>limit，表示窗口不合法，left窗口需要+1
                while (map.lastKey() - map.firstKey() > limit) {
                    //left窗口的元素删掉，如果计数为0，删除该key
                    map.put(nums[left], map.get(nums[left]) - 1);
                    if (map.get(nums[left]) == 0) {
                        map.remove(nums[left]);
                    }
                    //left窗口+1
                    left++;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }

    /**
     * 解法4：滑动窗口+单调队列 时间O(N) 空间O(N)
     * 思路：
     * 使用一个单调递增的队列 queMin 维护最小值，一个单调递减的队列 queMax 维护最大值。
     * 这样只需要计算两个队列的队首的差值，即可知道当前窗口是否满足条件。
     */
    class Solution4 {
        public int longestSubarray(int[] nums, int limit) {
            Deque<Integer> queMax = new LinkedList<Integer>();//递减队列
            Deque<Integer> queMin = new LinkedList<Integer>();//递增队列
            int n = nums.length;
            int left = 0, right = 0;
            int res = 0;
            while (right < n) {
                //维持递减队列，把小于nums[right]的队尾元素都poll掉
                while (!queMax.isEmpty() && queMax.peekLast() < nums[right]) {
                    queMax.pollLast();
                }
                //维持递增队列，把大于nums[right]的队尾元素都poll掉
                while (!queMin.isEmpty() && queMin.peekLast() > nums[right]) {
                    queMin.pollLast();
                }
                //队列添加right窗口的元素
                queMax.offerLast(nums[right]);
                queMin.offerLast(nums[right]);
                //右窗口+1
                right++;
                //判断窗口是否合法，不合法需要左窗口移动
                while (!queMax.isEmpty() && !queMin.isEmpty() && queMax.peekFirst() - queMin.peekFirst() > limit) {
                    //如果左窗口的元素在队首，poll掉
                    if (nums[left] == queMin.peekFirst()) {
                        queMin.pollFirst();
                    }
                    //如果左窗口的元素在队首，poll掉
                    if (nums[left] == queMax.peekFirst()) {
                        queMax.pollFirst();
                    }
                    //左窗口+1
                    left++;
                }
                res = Math.max(res, right - left);
            }
            return res;
        }
    }
}
