package _每日一题._2022年._5月;

import java.util.PriorityQueue;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _767_重构字符串 {
    /**
     * 解法1：大顶堆（按频次排序，堆存的却是字符） 时间O(NlogS+S) 空间O(S) S表示字符集的大小
     */
    class Solution {
        public String reorganizeString(String s) {
            //特判
            if (s == null || s.length() == 0) return "";
            char[] arr = s.toCharArray();
            int[] freq = new int[26];
            //统计频数
            int maxCnt = 0;
            for (char c : arr) {
                freq[c - 'a']++;
                maxCnt = Math.max(maxCnt, freq[c - 'a']);
            }
            //如果有某个字符的频次超过了半数，则返回空，表示无解
            //例如：3个元素不能超过2；4个不能超过2
            if (maxCnt > (arr.length + 1) / 2) return "";
            //大顶堆，按频次排序
            //【注意】：这里用到了外部变量freq[]，如何实现的？还有一种写法，新建一个数据结构{char,int}表示字符及它的频次，这样就可以用自身属性排序了。
            PriorityQueue<Character> maxHeap = new PriorityQueue<>(((o1, o2) -> Integer.compare(freq[o2 - 'a'], freq[o1 - 'a'])));
            //将元素按字母加入大顶堆
            for (char c = 'a'; c <= 'z'; c++) {
                if (freq[c - 'a'] > 0) {
                    maxHeap.add(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            //处理大顶堆，只要里面有2个以上元素
            while (maxHeap.size() >= 2) {
                //每次取出两个元素
                char letter1 = maxHeap.poll();
                char letter2 = maxHeap.poll();
                //这俩元素不同，加入结果字符串
                sb.append(letter1).append(letter2);
                //频次-1
                freq[letter1 - 'a']--;
                freq[letter2 - 'a']--;
                //如果频次大于0，继续加入大顶堆
                if (freq[letter1 - 'a'] > 0) {
                    maxHeap.add(letter1);
                }
                if (freq[letter2 - 'a'] > 0) {
                    maxHeap.add(letter2);
                }
            }
            //如果最后大顶堆里还有元素，则必只有1个
            if (!maxHeap.isEmpty()) {
                sb.append(maxHeap.poll());
            }
            return sb.toString();
        }
    }
}
