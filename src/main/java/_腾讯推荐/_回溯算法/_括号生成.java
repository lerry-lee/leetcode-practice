package _腾讯推荐._回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lerry_li on 2020/10/27
 */
public class _括号生成 {
    /**
     * 解法1：回溯
     * leftN记录左括号个数，rightN记录右括号个数
     * leftN不能大于rightN
     */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        //用list存慢，因为后面还是需要string
//        dfs(res, new ArrayList<>(), n, n);
        //直接用stringBuilder存快
        dfs1(res,new StringBuilder(),n,n);
        return res;
    }

    public void dfs(List<String> res, List<String> temp, int leftN, int rightN) {
        if (leftN == 0 && rightN == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : temp) {
                stringBuilder.append(s);
            }
            res.add(stringBuilder.toString());
            return;
        }
        if (leftN > rightN) {
            return;
        }
        if (leftN > 0) {
            temp.add("(");
            dfs(res, temp, leftN - 1, rightN);
            temp.remove(temp.size() - 1);
        }
        if (rightN > 0) {
            temp.add(")");
            dfs(res, temp, leftN, rightN - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public void dfs1(List<String> res, StringBuilder stringBuilder, int leftN, int rightN) {
        if (leftN == 0 && rightN == 0) {
            res.add(stringBuilder.toString());
            return;
        }
        if (leftN > rightN) {
            return;
        }
        if (leftN > 0) {
            stringBuilder.append("(");
            dfs1(res, stringBuilder, leftN - 1, rightN);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (rightN > 0) {
            stringBuilder.append(")");
            dfs1(res, stringBuilder, leftN, rightN - 1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

}
