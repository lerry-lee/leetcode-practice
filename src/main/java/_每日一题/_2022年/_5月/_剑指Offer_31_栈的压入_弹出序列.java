package _每日一题._2022年._5月;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _剑指Offer_31_栈的压入_弹出序列 {

    class Solution {

        public boolean validateStackSequences(int[] pushed, int[] popped) {
            if (pushed == null) return popped == null;
            if (popped == null) return false;
            if (pushed.length == 0) return popped.length == 0;
            if (popped.length == 0) return false;
            int i=0;
            Deque<Integer> stack = new ArrayDeque<>();
            for(int num:pushed){
                stack.addLast(num);
                while(!stack.isEmpty()&&stack.peekLast()==popped[i]){
                    stack.removeLast();
                    i++;
                }
            }
            return stack.isEmpty();
        }
    }
}
