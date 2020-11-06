package ByteDance._数组与排序;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/14 18:41
 * @description 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 *
 * 双指针法、栈：待看
 */
public class _接雨水 {
    //暴力解法，O(n^2)
    public int trap1(int[] height) {
        if (height.length < 2) return 0;
        int count = 0;
        for (int i = 0; i < height.length; i++) {
            //左右两个指针，左指针找当前柱子左边比当前柱子高的最高柱子（如果当前柱子最高，那就是当前柱子）...
            int maxL = 0, maxR = 0;
            for (int j = i; j >= 0; j--) {
                maxL = Math.max(maxL, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                maxR = Math.max(maxR, height[j]);
            }
            //按两边最高柱子中较矮的那个，减去当前柱子，即为当前柱子上的雨水
            count += Math.min(maxL, maxR) - height[i];
        }
        return count;
    }

    //暴力解法优化：O(n)
    //不是每次都去遍历找最高的柱子，另外用数组来存储最高值，以空间换时间
    public int trap2(int[] height) {
        if (height.length < 2) return 0;
        int count = 0;
        int[] max_l = new int[height.length];
        int[] max_r = new int[height.length];
        //max_l数组，第i位存储0到i的最高柱子高度
        for (int i = 0; i < height.length; i++) {
            if (i == 0) max_l[i] = height[i];
            else max_l[i] = Math.max(max_l[i - 1], height[i]);
        }
        //max_r数组，第i位存储i到末尾的最高柱子高度
        for (int i = height.length-1; i >=0 ; i--) {
            if(i==height.length-1) max_r[i]=height[i];
            else max_r[i]=Math.max(max_r[i+1],height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            count+=Math.min(max_l[i],max_r[i])-height[i];
        }
        return count;
    }


    public void display(int[] a) {
        for (int t : a)
            System.out.print(t + " ");
        System.out.println();
    }
}
