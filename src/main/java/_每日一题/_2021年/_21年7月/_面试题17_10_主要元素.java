package _每日一题._2021年._21年7月;

/**
 * @ClassName: _面试题17_10_主要元素
 * @Author: lerry_li
 * @CreateTime: 2021/07/11
 * @Description
 * 解法1：摩尔投票法+判断
 */
public class _面试题17_10_主要元素 {

    public static void main(String[] args) {
        _面试题17_10_主要元素 instance = new _面试题17_10_主要元素();
        System.out.println(instance.majorityElement(new int[]{1, 2, 3}));
    }

    /**
     * 解法1：摩尔投票法+判断 时间O(N) 空间O(1)
     */
    public int majorityElement(int[] nums) {
        //入参校验
        if (nums == null || nums.length == 0) return -1;
        int x = -1;
        int ticket = 0;
        for (int num : nums) {
            if (ticket == 0) {
                x = num;
                ticket = 1;
            } else if (x == num) ticket++;
            else ticket--;
        }
        //最后对得到的x进行判断
        int count = 0;
        for (int num : nums) count += num == x ? 1 : 0;
        return count > nums.length / 2 ? x : -1;
    }
}
