package _每日一题._2021年._21年2月;

import java.util.*;

/**
 * @ClassName: _1178猜字谜
 * @Author: lerry_li
 * @CreateTime: 2021/02/26
 * @Description
 */
public class _1178猜字谜 {
    /**
     * 解法1：暴力 时间O(M*N*len) 空间O(S) M为words[]长度,N为puzzles[]长度,len为words[]中单词的长度
     */
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        if (words == null || puzzles == null || words.length == 0 || puzzles.length == 0) {
            return res;
        }
        int[] freq = new int[26];
        for (String puzzle : puzzles) {
            //清空freq[]
            for (int i = 0; i < 26; i++) {
                freq[i] = 0;
            }
            //统计当前谜底的freq[]
            for (int i = 0; i < puzzle.length(); i++) {
                freq[puzzle.charAt(i) - 'a']++;
            }
            //记录第一个字母对应的下标
            int firstLetterIdx = puzzle.charAt(0) - 'a';
            //看words[]有多少word满足条件
            int count = 0;
            for (String word : words) {
                int[] tempFreq = Arrays.copyOf(freq, 26);
                //检查第一个字母是否包含
                boolean firstLetter = false;
                for (int i = 0; i < word.length(); i++) {
                    int idx = word.charAt(i) - 'a';
                    if (tempFreq[idx] == 0) {
                        break;
                    }
                    if (idx == firstLetterIdx) {
                        firstLetter = true;
                    }
                    if (i == word.length() - 1 && firstLetter) {
                        count++;
                    }
                }
            }
            res.add(count);
        }

        return res;
    }

    /**
     * 解法2：二进制状态压缩
     * 思路：
     * 1）用26位二进制数表示一个字符串，其中第i位为1表示包含[i+'a']这个字母
     * 2)枚举二进制数的子集，看words[]中的word是否满足
     * 3）细节
     *      在遍历word时，如果w中包含的1的数量大于7，那么它一定无法作为谜底，因此我们无需将其加入哈希映射中。
     * 4)关键逻辑
     *      subset = (subset - 1) & mask;
     * 复杂度分析：见图解
     */
    public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        if (words == null || puzzles == null || words.length == 0 || puzzles.length == 0) {
            return res;
        }

        //首先为words[]中的word建立二进制状态映射
        Map<Integer, Integer> frequency = new HashMap<>();

        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); ++i) {
                char ch = word.charAt(i);
                mask |= (1 << (ch - 'a'));
            }
            if (Integer.bitCount(mask) <= 7) {
                frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            }
        }

        //然后枚举puzzles[]中的puzzle的二进制状态的子集
        for (String puzzle : puzzles) {
            int total = 0;

            // 枚举子集方法一
            // for (int choose = 0; choose < (1 << 6); ++choose) {
            //     int mask = 0;
            //     for (int i = 0; i < 6; ++i) {
            //         if ((choose & (1 << i)) != 0) {
            //             mask |= (1 << (puzzle.charAt(i + 1) - 'a'));
            //         }
            //     }
            //     mask |= (1 << (puzzle.charAt(0) - 'a'));
            //     if (frequency.containsKey(mask)) {
            //         total += frequency.get(mask);
            //     }
            // }

            // 枚举子集方法二
            // 首先用二进制表示不含首字母的字符串puzzle
            int mask = 0;
            for (int i = 1; i < 7; ++i) {
                mask |= (1 << (puzzle.charAt(i) - 'a'));
            }
            //首先第一个子集赋值为最完整的
            int subset = mask;
            //枚举二进制状态子集的代码
            do {
                //s表示包含首字母的子集
                int s = subset | (1 << (puzzle.charAt(0) - 'a'));
                //若s在hashMap中，那么加上对应的个数
                if (frequency.containsKey(s)) {
                    total += frequency.get(s);
                }
                //子集变动
                subset = (subset - 1) & mask;
            } while (subset != mask);

            res.add(total);
        }

        return res;

    }

    public static void main(String[] args) {
        _1178猜字谜 instance = new _1178猜字谜();
        String[] words = {"aaaa", "asas", "able", "ability", "actt", "actor", "access"};
        String[] puzzles = {"aboveyz", "abrodyz", "abslute", "absoryz", "actresz", "gaswxyz"};
        System.out.println(instance.findNumOfValidWords(words, puzzles));

    }
}
