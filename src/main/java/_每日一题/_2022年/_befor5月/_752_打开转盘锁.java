package _每日一题._2022年._befor5月;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/29
 * @Description
 */
public class _752_打开转盘锁 {

    public static void main(String[] args) {
        _752_打开转盘锁 instance = new _752_打开转盘锁();
        String[] deadens = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        instance.new Solution().openLock(deadens, target);
    }

    /**
     * 解法1：bfs
     */
    class Solution {
        public int openLock(String[] deadends, String target) {
            if (Objects.equals(target, "0000")) return 0;
            Set<String> deadSet = new HashSet<>();
            Set<String> visited = new HashSet<>();
            Collections.addAll(deadSet, deadends);
            if (deadSet.contains(target)||deadSet.contains("0000")) return -1;
            Queue<String> queue = new LinkedList<>();
            queue.add("0000");
            visited.add("0000");
            int res = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String nums = queue.remove();
                    for (String nextNums : getNextNums(nums)) {
                        if (deadSet.contains(nextNums) || visited.contains(nextNums)) continue;
                        if (nextNums.equals(target)) return res + 1;
                        visited.add(nextNums);
                        queue.add(nextNums);
                    }
                }
                res++;
            }
            return -1;
        }

        public String[] getNextNums(String nums) {
            char[] arr = nums.toCharArray();
            String[] nextNums = new String[8];
            int idx = 0;
            for (int i = 0; i < 4; i++) {
                char raw = arr[i];
                arr[i] = addOne(raw);
                nextNums[idx++] = String.valueOf(arr);
                arr[i] = subOne(raw);
                nextNums[idx++] = String.valueOf(arr);
                arr[i] = raw;
            }
            return nextNums;
        }

        public Character addOne(char c) {
            switch (c) {
                case '0':
                    return '1';
                case '1':
                    return '2';
                case '2':
                    return '3';
                case '3':
                    return '4';
                case '4':
                    return '5';
                case '5':
                    return '6';
                case '6':
                    return '7';
                case '7':
                    return '8';
                case '8':
                    return '9';
                case '9':
                    return '0';
                default:
                    return null;
            }
        }


        public Character subOne(char c) {
            switch (c) {
                case '0':
                    return '9';
                case '1':
                    return '0';
                case '2':
                    return '1';
                case '3':
                    return '2';
                case '4':
                    return '3';
                case '5':
                    return '4';
                case '6':
                    return '5';
                case '7':
                    return '6';
                case '8':
                    return '7';
                case '9':
                    return '8';
                default:
                    return null;
            }
        }
    }
}
