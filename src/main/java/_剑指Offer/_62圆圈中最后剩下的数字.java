package _剑指Offer;

import java.util.ArrayList;

/**
 * @ClassName: _62圆圈中最后剩下的数字
 * @Signature: Created by lerry_li on 2020/11/19
 * @Description: 约瑟夫环
 */
public class _62圆圈中最后剩下的数字 {

    /**
     * 解法1：模拟链表 暴力解法 时间O(NM) 空间O(N)
     */
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    /**
     * 解法2：数学推导 约瑟夫环 时间O(N) 空间O(1)
     */
    public int lastRemaining2(int n, int m) {
        //只有1个数字0时，最终剩下的就是这个数字0
        int res = 0;
        //从增加第2个数字1开始反推，每次往后增加一个数字
        for (int i = 1; i < n; i++) {
            res = (res + m) % (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        _62圆圈中最后剩下的数字 instance = new _62圆圈中最后剩下的数字();
        System.out.println(instance.lastRemaining2(5, 3));
    }
}
