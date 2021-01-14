package _每日一题._2021年._21年1月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _1018可被5整除的二进制前缀
 * @Author: lerry_li
 * @CreateDate: 2021/01/14
 * @Description
 */
public class _1018可被5整除的二进制前缀 {
    /**
     * 解法1：模拟 时间O(N) 空间O(1)
     * 注意：
     *      1.由于只需要知道每个二进制数是否可以被5整除，因此在计算过程中只需要保留余数即可。
     *      2.使用移位运算代替乘法效率更高
     */
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList<>();
        if (A == null || A.length == 0) {
            return res;
        }
        int curr = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
//            curr = (curr * 2 + A[i]) % 5;
            curr = ((curr << 1) + A[i]) % 5;
            if (curr % 5 == 0) {
                res.add(true);
            } else {
                res.add(false);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _1018可被5整除的二进制前缀 instance = new _1018可被5整除的二进制前缀();
        int[] A = {1, 0, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1};
        System.out.println(instance.prefixesDivBy5(A));
    }
}
