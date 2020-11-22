package ByteDance._动态或贪心;

import java.util.List;

/**
 * @author lerry_ang
 * @version 1.0
 * @create 2020/06/20 11:01
 * @description 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * <p>
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * <p>
 * <p>
 * <p>
 * 例如，给定三角形：
 * <p>
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 递归回溯法超时了
 */
public class _三角形最小路径和 {

    //dp:时间复杂度O(n^2) 空间复杂度O(n)
    public int minimumTotal_dp2(List<List<Integer>> triangle) {
        if (triangle.size() == 0) return 0;
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        int left = 0, current = 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                current = dp[j];
                if (j == 0) dp[j] = current + row.get(j);
                else if (j == i) dp[j] = left + row.get(j);
                else dp[j] = Math.min(left, current) + row.get(j);
                left = current;
            }
        }
        for (int dpi : dp) res = Math.min(res, dpi);
        return res;

    }

    //dp:O(n^2) O(n^2)
    public int minimumTotal_dp(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
//        List<List<Integer>> dp = new ArrayList<>();
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size() - 1).size()];
        dp[0][0] = triangle.get(0).get(0);
//        dp.add(Arrays.asList(triangle.get(0).get(0)));
        int min_path = Integer.MAX_VALUE;
        for (int i = 1; i < triangle.size(); i++) {
//            dp.add(new ArrayList<>());
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
//                    dp.get(i).add(dp.get(i - 1).get(0) + triangle.get(i).get(0));
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (j == triangle.get(i).size() - 1) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
//                    dp.get(i).add(dp.get(i - 1).get(dp.get(i - 1).size() - 1) + triangle.get(i).get(j));
                } else {
//                    int temp = Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + triangle.get(i).get(j);
//                    dp.get(i).add(temp);
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
                if (i == triangle.size() - 1) min_path = Math.min(min_path, dp[i][j]);
            }

        }
        return min_path;
    }


    int min_sum;
    int temp_sum;

    public int minimumTotal(List<List<Integer>> triangle) {
        min_sum = Integer.MAX_VALUE;
        temp_sum = triangle.get(0).get(0);
        dfs(triangle, 0, 0);
        return min_sum;
    }

    public void dfs(List<List<Integer>> triangle, int row, int col) {
        if (row == triangle.size() - 1) {
            min_sum = Math.min(min_sum, temp_sum);
            System.out.println("min_sum:" + min_sum);
            return;
        }
        temp_sum += triangle.get(row + 1).get(col);

        System.out.println("进入左分支 row:" + (row + 1) + " col:" + col + " temp_sum:" + temp_sum);
        dfs(triangle, row + 1, col);
        temp_sum -= triangle.get(row + 1).get(col);

        temp_sum += triangle.get(row + 1).get(col + 1);

        System.out.println("进入右分支 row:" + (row + 1) + " col:" + (col + 1) + " temp_sum:" + temp_sum);
        dfs(triangle, row + 1, col + 1);
        temp_sum -= triangle.get(row + 1).get(col + 1);

    }
}
