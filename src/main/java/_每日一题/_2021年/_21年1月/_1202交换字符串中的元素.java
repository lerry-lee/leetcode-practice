package _每日一题._2021年._21年1月;

import java.util.*;

/**
 * @ClassName: _1202交换字符串中的元素
 * @Author: lerry_li
 * @CreateTime: 2021/01/23
 * @Description
 */
public class _1202交换字符串中的元素 {
    /**
     * 解法1：并查集
     * 思路：
     *      1.遍历所有字符，建立连通图
     *      2.遍历所有字符，把根节点相同的字符放到一个优先队列里
     *      3.遍历所有字符，每次取出对应优先队列的最小值放到该下标处
     */
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (s == null || s.length() == 0 || pairs == null || pairs.size() == 0) {
            return s;
        }
        int n = s.length();
        UnionFind unionFind = new UnionFind(n);

        for (List<Integer> pair : pairs) {
            unionFind.union(pair.get(0), pair.get(1));
        }

        //按子集找
        //按子集中的元素 字典序排序
        //将子集中的元素 建立<根节点，子集>的hash映射，子集里面的元素使用优先队列
        //每次取出子集中最小的元素即可
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            int rootI = unionFind.find(i);
            if (!hashMap.containsKey(rootI)) {
                hashMap.put(rootI, new PriorityQueue<>());
            }
            hashMap.get(rootI).add(c);
        }
        for (int i = 0; i < n; i++) {
            int rootI = unionFind.find(i);
            stringBuilder.append(hashMap.get(rootI).poll());
        }

        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        _1202交换字符串中的元素 instance = new _1202交换字符串中的元素();
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();

        List<Integer> list = Arrays.asList(0, 3);
        pairs.add(list);

        list = Arrays.asList(1, 2);
        pairs.add(list);

        list = Arrays.asList(0, 2);
        pairs.add(list);

        System.out.println(instance.smallestStringWithSwaps(s, pairs));

    }

    class UnionFind {
        //父节点
        private int[] parent;
        //子集大小
        private int[] size;
        //子集的数量
        private int count;
//        //子集的元素
//        private List<List<Integer>> subSets;

        //初始化并查集中的n个节点
        public UnionFind(int n) {
            this.parent = new int[n];
            this.size = new int[n];
            this.count = n;

            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.size[i] = 1;
            }

        }

        //查找节点的根节点
        public int find(int x) {
            while (x != parent[x]) {
                x = parent[x];
            }
            return x;
        }

        //联通两个节点，同时执行路径压缩
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            //小的接到大的上
            if (size[rootX] > size[rootY]) {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            } else {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            }
            this.count--;
        }


        //返回子集的数量
        public int getCount() {
            return this.count;
        }
    }
}
