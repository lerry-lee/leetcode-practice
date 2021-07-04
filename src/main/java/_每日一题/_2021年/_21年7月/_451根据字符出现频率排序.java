package _每日一题._2021年._21年7月;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: _451根据字符出现频率排序
 * @Author: lerry_li
 * @CreateDate: 2021/07/04
 * @Description
 * 解法1：暴力
 * 解法2：桶排序
 */
public class _451根据字符出现频率排序 {

    public static void main(String[] args) {
        _451根据字符出现频率排序 instance = new _451根据字符出现频率排序();
        System.out.println(instance.frequencySort2("tree"));
        System.out.println(instance.frequencySort2("cccaaa"));
        System.out.println(instance.frequencySort2("Aabb"));
    }

    /**
     * 解法1：暴力 时间O(NK) 空间O(N)
     */
    public String frequencySort(String s) {
        //特判
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hashMap.put(s.charAt(i), hashMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        //遍历每次找最大的
        char cur = 'a';
        int freq = 0;
        while (!hashMap.isEmpty()) {
            for (char key : hashMap.keySet()) {
                if (freq < hashMap.get(key)) {
                    cur = key;
                    freq = hashMap.get(key);
                }
            }
            while (freq > 0) {
                sb.append(cur);
                freq--;
            }
            hashMap.remove(cur);
            freq = 0;
        }
        return sb.toString();
    }

    /**
     * 解法2：桶排序 时间O(N+K) 空间O(N+K)
     * 思路：（空间换时间）
     *      1.首先用map记录字符及出现频次
     *      2.对每个频次建立一个桶，把对应聘次的字符放到桶内
     *      3.从大到小遍历桶，把里面的字符取出来
     */
    public String frequencySort2(String s) {
        //特判
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < s.length(); i++) {
            int freq = freqMap.getOrDefault(s.charAt(i), 0) + 1;
            if (maxFreq < freq) {
                maxFreq = freq;
            }
            freqMap.put(s.charAt(i), freq);
        }
        //建立桶
        StringBuilder[] buckets = new StringBuilder[maxFreq + 1];
        //桶内添加对应元素
        for (char key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (buckets[freq] == null) buckets[freq] = new StringBuilder();
            for (int i = 0; i < freq; i++) {
                buckets[freq].append(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        //从大到小遍历桶
        for (int i = maxFreq; i > 0; i--) {
            //桶无为空才取出元素
            if (buckets[i] != null) {
                sb.append(buckets[i]);
            }
        }
        return sb.toString();
    }
}
