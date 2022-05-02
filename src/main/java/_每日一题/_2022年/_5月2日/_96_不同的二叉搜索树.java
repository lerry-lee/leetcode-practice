package _每日一题._2022年._5月2日;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/02
 * @Description
 */
public class _96_不同的二叉搜索树 {
    /**
     * 解法1：dp 时间O(N^2) 空间O(n)
     */
    class Solution1 {
        public int numTrees(int n) {
            //1.定义：G[i]表示i个数构成的二叉搜索树的个数
            int[] G = new int[n + 1];
            //2.初始化：0或者1个数，只有一种二叉搜索树，空或者一个节点
            G[0] = 1;
            G[1] = 1;
            //3.转移：枚举i从2到n
            for (int i = 2; i <= n; ++i) {
                //枚举1~i中间的数字j，该数字作为根节点，即可保证为一种二叉搜索树
                for (int j = 1; j <= i; ++j) {
                    //左子树：j-1表示j为根节点后，左边的数字
                    //右子树：i-j表示j为根节点后，右边的数字
                    //j为根节点的总数=左子树的种类*右子树的种类
                    G[i] += G[j - 1] * G[i - j];
                }
            }
            return G[n];
        }
    }

    /**
     * 解法2：卡塔兰数
     */
    class Solution2 {
        public int numTrees(int n) {
            // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
            long C = 1;
            for (int i = 0; i < n; ++i) {
                C = C * 2 * (2 * i + 1) / (i + 2);
            }
            return (int) C;
        }
    }


}
