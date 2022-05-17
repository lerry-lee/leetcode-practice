package _每日一题._2022年._5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/05/17
 */
public class _剑指Offer43_1到n整数中1出现的次数 {
    /**
     * 解法1：数学规律
     * 思路：
     *      统计每一位上1出现的次数，累加。
     */
    class Solution {
        public int countDigitOne(int n) {
            // digit表示当前位是个位、十位、百位...
            int digit = 1, res = 0;
            // high表示当前位左边(高位)的数字，cur表示当前位的数字，low表示当前位右边(低位)的数字
            // cur从个位开始遍历，low便是0，high便是n/10(去掉个位后的数字)
            int high = n / 10, cur = n % 10, low = 0;
            // cur从个位往左遍历，只要还有high并且cur没有处理完，就一直遍历
            while(high != 0 || cur != 0) {
                // 根据cur的数字，分以下3种情况：
                // 1.cur==0，此时当前位1的个数为high*digit
                // 例如： 1230 ，cur在0这一位的时候，该位出现1的次数显然是前面取[0,122]共123个
                if(cur == 0) res += high * digit;
                // 2.cur==1，此时当前位1的个数为high*digit+low+1
                // cur==1首先包括了cur==0的那部分，因此加上high*digit；
                // 然后考虑低位，cur为1时，低位可以取[0,low-1]，因此有low个
                // 例如： 123145 cur取中间1这一位，此时左边共有[0,122]个，右边共有[0,44]个，再加上它为1的情况
                else if(cur == 1) res += high * digit + low + 1;
                // 3.cur在[2,9]时
                else res += (high + 1) * digit;
                low += cur * digit;
                cur = high % 10;
                high /= 10;
                digit *= 10;
            }
            return res;
        }
    }

}
