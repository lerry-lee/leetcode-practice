package _每日一题._2022年;

import java.util.*;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/28
 * @Description
 */
public class _210_课程表2 {

    public static void main(String[] args) {
        _210_课程表2 instance = new _210_课程表2();
        //3
        //[[1,0],[1,2],[0,1]]
        instance.new Solution().findOrder(2, new int[][]{{1, 0}});
    }
    /**
     * 解法1：拓扑排序 时间O(N+M) 空间O(N+M)
     */
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            if (numCourses <= 0) return new int[]{};
            int[] degree = new int[numCourses];
            Map<Integer, HashSet<Integer>> postCources = new HashMap<>();
            for (int[] arr : prerequisites) {
                degree[arr[0]]++;
                HashSet<Integer> posts = postCources.getOrDefault(arr[1], new HashSet<>());
                posts.add(arr[0]);
                postCources.put(arr[1], posts);
            }
            Queue<Integer> queue = new LinkedList();
            int[] res = new int[numCourses];
            int idx = 0;
            for (int i = 0; i < numCourses; i++) {
                if (degree[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int courseI = queue.remove();
                    res[idx++] = courseI;
                    for (int postI : postCources.getOrDefault(courseI,new HashSet<>())) {
                        degree[postI]--;
                        if (degree[postI] == 0) queue.add(postI);
                    }
                }
            }
            if (idx == numCourses) return res;
            return new int[]{};
        }
    }
}
