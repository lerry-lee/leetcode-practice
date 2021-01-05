package _每日一题._2021年._21年1月;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _830较大分组的位置
 * @Author: lerry_li
 * @CreateDate: 2021/01/05
 * @Description
 */
public class _830较大分组的位置 {
    /**
     * 解法1：直接遍历 时间O(N) 空间O(1)
     */
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        int prevI=0;
        char prevC=s.charAt(0);
        int count=1;
        for (int i = 1; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c==prevC){
                count++;
            }else{
                if(count>=3){
                    res.add(Arrays.asList(prevI,i-1));
                }
                count=1;
                prevI=i;
                prevC=c;
            }
        }
        if(count>=3){
            res.add(Arrays.asList(prevI,s.length()-1));
        }
        return res;
    }

    public static void main(String[] args) {
        _830较大分组的位置 instance = new _830较大分组的位置();
        System.out.println(instance.largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
