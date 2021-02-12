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
    /**
     * 解法2：滚动数组 时间O(K^2) 空间O(K)
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> cur=new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if(j==0||j==i){
                    cur.add(1);
                    continue;
                }
                cur.add(res.get(j-1)+res.get(j));
            }
            res=cur;
        }
        return res;
    }
    /**
     * 解法3：只用一个数组 时间O(k^2) 空间O(1) 不考虑返回值的空间
     * 思路：
     * 当前行第i项的计算只与上一行第i−1项及第i项有关。
     * 因此我们可以倒着计算当前行，这样计算到第i项时，第i−1项仍然是上一行的值。
     */
    public List<Integer> getRow3(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        if (rowIndex < 0) {
            return res;
        }
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i; j >0; j--) {
                if(j==i){
                    res.add(j,1);
                    continue;
                }
                //list的set方法
                res.set(j,res.get(j-1)+res.get(j));
            }
        }
        return res;
    }
    /**
     * 解法4：线性递推 时间O(K) 空间O(1)
     * 公式：
     * 参考图解
     */
    public List<Integer> getRow4(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}
