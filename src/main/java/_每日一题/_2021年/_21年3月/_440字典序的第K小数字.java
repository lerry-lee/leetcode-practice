package _每日一题._2021年._21年3月;

/**
 * @ClassName: _440字典序的第K小数字
 * @Author: lerry_li
 * @CreateTime: 2021/03/21
 * @Description
 */
public class _440字典序的第K小数字 {
    /**
     * 解法1：字典树
     * @param n 整数1~n的字典序
     * @param k 第k个
     * @return 返回第k个整数
     */
    public int findKthNumber(int n, int k) {
        //i记录字典序的第几个数
        int i = 1;//第一字典序小的(就是1)
        //prefix记录是哪个数
        int prefix = 1;// 前缀从1开始
        //当i没到第k个
        while (i < k) {
            //
            int tmp = count(n, prefix); //当前prefix峰的值
            if (tmp + i > k) {// 找到了
                prefix *= 10; //往下层遍历
                i++;//一直遍历到第K个推出循环
            } else {
                prefix++;//去下个峰头(前缀)遍历
                i += tmp;//跨过了一个峰(前缀)
            }
        }//退出循环时 i==k 正好找到
        return prefix;
    }

    private int count(int n, int prefix) {
        //不断向下层遍历可能一个乘10就溢出了, 所以用long
        long cur = prefix;
        long next = cur + 1;//下一个前缀峰头
        int count = 0;
        while (cur <= n) {
            count += Math.min(n + 1, next) - cur;//下一峰头减去此峰头
            // 如果说刚刚prefix是1，next是2，那么现在分别变成10和20
            // 1为前缀的子节点增加10个，十叉树增加一层, 变成了两层

            // 如果说现在prefix是10，next是20，那么现在分别变成100和200，
            // 1为前缀的子节点增加100个，十叉树又增加了一层，变成了三层
            cur *= 10;
            next *= 10; //往下层走
        }
        return count;
    }

    /**
     * 解法2：十叉树
     */
    public int findKthNumber2(int n, int k) {

        //cur表示最终需要找到的十叉树的节点，出发点是1
        int cur = 1;
        //i表示到第几个数了，到第k个停止，出发时i是第一个数“1”
        int i = 1;
        //搜索十叉树
        while (i < k) {
            //计算当前节点移动的步数
            int step = calStep(n, cur);
            //当step<=k，节点向右移动
            if (step <= k) {
                i += step;
                cur += 1;
            }
            //当step>k，节点向下移动
            else {
                i++;
                cur *= 10;
            }
        }

        return cur;
    }

    private int calStep(int n, long cur) {
        int step = 0;
        long next = cur + 1;
        while (cur <= n) {
            step += Math.min(next, n + 1) - cur;
            cur *= 10;
            next *= 10;
        }
        return step;
    }

    public static void main(String[] args) {
        _440字典序的第K小数字 instance = new _440字典序的第K小数字();
        System.out.println(instance.findKthNumber2(13, 6));
    }

}
