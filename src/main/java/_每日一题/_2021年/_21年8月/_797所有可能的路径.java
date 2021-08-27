package _每日一题._2021年._21年8月;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateDate: 2021/08/25
 */
public class _797所有可能的路径 {

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path=new ArrayList<>();

    /**
     * 解法1：dfs
     */
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //特判
        if(graph==null||graph.length==0) return res;
        path.add(0);
        dfs(graph, 0, graph.length - 1);
        return res;
    }

    //递归
    //graph[i]存的是节点i的后继结点
    //cur表示当前的节点
    //tar表示目标节点
    //path表示当前遍历路径
    public void dfs(int[][] graph, int cur, int tar) {
        //如果cur==tar，到达目标节点，输出当前可行路径到res
        if (cur == tar) {
            res.add(new ArrayList<>(path));
            return;
        }
        //否则，遍历cur的后继结点
        for (int next : graph[cur]) {
            path.add(next);
            dfs(graph, next, tar);
            path.remove(path.size() - 1);
        }
    }
}
