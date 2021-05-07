package _每日一题._2021年._21年5月;

/**
 * @ClassName: _1486数组异或操作
 * @Author: lerry_li
 * @CreateDate: 2021/05/07
 * @Description
 * 解法1：朴素
 */
public class _1486数组异或操作 {
    /**
     * 解法1：朴素 时间O(N) 空间O(1)
     */
    public int xorOperation(int n, int start) {
        int res=0;
        for(int i=0;i<n;i++,start+=2){
            res^=start;
        }
        return res;
    }
}
