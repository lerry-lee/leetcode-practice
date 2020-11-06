package DailyExercises._20年10月;

import java.util.Random;

/**
 * Created by lerry_li on 2020/10/07
 */
public class _75颜色分类 {
    /**
     * 解法1：手写快排 时间复杂度O(logn)
     */
    public void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int p = partition(nums, l, r);
        quickSort(nums, l, p - 1);
        quickSort(nums, p + 1, r);
    }

    public int partition(int[] nums, int l, int r) {
        int p = l + (new Random().nextInt(r - l));
        int pivot = nums[p];
        swap(nums, p, l);
        p = l;
        while (l < r) {
            while (l < r && nums[r] >= pivot) r--;
            while (l < r && nums[l] <= pivot) l++;
            if (l < r) swap(nums, l, r);
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
     * 解法2：计数排序
     * 一个直观的解决方案是使用计数排序的两趟扫描算法。
     * 首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
     */
    public void sortColors_countSort(int[] nums) {
        int cnt_0 = 0, cnt_1 = 0, cnt_2 = 0;
        for (int num : nums) {
            if (num == 0) cnt_0++;
            else if (num == 1) cnt_1++;
            else cnt_2++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (cnt_0 > 0) {
                nums[i] = 0;
                cnt_0--;
            } else if (cnt_1 > 0) {
                nums[i] = 1;
                cnt_1--;
            } else {
                nums[i] = 2;
                cnt_2--;
            }
        }
    }

    /**
     * 解法3：
     * 循环不变量：声明的变量在遍历的过程中需要保持定义不变。
     *
     * 设计循环不变量的原则
     * 说明：设计循环不变量的原则是 不重不漏。
     *
     * len 是数组的长度；
     * 变量 zero 是前两个子区间的分界点，一个是闭区间，另一个就必须是开区间；
     * 变量 i 是循环变量，一般设置为开区间，表示 i 之前的元素是遍历过的；
     * two 是另一个分界线，我设计成闭区间。
     * 如果循环不变量定义如下：
     *
     * 所有在子区间 [0, zero) 的元素都等于 0；
     * 所有在子区间 [zero, i) 的元素都等于 1；
     * 所有在子区间 [two, len - 1] 的元素都等于 2。
     *
     * 编码的时候，zero 和 two 初始化的值就应该保证上面的三个子区间全为空；
     * 在遍历的过程中，「下标先加减再交换」、还是「先交换再加减」就看初始化的时候变量在哪里；
     * 退出循环的条件也看上面定义的循环不变量，在 i == two 成立的时候，上面的三个子区间就正好 不重不漏 地覆盖了整个数组，并且给出的性质成立，题目的任务也就完成了。
     */
    public void sortColors_(int[] nums) {

        // all in [0, zero) = 0
        // all in [zero, i) = 1
        // all in [two, len - 1] = 2

        // 循环终止条件是 i == two，那么循环可以继续的条件是 i < two
        // 为了保证初始化的时候 [0, zero) 为空，设置 zero = 0，
        // 所以下面遍历到 0 的时候，先交换，再加

        //保证初始化时三个区间都为空，所以zero=0,tow=nums.length,i=0
        int zero = 0, two = nums.length, i = 0;

        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            }else {
                two--;
                swap(nums,i,two);
            }
        }
    }
}
