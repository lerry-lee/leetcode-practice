package _每日一题._2021年._21年7月;

import java.util.*;

/**
 * @ClassName: _面试题10_02_变位词组
 * @Author: lerry_li
 * @CreateDate: 2021/07/18
 * @Description
 */
public class _面试题10_02_变位词组 {
    /**
     * 解法1：暴力枚举+hash+排序 时间O(NKlogK) 空间O(N)
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        //特判
        if (strs == null || strs.length == 0) return new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String orderStr = String.valueOf(arr);
            List<String> tempList = hashMap.getOrDefault(orderStr, new ArrayList<>());
            tempList.add(str);
            hashMap.put(orderStr, tempList);
        }
        //遍历map
        for (String key : hashMap.keySet()) {
            res.add(hashMap.get(key));
        }
        return res;
    }
}
