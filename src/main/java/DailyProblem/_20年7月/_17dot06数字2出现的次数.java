package DailyProblem._20年7月;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/07/03 11:04
 * @description 2出现的次数
 */
public class _17dot06数字2出现的次数 {
    /**
     * 思路：数位法，从低位到高位，计算每一位的个数，然后加起来
     * 每一位计算时，需要判断，该位上的数字和2的关系，即小于2？等于2？大于2，三种情况的计算方式不同
     * 每次计算时，依赖于该位前的高位上的数、该位上的数、该位后的低位上的数，三部分共同决定
     */
    public int numberOf2sInRange(int n) {
        //负数直接返回0
        if (n < 0) return 0;
        //初始化：高位high，当前位cur，地位low，位数digit
        //从个位开始，因此各变量初始化如下
        int high = n / 10;
        int cur = n % 10;
        int low = 0;
        int digit = 1;
        //记录出现次数
        int res = 0;
        //从个位到最高位依次求解
        while (high != 0 || cur != 0) {
            System.out.println(String.format("low:%d\tcur:%d\thigh:%d\tdigit:%d\tres:%d", low, cur, high, digit, res));
            if (cur < 2) res += high * digit;
            else if (cur == 2) res += high * digit + low + 1;
            else res += high * digit + digit;
            low += cur * digit;
            digit *= 10;
            cur = high % 10;
            high /= 10;
        }
        return res;
    }

    public void display(int[] ref) {
        for (int num : ref) System.out.print(num + " ");
        System.out.println();
    }
}
