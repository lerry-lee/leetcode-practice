package ByteDance._数组与排序;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * 示例 1:
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * <p>
 * 示例 2:
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * 解法1：最容易想到的解法：先排序，再找
 * 解法2：因为题目是找第K个元素，所以不需要全部排序，每次二分后，看看第k个元素在哪一部分就去排序这部分（随机取partition的基准元素，防止极端测试用例）
 * 解法3：堆？（找第K大个元素，那么只需要维护一个容量为K的最大堆即可，遍历数组，比堆小的元素跳过，否则添加进去并删除堆里面最小的元素）
 * 解法3：用优先队列实现
 * 解法4：BFPRT算法（线性查找算法），最坏情况在O(n)时间复杂度；本质是改进快排pivot的选取（选择中位数的中位数）
 */
public class _数组中的第K个最大元素 {

    //堆版本：用队列实现
    public int findKthLargest_heap(int[] nums, int k) {
//        PriorityQueue<Integer> heap1=new PriorityQueue<>(1);
        PriorityQueue<Integer> heap=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //最大堆,降序
                return o1-o2;
            }
        });
        for(int n:nums){
            heap.add(n);
            if(heap.size()>k) heap.poll();
        }
//        while(!heap.isEmpty()) System.out.println(heap.poll());
        return heap.peek();
    }

    //快排版本
    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1, k - 1);
        return nums[k - 1];
    }

    public void quickSort(int[] nums, int l, int r, int k) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        if (k == p) return;
        else if (k < p)
            quickSort(nums, l, p - 1, k);
        else
            quickSort(nums, p + 1, r, k);
    }

    public int partition(int[] nums, int l, int r) {
        //随机p，防止极端的测试用例
        Random random = new Random();
        int p = random.nextInt(r - l) + l;
        swap(nums, p, l);
        p = l;
        while (l < r) {
            while (l < r && nums[r] <= nums[p]) r--;
            while (l < r && nums[l] >= nums[p]) l++;

            if (l < r) swap(nums, l, r);
        }
        swap(nums, l, p);
        return l;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
