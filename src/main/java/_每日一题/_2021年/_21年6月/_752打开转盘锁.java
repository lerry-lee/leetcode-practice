package _每日一题._2021年._21年6月;

import java.util.*;

/**
 * @ClassName: _752打开转盘锁
 * @Author: lerry_li
 * @CreateDate: 2021/06/26
 * @Description
 * 解法1：BFS
 */
public class _752打开转盘锁 {


    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        _752打开转盘锁 instance = new _752打开转盘锁();
        System.out.println(instance.openLock(deadends, target));
    }

    /**
     * 解法1：BFS
     */


    public int openLock(String[] deadends, String target) {
        //特判
        if (target.equals("0000")) return 0;
        //用哈希表存deadends
        Set<String> deadensSet = new HashSet<>();
        for (String deadend : deadends) deadensSet.add(deadend);
        //若死亡数字就是0000，则直接返回-1
        if (deadensSet.contains("0000")) return -1;
        //初始节点
        String initial = "0000";
        //定义队列
        Queue<String> queue = new LinkedList<>();
        queue.add(initial);
        //去重哈希表
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(initial);
        //记录操作步数
        int step = 0;
        //BFS
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                //枚举状态
                for (String nextStatus : getAccessStatus(cur)) {
                    //没访问过的才访问并且不是死亡数字才访问
                    if (!visitedSet.contains(nextStatus) && !deadensSet.contains(nextStatus)) {
                        //到达终点，则停止
                        if (nextStatus.equals(target)) return step;
                        //否则，加入队列
                        queue.add(nextStatus);
                        visitedSet.add(nextStatus);
                        System.out.println(nextStatus);
                    }
                }
            }
        }
        //否则不行
        return -1;
    }

    private List<String> getAccessStatus(String cur) {
        List<String> res = new ArrayList<>();
        char[] arr = cur.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char origin = arr[i];
//            int rawNum = Integer.parseInt(String.valueOf(origin));
            int up = (origin + 1);
            if (origin == '9') arr[i] = '0';
            else arr[i] = (char) up;
//            if (!visitedSet.contains(new String(arr))) res.add(new String(arr));
            res.add(new String(arr));
            int down = (origin - 1);
            if (origin == '0') arr[i] = '9';
            else arr[i] = (char) down;
//            if (!visitedSet.contains(new String(arr))) res.add(new String(arr));
            res.add(new String(arr));
            arr[i] = origin;
        }
        return res;
    }
}
