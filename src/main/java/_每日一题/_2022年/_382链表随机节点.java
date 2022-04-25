package _每日一题._2022年;

import _数据结构.ListNode;

import java.util.Random;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/25
 * @Description
 */
public class _382链表随机节点 {
    /**
     * 解法1：哈希表
     * 解法2：水塘抽样 https://leetcode-cn.com/problems/linked-list-random-node/solution/lian-biao-sui-ji-jie-dian-by-leetcode-so-x6it/
     */
    class Solution {
        ListNode head;
        Random random;

        public Solution(ListNode head) {
            this.head = head;
            random = new Random();
        }

        public int getRandom() {
            int i = 1, ans = 0;
            for (ListNode node = head; node != null; node = node.next) {
                if (random.nextInt(i) == 0) { // 1/i 的概率选中（替换为答案）
                    ans = node.val;
                }
                ++i;
            }
            return ans;
        }
    }
}
