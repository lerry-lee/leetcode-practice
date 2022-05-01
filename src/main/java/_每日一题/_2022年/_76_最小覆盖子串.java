package _每日一题._2022年;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/01
 */
public class _76_最小覆盖子串 {

    public static void main(String[] args) {
        _76_最小覆盖子串 instance=new _76_最小覆盖子串();
        instance.new Solution().minWindow("ADOBECODEBANC","ABC");
    }

    /**
     * 解法1：滑动窗口 时间O(NS) 空间O(S)
     */
    class Solution {
        public String minWindow(String s, String t) {
            if(s==null||t==null||s.length()==0||t.length()==0||s.length()<t.length()) return "";
            Map<Character,Integer> tMap=new HashMap(),freq=new HashMap();
            for(int i=0;i<t.length();i++) tMap.put(t.charAt(i),tMap.getOrDefault(t.charAt(i),0)+1);
            int l=0,r=0;
            int start=0,end=0;
            int minWindow=Integer.MAX_VALUE;
            char[] arr=s.toCharArray();
            while(r<s.length()){
                char rightChar=arr[r];
                freq.put(rightChar,freq.getOrDefault(rightChar,0)+1);
                r++;
                if(isValid(freq,tMap)){
                    while(isValid(freq,tMap)){
                        int count=freq.get(arr[l]);
                        if(count==1){
                            freq.remove(arr[l]);
                        }else{
                            freq.put(arr[l],count-1);
                        }
                        l++;
                    }
                    if(minWindow>r-l+1){
                        minWindow=r-l+1;
                        start=l-1;
                        end=r;
                    }
                }

            }
            if(minWindow==Integer.MAX_VALUE) return "";
            return s.substring(start,end);
        }
        public boolean isValid(Map<Character,Integer> freq,Map<Character,Integer> tMap){
            for(Character key:tMap.keySet()){
                int count=freq.getOrDefault(key,0);
                if(count<tMap.get(key)) return false;
            }
            return true;
        }
    }
}
