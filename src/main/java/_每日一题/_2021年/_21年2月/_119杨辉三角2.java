package _每日一题._2021年._21年2月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _119杨辉三角2
 * @Author: lerry_li
 * @CreateTime: 2021/02/12
 * @Description
 */
public class _119杨辉三角2 {
    /**
     * 解法1：模拟 时间O(k^2) 空间O(k^2)
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);
        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            List<Integer> last = result.get(i - 1);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    curr.add(last.get(j - 1) + last.get(j));
                }
            }
            result.add(curr);
        }
        return result.get(rowIndex);
    }
}
