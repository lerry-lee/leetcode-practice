package _每日一题._2021年._21年3月;

/**
 * @ClassName: _331验证二叉树的前序序列化
 * @Author: lerry_li
 * @CreateDate: 2021/03/12
 * @Description
 */
public class _331验证二叉树的前序序列化 {

    /**
     * 解法1：回溯 超时...
     * 思路：
     *      根节点合法+左右子树合法
     *      1.判断根节点：
     *          1）只有一个节点，当该节点为“#”时，返回true，否则返回false（因为左右子树必须为“#”）
     *          2）有多个节点，有2个返回false，有3个以上递归判断左右子树
     *      2.判断左右子树，采用步骤1的方式
     */
    public boolean isValidSerialization(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] array = preorder.split(",");
        //回溯验证是否是一棵合法的二叉树
        //用个dp把验证结果存下来
        boolean[][] dp = new boolean[array.length][array.length];
        boolean[][] visited = new boolean[array.length][array.length];
        return dfs(dp, visited, array, 0, array.length - 1);
    }

    //递归判断一个二叉树是否合法
    public boolean dfs(boolean[][] dp, boolean[][] visited, String[] array, int start, int end) {
        //若当前子树的节点个数只有0个，则返回false
        int node_nums = end - start + 1;
        if (node_nums <= 0 || node_nums == 2) {
            return false;
        }
        //否则，当前子树的节点个数>=1个
        if (node_nums == 1) {
            return array[start].equals("#");
        }
        //若根节点为"#",则不能有子节点
        if (array[start].equals("#")) {
            return false;
        }
        //递归判断左右子树
        for (int i = start + 1; i < end; i++) {
            //检查左子树是否合法
            boolean checkLeft;
            if (visited[start + 1][i]) {
                checkLeft = dp[start + 1][i];
            } else {
                checkLeft = dfs(dp, visited, array, start + 1, i);
                visited[start + 1][i] = true;
                dp[start + 1][i] = checkLeft;
            }

            //检查右子树是否合法
            boolean checkRight;
            if (visited[i + 1][end]) {
                checkRight = dp[i + 1][end];
            } else {
                checkRight = dfs(dp, visited, array, i + 1, end);
                visited[i + 1][end] = true;
                dp[i + 1][end] = checkRight;
            }

            //若左右子树都合法，则返回true，否则继续尝试
            if (checkLeft && checkRight) {
                return true;
            }
        }
        visited[start][end] = true;
        dp[start][end] = false;
        return false;
    }

    public static void main(String[] args) {
        _331验证二叉树的前序序列化 instance = new _331验证二叉树的前序序列化();
        System.out.println(instance.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));//ture
        System.out.println(instance.isValidSerialization("1,#"));//false
        System.out.println(instance.isValidSerialization("9,#,#,1"));//false
        System.out.println(instance.isValidSerialization("1"));//false
        System.out.println(instance.isValidSerialization("1,#,#"));//ture
        System.out.println(instance.isValidSerialization("1,#,#,#,#"));//false
    }
}
