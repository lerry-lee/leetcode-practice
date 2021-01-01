package _每日一题._2020年._20年12月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _842将数组拆分成斐波那契序列
 * @Author: lerry_li
 * @CreateDate: 2020/12/18
 * @Description
 */
public class _842将数组拆分成斐波那契序列 {
    /**
     * 解法1：回溯+剪枝
     * 尝试每个数字组合，看看和前面能否组成斐波那契而序列
     * 剪枝：
     *      1. 0开头的数字（单个0除外），直接break
     *      2. 大于INT.MAX，直接break
     *      3. 大于前面两数之和，直接break
     */
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) {
            return res;
        }
        if (dfs(res, S, 0,0)) {
            return res;
        } else {
            return new ArrayList<>();
        }
    }

    public boolean dfs(List<Integer> res, String S, int idx,int lastLen) {
        if (idx >= S.length()) {
            return res.size() > 2;
        }
        boolean flag = false;
        for (int i = idx; i < S.length(); i++) {
            if(res.size()>2&&i-idx<lastLen-1){
                continue;
            }
            if(i>idx&&S.charAt(idx)=='0'){
                break;
            }
            long num = Long.parseLong(S.substring(idx, i + 1));
            if(num>Integer.MAX_VALUE){
                break;
            }
            if (res.size() < 2) {
                if(res.size()==0&&i>S.length()/3+1){
                    break;
                }else if(res.size()==1&&i>2*S.length()/3+1){
                    break;
                }
                res.add((int) num);
                flag = dfs(res, S, i + 1,i-idx+1);
                if (flag) {
                    return true;
                } else {
                    res.remove(res.size() - 1);
                }
            } else {
                int prevSum = res.get(res.size() - 1) + res.get(res.size() - 2);
                if (prevSum == num) {
                    res.add((int) num);
                    flag = dfs(res, S, i + 1,i-idx+1);
                    if (flag) {
                        return true;
                    } else {
                        res.remove(res.size() - 1);
                    }
                } else if (prevSum < num) {
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        _842将数组拆分成斐波那契序列 instance = new _842将数组拆分成斐波那契序列();
        System.out.println(instance.splitIntoFibonacci("1101111"));
        System.out.println(instance.splitIntoFibonacci("0123"));
        System.out.println(instance.splitIntoFibonacci("11235813"));
        System.out.println(instance.splitIntoFibonacci("123456579"));
    }

}
