package DailyExercises._20年11月;

import java.util.*;

/**
 * @ClassName: _127单词接龙
 * @Signature: Created by lerry_li on 2020/11/05
 * @Description: 给定两个单词（beginWord和 endWord）和一个字典，找到从beginWord 到endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 */
public class _127单词接龙 {
    /**
     * 解法1：广度优先遍历 时间O(N*C) 空间O(N) N为单词个数、C为每个单词长度（题目要求单词长度一致）
     * 参考图解，广度优先遍历
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0 || wordList == null || wordList.size() == 0) {
            return 0;
        }
        //单词哈希表
        Set<String> wordSet = new HashSet<>(wordList);
        //防止BFS时出现死循环，用visited记录已经访问过的节点
        Set<String> visited = new HashSet<>();
        //所有单词长度是一致的
        int wordLength = beginWord.length();
        //单词接龙的步数，起点就算1部
        int res = 1;
        //BFS的常用数据结构：双端队列Deque
        Deque<String> deque = new LinkedList<>();
        deque.offerLast(beginWord);
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                //将当前单词保存为字符数组，方便对每一个字母进行替换
                char[] currentWord = deque.pollFirst().toCharArray();
                //枚举当前单词的每一个字母，试着进行26个字母替换
                for (int j = 0; j < wordLength; j++) {
                    //保存当前位置原字母，枚举结束后要还原
                    char originLetter = currentWord[j];
                    //枚举26个字母，替换当前位置的字母
                    for (char k = 'a'; k <= 'z'; k++) {
                        //枚举到原字母则跳过
                        if (k == originLetter) {
                            continue;
                        }
                        //替换当前字母为k表示的字母
                        currentWord[j] = k;
                        //将替换了1个字母后的当前单词转换为String类型
                        String currentWordStr = String.valueOf(currentWord);
                        //单词哈希表中包含该单词并且BFS过程中没有访问过
                        if (wordSet.contains(currentWordStr) && !visited.contains(currentWordStr)) {
                            //若该单词就是endWord，那么可以完成“单词接龙”，返回步数+1
                            if (currentWordStr.equals(endWord)) {
                                return res + 1;
                            }
                            //否则，visited设置访问过该单词
                            visited.add(currentWordStr);
                            //deque队列加入该单词
                            deque.add(currentWordStr);
                        }
                    }
                    //还原当前位置的字母为原字母
                    currentWord[j] = originLetter;
                }
            }
            //队列每次对size个节点进行操作，相当于BFS的一层，因此步数+1
            res++;
        }
        //没有完成“单词接龙”，则返回0
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new _127单词接龙().ladderLength(beginWord, endWord, wordList));
    }
}
