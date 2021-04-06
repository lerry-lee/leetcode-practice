package _每日一题._2021年._21年4月;

/**
 * @ClassName: _80删除有序数组中的重复项2
 * @Author: lerry_li
 * @CreateDate: 2021/04/06
 * @Description
 */
public class _80删除有序数组中的重复项2 {

    /**
     * 解法1：暴力 时间O(n^2) 空间O(1)
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int res = 0;
        int len = nums.length;
        int i = 0;
        while (i < len) {
            int j = i + 1;
            int count = 1;
            while (j < len && nums[j] == nums[i] && count < 2) {
                j++;
                count++;
            }
            if (count == 1) {
                i++;
                res++;
            } else {
                res += 2;
                if (j < len && nums[j] != nums[i]) {
                    i = j;
                } else {
                    int cur = j;
                    while (j < len && nums[j] == nums[i]) {
                        j++;
                    }
                    if (j < len) {
                        move(nums, cur, j);
                        len -= j - cur;
                    } else {
                        break;
                    }
                    i = cur;
                }
            }
        }
        return res;
    }

    private void move(int[] nums, int cur, int j) {
        for (int i = j; i < nums.length; i++) {
            nums[cur] = nums[i];
            cur++;
        }
    }

    /**
     * 解法2：双指针 时间O(N) 空间O(1)
     * 思路：其中慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度
     */
    public int removeDuplicates2(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        //slow表示已处理的下标，fast表示当前遍历的下标
        int slow = 1, fast = 2;
        while (fast < len) {
            if (nums[fast] > nums[slow - 1]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        //返回长度：已处理的下标+1
        return slow + 1;
    }


    public static void main(String[] args) {
        _80删除有序数组中的重复项2 instance = new _80删除有序数组中的重复项2();
        System.out.println(instance.removeDuplicates2(new int[]{1, 1, 1, 2, 2, 3}));//5
        System.out.println(instance.removeDuplicates2(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));//7
        System.out.println(instance.removeDuplicates2(new int[]{1, 1}));//2
        System.out.println(instance.removeDuplicates2(new int[]{1, 1, 1}));//2
        System.out.println(instance.removeDuplicates2(new int[]{1, 1, 1, 1, 1}));//2
    }
}
