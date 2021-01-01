package _每日一题._2020年._20年8月;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/08/04 19:59
 * @description 课程表
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * <p>
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * <p>
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 */
public class _207课程表 {
    /**
     * 解法：参考题解（关键词：拓扑排序，入度，后继结点）
     * 方法一：入度表（广度优先遍历）
     * 算法流程：
     * 统计课程安排图中每个节点的入度，生成 入度表 indegrees。
     * 借助一个队列 queue，将所有入度为 00 的节点入队。
     * 当 queue 非空时，依次将队首节点出队，在课程安排图中删除此节点 pre：
     * 并不是真正从邻接表中删除此节点 pre，而是将此节点对应所有邻接节点 cur 的入度 -1−1，即 indegrees[cur] -= 1。
     * 当入度 -1−1后邻接节点 cur 的入度为 00，说明 cur 所有的前驱节点已经被 “删除”，此时将 cur 入队。
     * 在每次 pre 出队时，执行 numCourses--；
     * 若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 00。
     * 因此，拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排。
     * 复杂度分析：
     * 时间复杂度 O(N + M)O(N+M)： 遍历一个图需要访问所有节点和所有临边，NN 和 MM 分别为节点数量和临边数量；
     * 空间复杂度 O(N + M)O(N+M)： 为建立邻接表所需额外空间，adjacency 长度为 NN ，并存储 MM 条临边的数据。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> backCourses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) backCourses.add(new ArrayList<>());
        for (int[] em : prerequisites) {
            inDegree[em[0]]++;
            backCourses.get(em[1]).add(em[0]);
        }
        Queue<Integer> que = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) que.offer(i);
        }
        while (!que.isEmpty()) {
            int curCourse = que.poll();
            numCourses--;
            List<Integer> curCourse_backCourse = backCourses.get(curCourse);
            for (int i = 0; i < curCourse_backCourse.size(); i++) {
                int preCourse = curCourse_backCourse.get(i);
                inDegree[preCourse]--;
                if (inDegree[preCourse] == 0) que.offer(preCourse);
            }
        }
        return numCourses == 0;

    }
}
