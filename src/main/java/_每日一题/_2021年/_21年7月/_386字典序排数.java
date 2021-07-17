package _每日一题._2021年._21年7月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _386字典序排数
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 */
public class _386字典序排数 {

    /**
     * 解法1：dfs
     */
    public List<Integer> lexicalOrder(int n) {
        res = new ArrayList<>();
        N=n;
        //第一层节点不能为0打头，因此枚举1~9
        for (int i = 1; i <= 9; i++) {
            dfs(i);
        }
        return res;
    }

    List<Integer> res;
    int N;

    public void dfs(int cur) {
        if (cur > N) {
            return;
        }
        res.add(cur);
        //后面的层可以为[0,9]，因此枚举0~9
        for (int i = 0; i <= 9; i++) {
            dfs(cur * 10 + i);
        }
    }
}
