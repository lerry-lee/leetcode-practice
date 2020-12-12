package _腾讯推荐._数组与字符串;

/**
 * @ClassName : _反转字符串中的单词3
 * @CreateTime : 2020/09/22 11
 * @Author : lerry_li
 * @Descrpition : 反转字符串中的每个单词
 * 例：
 * 输入："Let's take LeetCode contest"
 * 返回：“s'teL ekat edoCteeL tsetnoc”
 */
public class _反转字符串中的单词3 {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            words[i] = wordsReverse(words[i]);
        }
        return String.join(" ", words);
    }

    public String wordsReverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
