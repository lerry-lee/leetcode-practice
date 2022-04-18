package _其他._笔试题._外企;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/18
 * @Description
 */
public class _991_坏了的计算器 {
    /**
     * 解法1：BFS 超时
     */
    public int brokenCalc(int startValue, int target) {
        if (startValue == target) return 0;
        Queue<Integer> queue = new LinkedList();
        queue.add(startValue);
        int path = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            path++;
            for (int i = 0; i < size; i++) {
                int val = queue.remove();
                if (val * 2 == target || val - 1 == target) {
                    return path;
                }
                if (val < target) queue.add(val * 2);
                if (val - 1 > 0) queue.add(val - 1);
            }
        }
        return path;
    }

    /**
     * 解法2：数学：逆向计算
     * x只能*2或者-1，所以y可以通过/2或者+1逆向计算得到x
     * 观察测试用例可知：
     *  y为偶数时，y/=2
     *  y为奇数时，y+1
     * 不停重复上述步骤，直到y<=x，此时需要进行多次y+1操作，次数为x-y
     */
    public int brokenCalc2(int x, int y) {
        int res=0;
        while(y>x){
            if(y%2==0){
                y/=2;
            }else{
                y++;
            }
            res++;
        }
        return res+(x-y);
    }
}
