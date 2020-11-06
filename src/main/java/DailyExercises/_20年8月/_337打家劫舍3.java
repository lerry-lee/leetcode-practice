package DailyExercises._20年8月;

import DataStructure.TreeNode;

import java.util.HashMap;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/08/05 12:19
 * @description 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
 *
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 *
 * 示例 1:
 *
 * 输入: [3,2,3,null,3,null,1]
 *
 *      3
 *     / \
 *    2   3
 *     \   \
 *      3   1
 *
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
 * 示例 2:
 *
 * 输入: [3,4,5,1,3,null,1]
 *
 *      3
 *     / \
 *    4   5
 *   / \   \
 *  1   3   1
 *
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 */
public class _337打家劫舍3 {
    /**
     * 解法1：暴力递归+最优子结构
     * 1）分解成相同的子问题解决：每个节点的情况是：①计算偷当前节点和偷其孙子节点的收益，②记为m1；计算偷当前节点的子节点的收益，记为m2
     * 2）返回m1和m2的较大值即可
     * tips：由于偷子节点、孙子节点都是递归去做，所以不一定取到那个节点的值，也就是说，不是单纯的跨行求和
     */
    public int rob_recursive(TreeNode root) {
        if(root==null) return 0;
        int m1=root.val;
        if(root.left!=null) m1+=rob_recursive(root.left.left)+rob_recursive(root.left.right);
        if(root.right!=null) m1+=rob_recursive(root.right.left)+rob_recursive(root.right.right);
        int m2=0;
        m2+=rob_recursive(root.left)+rob_recursive(root.right);
        return Math.max(m1,m2);
    }

    /**
     * 解法2：解法1的优化，解决重复子问题计算
     * 1）由于解法1中，递归时，大部分节点被重复计算了多次，所以可以记录已经计算过的值，下次计算前先看看有没有记录，没有再去计算
     * 2）树不适合用数组做缓存，因此使用hashmap
     */
    HashMap<TreeNode,Integer> node_money=new HashMap<>();
    public int rob_recursive_improved(TreeNode root) {
        return dfs(root);
    }
    public int dfs(TreeNode node){
        if(node==null) return 0;
        if(node_money.containsKey(node)) return node_money.get(node);
        int money1=node.val;
        if(node.left!=null) money1+=dfs(node.left.left)+dfs(node.left.right);
        if(node.right!=null) money1+=dfs(node.right.left)+dfs(node.right.right);
        int money2=dfs(node.left)+dfs(node.right);
        int money=Math.max(money1,money2);
        node_money.put(node,money);
        return money;
    }

    /**
     * 解法3：解法2的优化，dp思路
     * 解法2在计算当前节点的同时，要递归计算孙子节点，可以优化
     * 1）节点的状态有2：要么偷/要么不偷
     * 2）若偷：则money=左子结点不偷的money+右子节点不偷的money
     *   若不偷：则money=左子结点的money+右子节点的money（子节点可偷可不偷）
     * 3）用数组记录偷/不偷的money
     */
    public int rob_dp(TreeNode root) {
        int[] moneys=dfs_dp(root);
        return Math.max(moneys[0],moneys[1]);
    }
    public int[] dfs_dp(TreeNode root){
        int[] moneys=new int[2];
        if(root==null) return moneys;
        int[] left=dfs_dp(root.left);
        int[] right=dfs_dp(root.right);
        moneys[0]=Math.max(left[0],left[1])+Math.max(right[0],right[1]);
        moneys[1]=left[0]+right[0]+root.val;
        return moneys;
    }
}
