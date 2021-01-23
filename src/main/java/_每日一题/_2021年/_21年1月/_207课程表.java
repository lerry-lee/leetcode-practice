package _每日一题._2021年._21年1月;

import java.util.*;

/**
 * @ClassName: _207课程表
 * @Author: lerry_li
 * @CreateTime: 2021/01/23
 * @Description
 */
public class _207课程表 {
    /**
     * 解法1：拓扑排序
     * @param numCourses 课程数
     * @param prerequisites 先修课程
     * @return 是否可以完成课程学习
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return true;
        }
        //统计入度，初始化入度为0
        Map<Integer, Integer> inDegreeMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            inDegreeMap.put(i, 0);
        }
        //统计课程的后修课程，同时计算入度
        Map<Integer, List<Integer>> afterCourseMap = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            if (!afterCourseMap.containsKey(prerequisite[1])) {
                afterCourseMap.put(prerequisite[1], new ArrayList<>());
            }
            afterCourseMap.get(prerequisite[1]).add(prerequisite[0]);
            //入度+1
            inDegreeMap.put(prerequisite[0], inDegreeMap.get(prerequisite[0]) + 1);
        }

        //遍历所有课程，入度为0的即可学习，并将其后修课程的入度-1
        Queue<Integer> queue = new LinkedList<>();
        int result = 0;
        for (Integer i : inDegreeMap.keySet()) {
            if (inDegreeMap.get(i) == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            inDegreeMap.remove(i);
            result++;
            List<Integer> afterCourse = afterCourseMap.get(i);
            if (afterCourse != null) {
                for (Integer courseI : afterCourse) {
                    int courseI_indegree = inDegreeMap.get(courseI) - 1;
                    inDegreeMap.put(courseI, courseI_indegree);
                    if (courseI_indegree == 0) {
                        queue.offer(courseI);
                    }
                }
            }
        }

        return result == numCourses;

    }


    List<List<Integer>> edges;
    int[] indeg;

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; ++i) {
            edges.add(new ArrayList<Integer>());
        }
        indeg = new int[numCourses];
        for (int[] info : prerequisites) {
            edges.get(info[1]).add(info[0]);
            ++indeg[info[0]];
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }

        int visited = 0;
        while (!queue.isEmpty()) {
            ++visited;
            int u = queue.poll();
            for (int v : edges.get(u)) {
                --indeg[v];
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }

        return visited == numCourses;
    }

    public static void main(String[] args) {
        _207课程表 instance = new _207课程表();
        int[][] a1 = {{1, 0}, {0, 1}};
        int[][] a2 = {{1, 0}};
        System.out.println(instance.canFinish(2, a1));
        System.out.println(instance.canFinish(2, a2));
    }

}
