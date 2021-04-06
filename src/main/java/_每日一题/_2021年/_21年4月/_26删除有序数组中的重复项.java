package _每日一题._2021年._21年4月;

/**
 * @ClassName: _26删除有序数组中的重复项
 * @Author: lerry_li
 * @CreateDate: 2021/04/06
 * @Description
 */
public class _26删除有序数组中的重复项 {
    /**
     * 解法1：双指针 时间O(N) 空间O(1)
     * 思路： 其中慢指针表示处理出的数组的长度，快指针表示已经检查过的数组的长度
     * 数组完成排序后，可以放置两个指针i和j，只要nums[i]=nums[j]，我们就增加j以跳过重复项。
     * 当我们遇到 nums[i]!=nums[j]时，跳过重复项的运行已经结束，
     * 因此我们必须把它（nums[j]）的值复制到 nums[i + 1]。然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;
        //slow表示已处理的下标，fast表示遍历的下标
        int slow = 0, fast = 1;
        //遍历数足
        while (fast < len) {
            //fast的值和slow不同时，可以添加到处理的数组上
            if (nums[fast] > nums[slow]) {
                slow++;
                if(slow!=fast){
                    nums[slow] = nums[fast];
                }
            }
            fast++;
        }
        //返回长度：已处理的下标+1
        return slow + 1;
    }

    public static void main(String[] args) {
        _26删除有序数组中的重复项 instance=new _26删除有序数组中的重复项();
        System.out.println(instance.removeDuplicates(new int[]{1,1,2}));//2
        System.out.println(instance.removeDuplicates(new int[]{1,1,2,2,3,3}));//3
        System.out.println(instance.removeDuplicates(new int[]{1,2,3}));//3
    }
}
