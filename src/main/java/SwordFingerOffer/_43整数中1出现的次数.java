package SwordFingerOffer;

/**
 * @ClassName: _43整数中1出现的次数
 * @Signature: Created by lerry_li on 2020/11/06
 * @Description: 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 */
public class _43整数中1出现的次数 {
    /**
     * 解法1：将 1 ~ n 的个位、十位、百位、...的 1 出现次数相加，即为 1 出现的总次数
     * 时间O(logN) 空间O(1)
     */
    public int countDigitOne(int n) {
        if (n < 1) {
            return 0;
        }
        //统计1出现的总次数
        int res = 0;
        //从各位数字开始
        //high为当前位上的数字左边的数
        //low为当前位上的数字右边的数
        //cur为当前位上的数字
        int high = n / 10, low = 0, cur = n % 10;
        //digit为当前位数
        int digit = 1;
        //当high为0且cur为0，说明已经从个位到最高位遍历完成
        while (high != 0 || cur != 0) {
            //cur为0，该位上1出现的次数由high决定
            //例如230：个位出现1的次数=23
            if (cur == 0) {
                res += high * digit;
            } else if (cur == 1) {
                //当cur为1，该位1上1出现的次数由high和low决定
                //例如213，十位出现1的次数=2*10+3+1=24
                res += high * digit + low + 1;
            } else {
                //当cur为2~9，该位上1出现的次数由high决定
                //例如234，十位出现1的次数=（2+1）*10=30
                res += (high + 1) * digit;
            }
            //low加上cur
            low = low + cur * digit;
            //cur往左走一位
            cur = high % 10;
            //high最右边少一位
            high = high / 10;
            //digit进一位
            digit = digit * 10;
        }
        return res;
    }

    public static void main(String[] args) {
        _43整数中1出现的次数 instance = new _43整数中1出现的次数();
        System.out.println(instance.countDigitOne(99));
    }
}
