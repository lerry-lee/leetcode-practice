package _每日一题._2021年._21年6月;

import java.util.*;

/**
 * @ClassName: _815公交路线
 * @Author: lerry_li
 * @CreateDate: 2021/07/04
 * @Description
 * 解法1：bfs
 */
public class _815公交路线 {

    public static void main(String[] args) {
        _815公交路线 instance = new _815公交路线();
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};
        int[][] routes2 = {{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}};
        System.out.println(instance.numBusesToDestination(routes2, 15, 12));
    }

    /**
     * 解法1：bfs 时间O(MN) 空间O(MN)
     * tips：
     *      防止超时可以标记路线route是否已经访问过
     */
    public int numBusesToDestination(int[][] routes, int source, int target) {
        //特判
        if (routes == null || routes.length == 0 || routes[0].length == 0) return -1;
        if (source == target) return 0;
        //公交车号->路线
        Map<Integer, List<Integer>> bus2route = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int bus : routes[i]) {
                if (bus2route.containsKey(bus)) {
                    bus2route.get(bus).add(i);
                } else {
                    List<Integer> routeList = new ArrayList<>();
                    routeList.add(i);
                    bus2route.put(bus, routeList);
                }
            }
        }
        //队列
        Queue<Integer> queue = new LinkedList<>();
        //访问过的加入set
        Set<Integer> visited = new HashSet<>();
        //访问过的路线标记为true
        boolean[] flag = new boolean[routes.length];
        //加入初始节点
        queue.offer(source);
        visited.add(source);
        //记录乘坐数量
        int step = 0;
        //bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                //当前bus
                int curBus = queue.poll();
                //枚举可达的所有bus
                for (int route : bus2route.get(curBus)) {
                    //若改路线访问过，跳过
                    if (flag[route]) {
                        continue;
                    }
                    for (int nextBus : routes[route]) {
                        //没有访问过
                        if (!visited.contains(nextBus)) {
                            //达到终点站bus，则退出
                            if (nextBus == target) {
                                return step;
                            }
                            //否则，将可达bus加入queue
                            queue.offer(nextBus);
                            visited.add(nextBus);
                        }
                    }
                    //标记路线已经访问过
                    flag[route] = true;
                }
            }
        }
        return -1;
    }
}
