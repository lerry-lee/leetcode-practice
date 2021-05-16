package _每日一题._2021年._21年5月;

/**
 * @ClassName: _421数组中两个数的最大异或值
 * @Author: lerry_li
 * @CreateDate: 2021/05/16
 * @Description 解法1：暴力枚举
 * 解法2：字典树
 */
public class _421数组中两个数的最大异或值 {
    /**
     * 解法1：暴力枚举 时间O(N^2) 空间O(1)
     */
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i + 1; j < nums.length; j++) {
                temp = Math.max(nums[i] ^ nums[j], temp);
            }
            res = Math.max(res, temp);
        }
        return res;
    }

    /**
     * 解法2：字典树 时间O(N) 空间O(N)
     */
    static class Node {
        Node[] ns = new Node[2];
    }

    Node root = new Node();

    //将x加入字典树，从高位到低位枚举
    void add(int x) {
        //字典树根节点
        Node p = root;
        //从高位到低位枚举
        for (int i = 31; i >= 0; i--) {
            //枚举当前位，0/1
            int u = (x >> i) & 1;
            //若当前位表示的节点为空，新建
            if (p.ns[u] == null) p.ns[u] = new Node();
            //当前节点更新
            p = p.ns[u];
        }
    }

    //获得字典树中的与x异或值最大的存储的数值(即一条从根节点到叶节点的路径)
    int getVal(int x) {
        //路径表示的数值
        int ans = 0;
        //根节点
        Node p = root;
        //从高位到低位枚举x的每一位
        for (int i = 31; i >= 0; i--) {
            //a为当前位
            // 若a为0则b为1，若a为1则b为0，这样a^b就始终为1
            int a = (x >> i) & 1, b = 1 - a;
            //若b表示节点存在，则走b节点的分支
            if (p.ns[b] != null) {
                //异或结果填充该位，相当于第i位置为b
                ans |= (b << i);
                //当前节点更新
                p = p.ns[b];
            }
            //否则，走a节点的分支
            else {
                ans |= (a << i);
                p = p.ns[a];
            }
        }
        //返结果
        return ans;
    }

    public int findMaximumXOR2(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            add(num);
            int j = getVal(num);
            ans = Math.max(ans, num ^ j);
        }
        return ans;
    }

}
