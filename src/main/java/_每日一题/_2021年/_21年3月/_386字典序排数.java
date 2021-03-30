package _每日一题._2021年._21年3月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _386字典序排数
 * @Author: lerry_li
 * @CreateDate: 2021/03/30
 * @Description
 */
public class _386字典序排数 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        //1~9分别打头
        for (int i = 1; i <= 9; i++) {
            dfs(res, i, n);
        }
        return res;
    }

    public void dfs(List<Integer> res, int cur, int n) {
        if (cur > n) {
            return;
        }
        res.add(cur);
        for (int i = 0; i <= 9; i++) {
            dfs(res, cur * 10 + i, n);
        }
    }

    public static void main(String[] args) {
        _386字典序排数 instance = new _386字典序排数();
        System.out.println(instance.lexicalOrder(23));
    }
}
