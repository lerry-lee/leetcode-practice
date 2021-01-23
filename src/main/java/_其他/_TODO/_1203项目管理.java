package _其他._TODO;

import java.util.*;

/**
 * @ClassName: _1203项目管理
 * @Author: lerry_li
 * @CreateTime: 2021/01/23
 * @Description
 */
public class _1203项目管理 {
    /**
     * 拓扑排序+分组管理
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        //第1步：数据预处理，给没有组的项目编上组号
        /**
         * 根据题意，group[i] = -1 表示编号为 i 的项目，不属于编号为 0 到 m - 1 的这 m 个组，换句话说，完成这些项目不需要协同合作。
         *
         * 又因为我们需要根据「组」的先后顺序得到「组的拓扑排序的结果」。为了避免我们设计的算法认为 group[i] = -1 的这些项目都在同一组，因此给 group[i] = -1 的这些组一个不同于 0 到 m - 1 的编号，从 m 开始逐个给每个项目编号即可。
         *
         */
        for (int i = 0; i < group.length; i++) {
            if (group[i] == -1) {
                group[i] = m;
                m++;
            }
        }

        //第2步：实例化组和项目的邻接表
        List<Integer>[] groupAdj = new ArrayList[m];
        List<Integer>[] itemAdj = new ArrayList[n];
        for (int i = 0; i < m; i++) {
            groupAdj[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            itemAdj[i] = new ArrayList<>();
        }

        //第3步：建图和统计入度数组
        int[] groupsIndegree = new int[m];
        int[] itemsIndegree = new int[n];

        int len = group.length;
        for (int i = 0; i < len; i++) {
            int currentGroup = group[i];
            for (int beforeItem : beforeItems.get(i)) {
                int beforeGroup = group[beforeItem];
                if (beforeGroup != currentGroup) {
                    groupAdj[beforeGroup].add(currentGroup);
                    groupsIndegree[currentGroup]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int item : beforeItems.get(i)) {
                itemAdj[item].add(i);
                itemsIndegree[i]++;
            }
        }

        // 第 4 步：得到组和项目的拓扑排序结果
        List<Integer> groupsList = topologicalSort(groupAdj, groupsIndegree, m);
        if (groupsList.size() == 0) {
            return new int[0];
        }
        List<Integer> itemsList = topologicalSort(itemAdj, itemsIndegree, n);
        if (itemsList.size() == 0) {
            return new int[0];
        }

        // 第 5 步：根据项目的拓扑排序结果，项目到组的多对一关系，建立组到项目的一对多关系
        // key：组，value：在同一组的项目列表
        Map<Integer, List<Integer>> groups2Items = new HashMap<>();
        for (Integer item : itemsList) {
            groups2Items.computeIfAbsent(group[item], key -> new ArrayList<>()).add(item);
        }

        // 第 6 步：把组的拓扑排序结果替换成为项目的拓扑排序结果
        List<Integer> res = new ArrayList<>();
        for (Integer groupId : groupsList) {
            List<Integer> items = groups2Items.getOrDefault(groupId, new ArrayList<>());
            res.addAll(items);
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();

    }

    private List<Integer> topologicalSort(List<Integer>[] adj, int[] inDegree, int n) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer front = queue.poll();
            res.add(front);
            for (int successor : adj[front]) {
                inDegree[successor]--;
                if (inDegree[successor] == 0) {
                    queue.offer(successor);
                }
            }
        }

        if (res.size() == n) {
            return res;
        }
        return new ArrayList<>();
    }

}
