package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/09
 * @Description
 */
public class _557_反转字符串中的单词3 {
    class Solution {
        public String reverseWords(String s) {
            if(s==null||s.length()==0) return "";
            String[] words=s.split(" ");
            StringBuilder sb=new StringBuilder();
            for(String word:words){
                sb.append(reverse(word)).append(" ");
            }
            return sb.substring(0,sb.length()-1);
        }
        private StringBuilder reverse(String word){
            StringBuilder sb=new StringBuilder();
            for(int i=word.length()-1;i>=0;i--) sb.append(word.charAt(i));
            return sb;
        }
    }
}
