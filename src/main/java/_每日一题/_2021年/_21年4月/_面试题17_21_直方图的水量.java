package _每日一题._2021年._21年4月;

/**
 * @ClassName: _面试题17_21_直方图的水量
 * @Author: lerry_li
 * @CreateDate: 2021/04/02
 * @Description
 */
public class _面试题17_21_直方图的水量 {
    /**
     * 解法1：时间O(N) 空间O(N)
     * 思路：
     *      对于每一竖格(假定当前为第i个)来说，它所能装的水取决于它两侧的最高的柱子（min(maxLeft,maxRight)）
     *      这个水量为min(maxLeft,maxRight)-height[i]
     * tips：预先计算所有i的左侧最高height和右侧最高height
     */
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int len = height.length;
        int[] maxLeft = new int[len];
        int[] maxRight = new int[len];
        //保存当前下标元素到最左侧的最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i < len; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i]);
        }
        //保存当前下标元素到最右侧的最大高度
        maxRight[len - 1] = height[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i]);
        }
        //接水
        int total = 0;
        for (int i = 0; i < len; i++) {
            total += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        return total;
    }

    public static void main(String[] args) {
        _面试题17_21_直方图的水量 instance=new _面试题17_21_直方图的水量();
        System.out.println(instance.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
