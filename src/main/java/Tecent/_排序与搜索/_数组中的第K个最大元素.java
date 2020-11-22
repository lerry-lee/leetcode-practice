package Tecent._排序与搜索;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * Created by lerry_li on 2020/10/21
 */
public class _数组中的第K个最大元素 {
    /**
     * 解法1：快排 时间O(nlogn) 空间O(1)
     * 每次看第K个数在那半部分，然后排序那半部分即可
     */
    public int findKthLargest(int[] nums, int k) {
//        for(int num:nums){
//            System.out.print(num+" ");
//        }
//        System.out.println();
        quickSort(nums, 0, nums.length - 1, k);
//        for(int num:nums){
//            System.out.print(num+" ");
//        }
//        System.out.println();
        return nums[k - 1];
    }

    public void quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        if (p == k - 1) return;
        if (p > k - 1) {
            quickSort(nums, l, p - 1, k);
        } else {
            quickSort(nums, p + 1, r, k);
        }
    }

    public int partition(int[] nums, int l, int r) {
        int p = l + new Random().nextInt(r - l);
        swap(nums, l, p);
        p = l;
        while (l < r) {
            while (l < r && nums[r] <= nums[p]) {
                r--;
            }
            while (l < r && nums[l] >= nums[p]) {
                l++;
            }
            if (l < r) {
                swap(nums, l, r);
            }
        }
        swap(nums, l, p);
        return l;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 解法2：最大堆（优先队列实现） 时间O(n) 空间O(k)
     * 维护一个容量为k的最大堆，然后遍历一遍数组即可
     */
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //降序
                return o1 - o2;
            }
        });
        for (int num : nums) {
            if (bigHeap.size() < k) {
                bigHeap.offer(num);
            } else {
                bigHeap.offer(num);
                bigHeap.poll();
            }
        }
        return bigHeap.peek();
    }
}
