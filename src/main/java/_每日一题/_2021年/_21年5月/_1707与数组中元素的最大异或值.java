package _每日一题._2021年._21年5月;

/**
 * @ClassName: _1707与数组中元素的最大异或值
 * @Author: lerry_li
 * @CreateDate: 2021/05/23
 * @Description
 */
public class _1707与数组中元素的最大异或值 {
    /**
     * 解法1：暴力 时间O(MN) 空间O(1)
     * @param nums
     * @param queries
     * @return
     */
    public int[] maximizeXor(int[] nums, int[][] queries) {
        //特判
        if(nums==null||nums.length==0||queries==null|| queries.length==0||queries[0].length==0) return new int[]{};
        //枚举
        int n=nums.length,m=queries.length;
        int[] res=new int[m];
        for (int i = 0; i < m; i++) {
            int xi=queries[i][0],mi=queries[i][1];
            int xor=-1;
            for (int j = 0; j < n; j++) {
                if(nums[j]>mi) continue;
                xor=Math.max(xor,xi^nums[j]);
            }
            res[i]=xor;
        }
        return res;
    }

    /**
     * 解法2：字典树 时间O((N+M)L) 空间O(N+L) L是数字的二进制位数
     */
    class Solution {
        public int[] maximizeXor(int[] nums, int[][] queries) {
            Trie trie = new Trie();
            for (int val : nums) {
                trie.insert(val);
            }
            int numQ = queries.length;
            int[] ans = new int[numQ];
            for (int i = 0; i < numQ; ++i) {
                ans[i] = trie.getMaxXorWithLimit(queries[i][0], queries[i][1]);
            }
            return ans;
        }
    }

    class Trie {
        static final int L = 30;
        Trie[] children = new Trie[2];
        int min = Integer.MAX_VALUE;

        public void insert(int val) {
            Trie node = this;
            node.min = Math.min(node.min, val);
            for (int i = L - 1; i >= 0; --i) {
                int bit = (val >> i) & 1;
                if (node.children[bit] == null) {
                    node.children[bit] = new Trie();
                }
                node = node.children[bit];
                node.min = Math.min(node.min, val);
            }
        }

        public int getMaxXorWithLimit(int val, int limit) {
            Trie node = this;
            if (node.min > limit) {
                return -1;
            }
            int ans = 0;
            for (int i = L - 1; i >= 0; --i) {
                int bit = (val >> i) & 1;
                if (node.children[bit ^ 1] != null && node.children[bit ^ 1].min <= limit) {
                    ans |= 1 << i;
                    bit ^= 1;
                }
                node = node.children[bit];
            }
            return ans;
        }
    }

}
