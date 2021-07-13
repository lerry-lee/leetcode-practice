package _每日一题._2021年._21年7月;

import java.util.*;

/**
 * @ClassName: _218天际线问题
 * @Author: lerry_li
 * @CreateTime: 2021/07/13
 * @Description
 * 解法1：优先队列
 */
public class _218天际线问题 {
    /**
     * 解法1：优先队列
     */
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        //特判
        if (buildings == null || buildings.length == 0) return res;
        //预处理所有点
        int n = buildings.length;
        List<int[]> points = new ArrayList<>();
        for (int[] building : buildings) {
            //左横坐标left，右横坐标right，高度height
            //对应的点是(left,height),(right,height)
            int left = building[0], right = building[1], height = building[2];
            //为了区分left和right，令left的height为负值
            points.add(new int[]{left, -height});
            points.add(new int[]{right, height});
        }
        //对所有点排序，按最小到大
        points.sort((o1, o2) -> {
            if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
            return Integer.compare(o1[0], o2[0]);
        });
        //大顶堆，存放高度
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        //最开始从高度0开始，这样可以找到第一个出发坐标
        int prev = 0;
        maxHeap.offer(prev);
        //res

        //遍历左右点
        for (int[] point : points) {
            int x = point[0];
            //取出高度
            int height = point[1];
            //若高度<0，说明是左横坐标，那么当前高度需要入队
            if (height < 0) {
                maxHeap.offer(-height);
            }
            //否则，说明是右横坐标，当前高度需要出队(没用了)
            else {
                //todo:可以使用延迟删除
                maxHeap.remove(height);
            }
            //取出当前最大高度，因为比它小的都被遮挡了
            int maxHeight = maxHeap.peek();
            //如果最大高度不是之前的高度，那么可以记录
            if (maxHeight != prev) {
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(maxHeight);
                res.add(list);
                prev = maxHeight;
            }
        }
        return res;
    }
}
