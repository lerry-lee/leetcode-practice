package _每日一题._2022年._5月3日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/03
 * @Description
 */
public class _223_矩形面积 {
    /**
     * 解法1：容斥原理
     * 思路：
     *      矩形A的面积+矩形B的面积-重叠的面积（通过计算重叠的长x，宽y得到）
     *      注意：重叠的长x和宽y在计算时，需要和0比较，因为有可能两个矩形不存在重叠
     */
    class Solution {
        public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
            int x = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
            int y = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - (x * y);
        }
    }

}
