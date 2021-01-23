package _每日一题._2021年._21年1月;

import java.util.*;

/**
 * @ClassName: _210课程表2
 * @Author: lerry_li
 * @CreateTime: 2021/01/23
 * @Description
 */
public class _210课程表2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses < 1) {
            return new int[]{};
        }
        int[] temp = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            temp[i] = i;
        }
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
            return temp;
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

        int[] res = new int[numCourses];

        for (Integer i : inDegreeMap.keySet()) {
            if (inDegreeMap.get(i) == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int i = queue.poll();
            inDegreeMap.remove(i);
            res[result] = i;
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

        if (result == numCourses) {
            return res;
        }
        return new int[]{};
    }
}
