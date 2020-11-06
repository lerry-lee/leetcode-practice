package Tecent._数学与数字;

/**
 * Created by lerry_li on 2020/10/12
 */

/**
 * 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class _整数反转 {
    /**
     * 解法1：用long判断溢出（不符合题目要求）
     */
    public int reverse(int x) {
        long y = 0;
        int wei = 0;
        boolean neg = x < 0;
        x = neg ? -x : x;
        int x_ = x;
        while (x_ > 0) {
            wei++;
            x_ /= 10;
        }
        System.out.println(Integer.MAX_VALUE + "\t" + Integer.MIN_VALUE);
        System.out.println(x);
        System.out.println("位数：" + wei);
        while (x > 0) {
            int num = x % 10;
            x /= 10;
            y += num * Math.pow(10, wei - 1);
            System.out.println("当前数字：" + num + "\t位数：" + wei + "\ty:" + y);
            wei--;
            if (!neg && y > Integer.MAX_VALUE) return 0;
            else if (neg && -y < Integer.MIN_VALUE) return 0;
        }
        return neg ? -(int) y : (int) y;
    }
    /**
     * 解法2：数学
     * 溢出条件有两个，一个是大于整数最大值MAX_VALUE，另一个是小于整数最小值MIN_VALUE，设当前计算结果为ans，下一位为pop。
     * 从ans * 10 + pop > MAX_VALUE这个溢出条件来看
     * 当出现 ans > MAX_VALUE / 10 且 还有pop需要添加 时，则一定溢出
     * 当出现 ans == MAX_VALUE / 10 且 pop > 7 时，则一定溢出，7是2^31 - 1的个位数
     * 从ans * 10 + pop < MIN_VALUE这个溢出条件来看
     * 当出现 ans < MIN_VALUE / 10 且 还有pop需要添加 时，则一定溢出
     * 当出现 ans == MIN_VALUE / 10 且 pop < -8 时，则一定溢出，8是-2^31的个位数
     */
    public int reverse2(int x) {
        int MAX_div_10=Integer.MAX_VALUE/10,MIN_div_10=Integer.MIN_VALUE/10;
        int res=0;
        while(x!=0){
            int num=x%10;
            if(res>MAX_div_10||(res==MAX_div_10&&num==7)) return 0;
            if(res<MIN_div_10||(res==MIN_div_10&&num==-8)) return 0;
            res=res*10+num;
            x/=10;
        }
        return res;
    }
}
