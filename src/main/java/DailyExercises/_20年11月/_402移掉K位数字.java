package DailyExercises._20年11月;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: _移掉K位数字
 * @Signature: Created by lerry_li on 2020/11/15
 * @Description:
 */
public class _402移掉K位数字 {
    /**
     * 解法1：贪心+单调栈 时间O(N) 空间O(N)
     * 举例说明算法：
     * num=1432219,k=3
     * 1.遍历num，加入队列
     * 1)[1],k=3
     * 2)[1,4],k=3
     * 3)[1,3],k=2
     * 4)[1,2],k=1
     * 5)[1,2,2],k=0
     * 6)[1,2,2,1],k=0
     * 7)[1,2,2,1,9],k=0
     * 2.k=0，不必移掉队尾k个元素
     * 3.生成结果
     * 1)"1"
     * 2)"12"
     * 3)"122"
     * 4)"1221"
     * 5)"12219"
     */
    public String removeKdigits(String num, int k) {
        if (k == num.length()) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        //遍历num的每一位，从高位到低位
        for (int i = 0; i < length; ++i) {
            char digit = num.charAt(i);
            //如果deque不为空，并且k>0(还有数可以移掉)，并且当前数字比deque的队尾数字要小
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                //弹出deque的队尾数字，因为一大一小肯定移掉大的，剩下的数字小
                deque.pollLast();
                //可以移掉的数字减1,
                k--;
            }
            //把当前位数字加入队尾
            deque.offerLast(digit);
        }
        //遍历完num后，若仍然k>0，则移掉deque队尾的k个元素
        for (int i = 0; i < k; ++i) {
            deque.pollLast();
        }
        //生成结果
        StringBuilder ret = new StringBuilder();
        //判断是否是0开头
        boolean leadingZero = true;
        //从队首依次取出
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            //如果是0开头，那么跳过，不加入结果
            if (leadingZero && digit == '0') {
                continue;
            }
            //如果开头不为0，标记false
            leadingZero = false;
            //添加到结果
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }

}
