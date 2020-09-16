package _腾讯推荐._数组与字符串;

/**
 * @ClassName : _最长公共前缀
 * @CreateTime : 2020/09/16 22
 * @Author : lerry_li
 * @Descrpition : 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母。
 *
 */
public class _最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0) return "";
        String shortest_word=strs[0];
        for(String word:strs){
            if(word.length()<shortest_word.length()){
                shortest_word=word;
            }
        }
        StringBuilder longest_prefix=new StringBuilder("");
        for(int i=0;i<shortest_word.length();i++){
            char c=shortest_word.charAt(i);
            for(String word:strs){
                if(word.charAt(i)!=c) return longest_prefix.toString();
            }
            longest_prefix.append(c);
        }
        return longest_prefix.toString();
    }
}
