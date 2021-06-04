package _牛客题库;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @ClassName: _加起来和为目标值的组合
 * @Author: lerry_li
 * @CreateDate: 2021/06/03
 * @Description
 */
public class _加起来和为目标值的组合 {

    public static void main(String[] args) {
        _加起来和为目标值的组合 instance = new _加起来和为目标值的组合();
        System.out.println(instance.combinationSum2(new int[]{100, 10, 20, 70, 60, 10, 50}, 80));
        System.out.println(instance.combinationSum2(new int[]{1}, 2));
        System.out.println(instance.combinationSum2(new int[]{3, 1, 3, 5, 1, 1}, 8));
    }

    /**
     * 解法1：排序+回溯
     */
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        //特判
        if (num == null || num.length == 0) {
            return new ArrayList<>();
        }
        res = new ArrayList<>();
        Arrays.sort(num);
        dfs(num, target, 0, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] num, int target, int sum, int t, ArrayList<Integer> cur) {
        if (sum == target) res.add(new ArrayList<>(cur));
        else {
            if (t >= num.length) return;
            if (target - sum < num[t]) return;
            for (int i = t; i < num.length; i++) {
                if (i > t && num[i] == num[i - 1]) continue;
                sum += num[i];
                if (sum > target) return;
                cur.add(num[i]);
                dfs(num, target, sum, i + 1, cur);
                cur.remove(cur.size() - 1);
                sum -= num[i];
            }
        }
    }

    ArrayList<ArrayList<Integer>> res;
}
