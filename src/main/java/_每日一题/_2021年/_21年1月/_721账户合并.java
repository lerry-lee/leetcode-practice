package _每日一题._2021年._21年1月;

import java.util.*;

/**
 * @ClassName: _721账户合并
 * @Author: lerry_li
 * @CreateDate: 2021/01/26
 * @Description
 */
public class _721账户合并 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }
        UnionFind unionFind = new UnionFind();
        Map<String, Integer> mapIndices = new HashMap<>();
        Map<String, String> mapNames = new HashMap<>();
        int idx = 0;
        for (List<String> emails : accounts) {
//            boolean flag = false;
//            int index = 0;
            for (int i = 1; i < emails.size(); i++) {
                String email = emails.get(i);
                int index = 0;
                if (mapIndices.containsKey(email)) {
                    index = mapIndices.get(email);
//                    flag = true;
                } else {
                    index = idx;
                    mapIndices.put(email, index);
                    mapNames.put(email, emails.get(0));
                    idx++;
                }
                int index2 = index;
                if (i == emails.size() - 1) {
                } else {
                    String email2 = emails.get(i + 1);

                    if (mapIndices.containsKey(email2)) {
                        index2 = mapIndices.get(email2);
//                    flag = true;
                    } else {
                        index2 = idx;
                        mapIndices.put(email2, index2);
                        mapNames.put(email2, emails.get(0));
                        idx++;
                    }
                }
                unionFind.union(index, index2);
            }
        }

        Map<Integer, List<String>> resMap = new HashMap<>();


        Map<Integer, String> nameIndex = new HashMap<>();
        for (String email : mapIndices.keySet()) {
            String name = mapNames.get(email);
            int index = unionFind.find(mapIndices.get(email));
            if (nameIndex.containsKey(index)) {

            } else {
                nameIndex.put(index, name);
                resMap.put(index, new ArrayList<>());
            }
            resMap.get(index).add(email);
        }

        for (Integer index : resMap.keySet()) {
            List<String> list = resMap.get(index);
            Collections.sort(list);
            list.add(0, nameIndex.get(index));
            res.add(list);
        }

        return res;

    }

    class UnionFind {
        private Map<Integer, Integer> parent;

        public UnionFind() {
            this.parent = new HashMap<>();
        }

        public int find(int x) {

            if (!parent.containsKey(x)) {
                parent.put(x, x);
            }

            if (x != parent.get(x)) {
                parent.put(x, find(parent.get(x)));
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent.put(rootX, rootY);
        }
    }

    public static void main(String[] args) {
        _721账户合并 instance = new _721账户合并();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        System.out.println(instance.accountsMerge(accounts));

    }
}
