package _每日一题._2022年._5月;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/10
 */
public class _剑指Offer57_2_和为s的连续正数序列 {
    /**
     * 解法1：二维枚举+等差数列求和 时间O(N^2) 空间O(1)
     */
    class Solution {
        public int[][] findContinuousSequence(int target) {
            //特判
            if (target < 1) return new int[][]{};
            //二维枚举
            List<int[]> resList = new ArrayList<>();
            for (int i = 1; i <= target - 2; i++) {
                for (int j = i + 1; j <= target - 1; j++) {
                    int sum = (j + i) * (j - i + 1) / 2;
                    if (sum == target) {
                        int[] temp = new int[j - i + 1];
                        for (int k = 0; k < j - i + 1; k++) {
                            temp[k] = k + i;
                        }
                        resList.add(temp);
                        break;//[i:j]为可行解，[i:j+1]后面都不可行，不必再枚举
                    } else if (sum > target) {
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
    }

    /**
     * 解法2：双指针 时间O(N) 空间O(1)
     * 思路：
     *      假设[l,r]区间和为sum，若：
     *      1. sum==target，则保存可行解，然后l++;
     *      2. sum<target, r++;
     *      3. sum>target, l++;
     *      如此可保证，l和r单调不减，时间复杂度可控制在O(N)
     */
    class Solution2 {
        public int[][] findContinuousSequence(int target) {
            List<int[]> list = new ArrayList<int[]>();
            for (int l = 1, r = 2; l < r;) {
                int sum = (l + r) * (r - l + 1) / 2;
                if (sum == target) {
                    int[] res = new int[r - l + 1];
                    for (int i = l; i <= r; ++i) {
                        res[i - l] = i;
                    }
                    list.add(res);
                    l++;
                } else if (sum < target) {
                    r++;
                } else {
                    l++;
                }
            }
            return list.toArray(new int[list.size()][]);
        }
    }

    /**
     * 解法3：一维枚举+数学优化
     * 思路：
     *      等差数列求和==target，可以转化为方程式，给定x，可用公式在O(1)内算出y
     *      (x+y)(y-x+1)
     *      ------------ = target  =>   y^2+y-x^2+x-2*target=0
     *           2
     */
}
