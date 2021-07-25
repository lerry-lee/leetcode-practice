package _每日一题._2021年._21年7月;

import java.util.*;

/**
 * @ClassName: _1743从相邻元素对还原数组
 * @Author: lerry_li
 * @CreateDate: 2021/07/25
 * @Description
 */
public class _1743从相邻元素对还原数组 {

    public static void main(String[] args) {
        _1743从相邻元素对还原数组 instance = new _1743从相邻元素对还原数组();
        int[][] adj = {{2, 1}, {3, 4}, {3, 2}};
        System.out.println(Arrays.toString(instance.restoreArray(adj)));
    }

    /**
     * 解法1：hash表 时间O(N) 空间O(N)
     */
    public int[] restoreArray(int[][] adjacentPairs) {
        //特判
        if (adjacentPairs == null || adjacentPairs.length == 0 || adjacentPairs[0].length == 0) return new int[]{};
        int n = adjacentPairs.length - 1;
        int[] res = new int[n];
        //hashmap记录每个元素及其相邻的元素
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int[] adj : adjacentPairs) {
            List<Integer> adjList0 = hashMap.getOrDefault(adj[0], new ArrayList<>());
            List<Integer> adjList1 = hashMap.getOrDefault(adj[1], new ArrayList<>());
            adjList0.add(adj[1]);
            adjList1.add(adj[0]);
            hashMap.put(adj[0],adjList0);
            hashMap.put(adj[1],adjList1);
        }
        //找第一个元素
        for (Integer key : hashMap.keySet()) {
            if (hashMap.get(key).size() == 1) {
                res[0] = key;
                break;
            }
        }
        //填第二个元素
        res[1] = hashMap.get(res[0]).get(0);
        //往后找
        for (int i = 2; i < n; i++) {
            //相邻元素list
            List<Integer> adjList = hashMap.get(res[i - 1]);
            if (adjList.get(0) == res[i - 2]) {
                res[i] = adjList.get(1);
            } else {
                res[i] = adjList.get(0);
            }
        }
        return res;
    }
}
