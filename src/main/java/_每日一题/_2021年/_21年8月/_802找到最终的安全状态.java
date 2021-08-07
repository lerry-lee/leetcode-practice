package _每日一题._2021年._21年8月;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName: _802找到最终的安全状态
 * @Author: lerry_li
 * @CreateDate: 2021/08/05
 * @Description
 */
public class _802找到最终的安全状态 {

    public static void main(String[] args) {
        _802找到最终的安全状态 instance=new _802找到最终的安全状态();
        System.out.println(instance.eventualSafeNodes(new int[][]{{},{0,2,3,4},{3},{4},{}}));
    }

    /**
     * 解法1：dfs
     * 解法2：bfs
     * 解法3：拓扑排序 时间O(M+N) 空间O(M+N)
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> rg = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            rg.add(new ArrayList<Integer>());
        }
        //入度数组，inDegree[i]表示节点i的入度值
        int[] inDegree = new int[n];
        for (int x = 0; x < n; ++x) {
            //建立反图
            //原本graph[x]表示x的后继节点，现在则是x的前驱节点
            for (int y : graph[x]) {
                rg.get(y).add(x);
            }
            //节点x的入度值
            inDegree[x] = graph[x].length;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        //将所有入度为0的节点加入队列
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            //取出当前节点
            int y = queue.poll();
            //遍历所有后继结点
            for (int x : rg.get(y)) {
                //后继结点的入度-1
                //若入度为0，则加入队列
                if (--inDegree[x] == 0) {
                    queue.offer(x);
                }
            }
        }
        //结果集
        List<Integer> ans = new ArrayList<Integer>();
        //最终入度为0的节点即是安全节点
        for (int i = 0; i < n; ++i) {
            if (inDegree[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }
}
