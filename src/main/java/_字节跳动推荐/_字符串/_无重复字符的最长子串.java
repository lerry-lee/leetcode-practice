package _字节跳动推荐._字符串;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/30 09:48
 * @description 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class _无重复字符的最长子串 {
    //hashMap+双指针
    public int lengthOfLongestSubstring(String s){
        HashMap<Character,Integer> map=new HashMap<>();
        int L=0,R=0;
        int max=0;
        while(R<s.length()){
            if (!map.isEmpty() && map.containsKey(s.charAt(R))) {
                //这里尤其要注意：滑动窗口左端更新的时候
                //因为窗口的值没有删除之前的，这里要判断
                //如果比L要小，说明是之前的值，窗口已经略过了
                L = Math.max(L,map.get(s.charAt(R)) + 1);
            }
            System.out.format("L:%d R:%d\n",L,R);
            map.put(s.charAt(R),R);
            R++;
            max=Math.max(max,R-L);
        }
        return max;
    }
    //hashSet+双指针
    public int method_hash_windows(String s){
        HashSet<Character> set=new HashSet<>();
        int i=0,j=0;
        int max=0;
        char[] arr=s.toCharArray();
        while(i<arr.length){
            while(set.isEmpty()||(j<arr.length&&!set.contains(arr[j]))){
                set.add(arr[j]);
                j++;
            }
            if(max<set.size()) max=set.size();

            set.remove(arr[i]);
            i++;

        }
        return max;
    }
}
