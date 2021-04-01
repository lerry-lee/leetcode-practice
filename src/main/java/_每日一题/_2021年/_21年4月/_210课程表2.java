package _每日一题._2021年._21年4月;

import java.util.*;

/**
 * @ClassName: _210课程表2
 * @Author: lerry_li
 * @CreateDate: 2021/04/01
 * @Description
 */
public class _210课程表2 {
    /**
     * 解法1：拓扑排序 时间O(N+M) 空间O(N+M)
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //队列，存储入度为0的节点
        Queue<Integer> queue = new LinkedList<>();
        //存储节点的后继结点
        List<HashSet<Integer>> post = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            post.add(new HashSet<>());
        }
        //记录所有节点的入度
        int[] inDegree = new int[numCourses];
        for (int[] em : prerequisites) {
            inDegree[em[0]]++;
            post.get(em[1]).add(em[0]);
        }

        //入度为0的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        //记录成功出队的节点个数
        int courses = 0;
        //记录出队的顺序
        int[] order = new int[numCourses];
        while (!queue.isEmpty()) {
            //每出队一个节点，计数器+1
            Integer cur = queue.poll();
            order[courses] = cur;
            courses++;
            //遍历当前出队节点的后继节点
            for (int postNode : post.get(cur)) {
                //当前节点出队后，其所有的后继节点的入度-1
                inDegree[postNode]--;
                //若某后继节点入度为0，则入队
                if (inDegree[postNode] == 0) {
                    queue.offer(postNode);
                }
            }
        }
        //最终成功出队节点的个数是否等于初始节点的个数
        if (courses == numCourses) {
            return order;
        }
        return new int[]{};
    }
}
