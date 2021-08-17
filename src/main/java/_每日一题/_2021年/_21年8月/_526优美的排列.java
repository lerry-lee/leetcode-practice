package _每日一题._2021年._21年8月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _526优美的排列
 * @Author: lerry_li
 * @CreateDate: 2021/08/17
 * @Description
 */
public class _526优美的排列 {
    List<Integer>[] match;
    boolean[] visited;
    int num;

    /**
     * 解法1：回溯 时间O(N!) 空间O(N^2)
     */
    public int countArrangement(int n) {
        //访问过的数
        visited = new boolean[n + 1];
        //每个位置符合条件的数
        match = new List[n + 1];
        for (int i = 0; i <= n; i++) {
            match[i] = new ArrayList<Integer>();
        }
        //预处理每个位置符合条件的数
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i % j == 0 || j % i == 0) {
                    match[i].add(j);
                }
            }
        }
        //回溯求解
        backtrack(1, n);
        return num;
    }

    /**
     * 回溯求解
     *
     * @param index 位置index
     * @param n 排列的长度
     */
    public void backtrack(int index, int n) {
        //如果数组排列完了，那么num+1
        if (index == n + 1) {
            num++;
            return;
        }
        //否则，填充当前index的元素，遍历match满足条件的数
        for (int x : match[index]) {
            //没有访问过的才进行处理
            if (!visited[x]) {
                visited[x] = true;
                backtrack(index + 1, n);
                visited[x] = false;
            }
        }
    }
}
