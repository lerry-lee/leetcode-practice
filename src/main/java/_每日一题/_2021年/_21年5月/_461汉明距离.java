package _每日一题._2021年._21年5月;

/**
 * @ClassName: _461汉明距离
 * @Author: lerry_li
 * @CreateDate: 2021/05/27
 * @Description
 * 解法1：按位枚举
 */
public class _461汉明距离 {
    /**
     * 解法1：按位枚举 时间O(1) 空间O(1)
     */
    public int hammingDistance(int x, int y) {
        int dist=0;
        for(int i=0;i<32;i++){
            if((x&1)!=(y&1)) dist++;
            x>>=1;
            y>>=1;
        }
        return dist;
    }
}
