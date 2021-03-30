package _剑指Offer;


import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _44数字序列中某一位的数字
 * @Signature: Created by lerry_li on 2020/11/12
 * @Description:
 */
public class _44数字序列中某一位的数字 {
    /**
     * 解法1：生成序列（超出内存限制|超时）时间O(NlogM) 空间O(logM) N表示总位数，logM表示平均一个数字的位数
     */
    public int findNthDigit(int n) {
        //res保存的就是第n位对应的数字，0~9
        int res = 0;
        //ith用于按位计数，num保存当前的数字（以数字为整体，比如10,11）
        int ith = -1, num = 0;
        //0~9单独算
        while (ith < n&&num <= 9) {
            res = num;
            ith++;
            num++;
        }
        //10及10以上另算
        while (ith < n) {
            //curNum等于num，用于取当前数字的每一位
            int curNum = num;
            //从低位到高位，逐位取出来
            List<Integer> tempList = new ArrayList<>();
            while (curNum != 0) {
                int temp = curNum % 10;
                curNum /= 10;
                tempList.add(temp);
            }
            //从高位到低位，逐个遍历
            for (int i = tempList.size() - 1; i >= 0; i--) {
                res = tempList.get(i);
                ith++;
                if (ith == n) {
                    break;
                }
            }
            num++;
        }
        return res;
    }

    /**
     * 解法2：数学推导 TODO
     */
    public int findNthDigit2(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        _44数字序列中某一位的数字 instance=new _44数字序列中某一位的数字();
        System.out.println(instance.findNthDigit(3));
        System.out.println(instance.findNthDigit(11));
    }

}
