package SwordFingerOffer;

import DataStructure.CommonMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _57_2和为s的连续正数序列
 * @Signature: Created by lerry_li on 2020/11/07
 * @Description: 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class _57_2和为s的连续正数序列 {
    /**
     * 解法1：暴力尝试 时间O(N^2) 空间O(N)
     */
    public int[][] findContinuousSequence(int target) {
        if (target < 3) {
            return new int[][]{};
        }
        List<int[]> resList = new ArrayList<>();
        for (int i = 1; i <= target / 2; i++) {
            int sum = i;
            for (int j = i + 1; j <= target / 2 + 1; j++) {
                sum += j;
                if (sum > target) {
                    break;
                }
                if (sum == target) {
                    int[] temp = new int[j - i + 1];
                    for (int k = i; k <= j; k++) {
                        temp[k - i] = k;
                    }
                    resList.add(temp);
                    break;
                }
            }
        }
        int[][] res = new int[resList.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    /**
     * 解法2：滑动窗口
     */
    public int[][] findContinuousSequence2(int target) {
        if (target < 3) {
            return new int[][]{};
        }
        List<int[]> resList = new ArrayList<>();
        //左闭右闭区间[l,r]
        //初始化左窗口的数字为1
        int lNum = 1;
        //初始化右窗口的数字为1
        int rNum = 1;
        //初始化sum为1，左右窗口内的数字和为1
        int sum = 1;
        //左窗口不能超过target/2
        while (lNum <= target / 2) {
            //sum<target，右窗口+1
            if (sum < target) {
                rNum++;
                sum += rNum;

            } else if (sum > target) {
                //sum>target，左窗口+1
                sum -= lNum;
                lNum++;
            } else {
                //sum==target，记录从左窗口到右窗口的值
                int[] temp = new int[rNum - lNum + 1];
                for (int k = lNum; k <= rNum; k++) {
                    temp[k - lNum] = k;
                }
                resList.add(temp);
                //注意：找到一组满足条件的结果后，左窗口+1
                sum -= lNum;
                lNum++;
            }
        }

        return resList.toArray(new int[resList.size()][]);
    }

    public static void main(String[] args) {
        _57_2和为s的连续正数序列 instance = new _57_2和为s的连续正数序列();
        int[][] a = instance.findContinuousSequence2(15);
        CommonMethod.display(a);
    }
}
