package _每日一题._2021年._21年2月;

import _工具类.CommonMethod;

import java.util.*;

/**
 * @ClassName: _480滑动窗口中位数
 * @Author: lerry_li
 * @CreateTime: 2021/02/03
 * @Description
 */
public class _480滑动窗口中位数 {
    /**
     * 解法1：暴力模拟 时间O(NK) 空间O(N-K)
     * 思路：
     * 每次对滑动窗口中的元素排序，取中位数
     */
    public double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[]{};
        }
        if (k > nums.length) {
            k = nums.length;
        }
        int len = nums.length - k + 1;

        double[] res = new double[len];
        int resIdx = 0;

        //
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        //[left,right)左闭右开区间
        int left = 0, right = k;

        while (right < nums.length) {

            int mid = (right - left) / 2;
            if (k % 2 == 0) {
                res[resIdx] = window[mid] / 2.0 + window[mid - 1] / 2.0;
            } else {
                res[resIdx] = window[mid];
            }
            resIdx++;

            for (int i = 0; i < k; i++) {
                if (window[i] == nums[left]) {
                    window[i] = nums[right];
                    break;
                }
            }
            left++;
            right++;

            Arrays.sort(window);

        }

        int mid = (right - left) / 2;
        if (k % 2 == 0) {
            res[resIdx] = window[mid] / 2.0 + window[mid - 1] / 2.0;
        } else {
            res[resIdx] = window[mid];
        }

        return res;
    }

    /**
     * 解法2：暴力模拟优化(二分查找) 时间O(NKlogK) 空间O(N-K)
     */
    public double[] medianSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new double[]{};
        }
        if (k > nums.length) {
            k = nums.length;
        }
        int len = nums.length - k + 1;

        double[] res = new double[len];
        int resIdx = 0;

        //
        int[] window = new int[k];
        for (int i = 0; i < k; i++) {
            window[i] = nums[i];
        }
        Arrays.sort(window);
        //[left,right)左闭右开区间
        int left = 0, right = k;

        while (right < nums.length) {

            int mid = (right - left) / 2;
            if (k % 2 == 0) {
                res[resIdx] = window[mid] / 2.0 + window[mid - 1] / 2.0;
            } else {
                res[resIdx] = window[mid];
            }
            resIdx++;

            //二分查找
            int l = 0, r = k - 1;
            while (l < r) {
                int middle = l + (r - l) / 2;
                if (window[middle] == nums[left]) {
                    window[middle] = nums[right];
                    break;
                } else if (window[middle] > nums[left]) {
                    r = middle - 1;
                } else {
                    l = middle + 1;
                }
            }
            if (l == r) {
                window[l] = nums[right];
            }

            left++;
            right++;

            Arrays.sort(window);

        }

        int mid = (right - left) / 2;
        if (k % 2 == 0) {
            res[resIdx] = window[mid] / 2.0 + window[mid - 1] / 2.0;
        } else {
            res[resIdx] = window[mid];
        }

        return res;
    }

    /**
     * 解法3：双优先队列+延迟删除 时间O(NlogN) 空间O(N)
     * 细节：
     * 1.延迟删除★
     * 2.比较器使用compareTo防int溢出
     */
    public double[] medianSlidingWindow3(int[] nums, int k) {
        int n = nums.length;
        k = Math.min(k, n);
        int len = n - k + 1;
        double[] res = new double[len];
        Window window = new Window(k);
        for (int i = 0; i < k; i++) {
            window.insert(nums[i]);
        }

        res[0] = window.getMedian();

        int left = 0, right = k;
        int idx = 1;

        while (right < n) {
            window.insert(nums[right]);
            window.erase(nums[left]);
            left++;
            right++;
            res[idx] = window.getMedian();
            idx++;
        }
        return res;

    }

    class Window {
        //大顶堆，升序数组左半部分
        private PriorityQueue<Integer> maxHeap;
        //小顶堆，升序数组右半部分
        private PriorityQueue<Integer> minHeap;
        //延迟删除的元素
        private Map<Integer, Integer> delayedMap;
        //升序数组的大小（滑动窗口的大小）
        private int k;
        //升序数组左半部分的实际大小（不包含延迟删除的元素）
        private int leftSize;
        //升序数组右半部分的实际大小（不包含延迟删除的元素）
        private int rightSize;

        public Window(int k) {
            this.k = k;
            this.leftSize = 0;
            this.rightSize = 0;

            this.maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2.compareTo(o1);
                }
            });
            this.minHeap = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            });
            this.delayedMap = new HashMap<>();
        }

        public void insert(int num) {
            //若maxHeap为空，则插入大顶堆，即升序数组的前半部分
            //或者新插入元素比大顶堆堆顶元素小，则插入大顶堆（升序数组前半部分）
            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.offer(num);
                //实际大小+1
                leftSize++;
            }
            //否则，插入小顶堆（升序数组后半部分）
            else {
                minHeap.offer(num);
                //实际大小+1
                rightSize++;
            }
            //平衡两个优先队列
            makeBalance();
        }

        //删除指定元素，如果是堆顶则进行延迟删除，否则仅标记
        public void erase(int num) {
            delayedMap.put(num, delayedMap.getOrDefault(num, 0) + 1);
            if (num <= maxHeap.peek()) {
                //实际大小-1
                leftSize--;
                if (num == maxHeap.peek()) {
                    prune(maxHeap);
                }
            } else {
                //实际大小-1
                rightSize--;
                if (num == minHeap.peek()) {
                    prune(minHeap);
                }
            }
            //平衡
            makeBalance();
        }

        //不断的删除堆顶符合要求的元素,并且更新哈希表，（属于延迟删除，因此不需要更新实际大小）
        public void prune(PriorityQueue<Integer> heap) {
            while (!heap.isEmpty()) {
                int em = heap.peek();
                if (delayedMap.containsKey(em)) {
                    int count = delayedMap.get(em);
                    if (count > 1) {
                        delayedMap.put(em, count - 1);
                    } else {
                        delayedMap.remove(em);
                    }
                    heap.poll();
                } else {
                    break;
                }
            }
        }

        //操作完之后，要进行平衡处理
        public void makeBalance() {
            //操作之后，两个优先队列的【实际元素个数】可能为：
            //1.maxHeap比minHeap多2个（插入之前多1个，k为奇数）
            //2.maxHeap比minHeap少1个（插入之前相等，k为偶数）
            //3.其他情况（两者大小相等/left比right大1），不作处理
            //对于情况1，将maxHeap的堆顶元素放入minheap
            if (leftSize - rightSize > 1) {
                minHeap.offer(maxHeap.poll());
                leftSize--;
                rightSize++;
                //maxHeap堆顶元素被移除，需要进行延迟删除
                prune(maxHeap);
            }
            //否则对于情况2，将minHeap的堆顶元素放入maxHeap
            else if (leftSize < rightSize) {
                maxHeap.offer(minHeap.poll());
                rightSize--;
                leftSize++;
                prune(minHeap);
            }
        }

        public double getMedian() {
            if (k % 2 == 0) {
                return ((double) maxHeap.peek() + minHeap.peek()) / 2;
            }
            return maxHeap.peek();
        }

    }

    public static void main(String[] args) {
        _480滑动窗口中位数 instance = new _480滑动窗口中位数();
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//        int[] nums = {2147483647, 2147483647};
        double[] res = instance.medianSlidingWindow3(nums, 3);
        CommonMethod.display(res);
    }
}
