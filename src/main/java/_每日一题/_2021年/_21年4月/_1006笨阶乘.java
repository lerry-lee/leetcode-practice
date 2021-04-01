package _每日一题._2021年._21年4月;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @ClassName: _1006笨阶乘
 * @Author: lerry_li
 * @CreateDate: 2021/04/01
 * @Description
 */
public class _1006笨阶乘 {
    /**
     * 解法1：数据栈 时间O(N) 空间O(1)
     * 思路：
     *      遇到乘除就计算，遇到加减就入栈
     */
    public int clumsy(int N) {
        if (N <= 2) {
            return N;
        }

        Deque<Integer> val = new LinkedList<>();

        int opsFlag = 0;

        while (N > 0) {
            int cur = N;
            if (opsFlag == 1) {
                cur = val.pop() * cur;
            } else if (opsFlag == 2) {
                cur = val.pop() / cur;
            } else if (opsFlag == 4) {
                cur = -N;
            }
            N--;
            val.push(cur);
            opsFlag++;
            if (opsFlag == 5) {
                opsFlag = 1;
            }
        }

        int res = 0;
        while (!val.isEmpty()) {
            res += val.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        _1006笨阶乘 instance = new _1006笨阶乘();
        System.out.println(instance.clumsy(4));//7
        System.out.println(instance.clumsy(10));//12
    }
}
