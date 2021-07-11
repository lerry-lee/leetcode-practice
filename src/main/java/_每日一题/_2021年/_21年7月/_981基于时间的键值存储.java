package _每日一题._2021年._21年7月;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @ClassName: _981基于时间的键值存储
 * @Author: lerry_li
 * @CreateTime: 2021/07/11
 * @Description
 * 解法1：treemap
 */
public class _981基于时间的键值存储 {

    public static void main(String[] args) {
        _981基于时间的键值存储 instance = new _981基于时间的键值存储();
        TimeMap obj = instance.new TimeMap();
        obj.set("love", "high", 10);
        obj.set("love", "low", 20);
        System.out.println(obj.get("love", 5));
        System.out.println(obj.get("love", 10));
        System.out.println(obj.get("love", 15));
        System.out.println(obj.get("love", 20));
        System.out.println(obj.get("love", 25));
    }


    /**
     * 解法1：treemap
     */
    class TimeMap {
        private Map<String, TreeMap<Integer, String>> timeMap;

        /** Initialize your data structure here. */
        public TimeMap() {
            timeMap = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> treeMap = timeMap.getOrDefault(key, new TreeMap<>());
            treeMap.put(timestamp, value);
            timeMap.put(key, treeMap);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = timeMap.get(key);
            if (treeMap == null) return "";
            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
            if (entry == null) return "";
            return entry.getValue();
        }
    }
}
