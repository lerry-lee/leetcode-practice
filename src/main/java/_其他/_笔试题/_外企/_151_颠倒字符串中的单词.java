package _其他._笔试题._外企;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/17
 * @Description
 */
public class _151_颠倒字符串中的单词 {
    /**
     * 解法1：直接做
     */
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=words.length-1;i>=0;i--){
            if(words[i].equals("")) continue;
            sb.append(words[i]).append(" ");
        }
        return sb.substring(0,sb.length()-1);
    }
}
