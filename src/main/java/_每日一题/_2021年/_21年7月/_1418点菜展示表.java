package _每日一题._2021年._21年7月;

import java.util.*;

/**
 * @ClassName: _1418点菜展示表
 * @Author: lerry_li
 * @CreateTime: 2021/07/11
 * @Description
 * 解法1：treemap
 */
public class _1418点菜展示表 {
    /**
     * 解法1：treemap
     */
    public List<List<String>> displayTable(List<List<String>> orders) {
        //特判
        if (orders == null || orders.size() == 0) return new ArrayList<>();
        //桌号map，里面保存菜品和数量的map
        TreeMap<Integer, HashMap<String, Integer>> tableMap = new TreeMap<>();
        //菜品set
        TreeSet<String> foodSet = new TreeSet<>();
        //遍历
        for (List<String> order : orders) {
            //桌号
            int tableNo = Integer.parseInt(order.get(1));
            //菜品
            String food = order.get(2);
            foodSet.add(food);
            //当前桌号对应的菜品和数量map
            HashMap<String, Integer> foodNumMap = tableMap.getOrDefault(tableNo, new HashMap<>());
            //对应的菜品+1
            foodNumMap.put(food, foodNumMap.getOrDefault(food, 0) + 1);
            //更新当前桌号的map
            tableMap.put(tableNo, foodNumMap);
        }
        //结果
        List<List<String>> res = new ArrayList<>();
        //添加表头
        List<String> header = new ArrayList<>();
        header.add("Table");
        header.addAll(foodSet);
        res.add(header);
        //遍历桌号map，按菜品set取值
        for (int tableNo : tableMap.keySet()) {
            List<String> curTableList = new ArrayList<>();
            curTableList.add(String.valueOf(tableNo));
            //菜品和数量map
            HashMap<String, Integer> foodNumMap = tableMap.get(tableNo);
            //按表头遍历
            for (int i = 1; i < header.size(); i++) {
                curTableList.add(String.valueOf(foodNumMap.getOrDefault(header.get(i), 0)));
            }
            res.add(curTableList);
        }
        return res;
    }
}
