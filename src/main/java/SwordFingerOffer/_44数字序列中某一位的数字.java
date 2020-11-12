package SwordFingerOffer;

import DataStructure.CommonMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: _44数字序列中某一位的数字
 * @Signature: Created by lerry_li on 2020/11/12
 * @Description: TODO
 */
public class _44数字序列中某一位的数字 {
    /**
     * 解法1：生成序列（超出内存限制）时间O(NlogN) 空间O(NlogN)
     * 优化，只保存一位（超时。。。）
     */
    public int findNthDigit(int n) {
//        List<Integer> list = new ArrayList<>();
        int res = 0;
        int ith = -1, num = 0;
        while (ith < n) {
            if (num < 10) {
//                list.add(0,num);
                res = num;
                ith++;
            } else {
                int curNum = num;
                List<Integer> tempList = new ArrayList<>();
                while (curNum != 0) {
                    int temp = curNum % 10;
                    curNum /= 10;
                    tempList.add(temp);
                }
                for (int i = tempList.size() - 1; i >= 0; i--) {
//                    list.add(0,tempList.get(i));
                    res = tempList.get(i);
                    ith++;
                    if (ith == n) {
                        break;
                    }
                }
            }
            num++;
        }
//        System.out.println(list);
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
        _44数字序列中某一位的数字 instance = new _44数字序列中某一位的数字();
        while (true) {
            int n = CommonMethod.getScanner().nextInt();
            System.out.println(instance.findNthDigit(n));
        }
    }
}
