package _每日一题._2021年._21年7月;

/**
 * @ClassName: _440字典序的第K小数字
 * @Author: lerry_li
 * @CreateDate: 2021/07/17
 * @Description
 */
public class _440字典序的第K小数字 {

    /**
     * 字典树
     */
    public int findKthNumber(int n, int k) {
        long cur = 1;//从1开始
        k--;//k-1
        while (k > 0) {
            //拿到当前节点所在的子树的节点总数
            int nodes_nums = getNodesNums(cur, n);
            //如果k比这个数量要小，说明第k个数在当前节点的这个子树里
            if (k < nodes_nums) {
                //向下走一个(只跳过了当前一个节点)
                k--;
                cur *= 10;
            }
            //否则，说明第k个数不在当前节点的子树里，那么在当前节点的右边节点的子树里
            else {
                //向右走一个(当前节点的子树所包括的所有节点都跳过了)
                k -= nodes_nums;
                cur++;
            }
        }
        return (int) cur;
    }

    private int getNodesNums(long cur, int n) {
        long next = cur + 1;
        long res = 0;
        while (cur <= n) {
            //计算当前层的节点个数，累加到计数里面
            res += Math.min(next - cur, n - cur + 1);
            cur *= 10;
            next *= 10;
        }
        return (int) res;
    }
}
