package DailyProblem._20年11月;

import java.util.Arrays;

/**
 * @ClassName: _976三角形的最大周长
 * @Author: lerry_li
 * @CreateTime: 2020/11/29
 * @Description
 */
public class _976三角形的最大周长 {
    /**
     * 解法1：排序+三角形三边关系判断 时间O(NlogN) 空间O(1)
     * 思路：
     *      1.先排序
     *      2.从大到小遍历：三条边最长的边，每次取三个数字（两外两个紧挨着最长的边），判断能否组成三角形
     *          1）只需判断较小的两个之和是否大于较大的即可，因为有序的数组，较大的一定大于任意一个较小的
     *          2）因此较大的加上任意一个较小的，一定大于另一个较小的
     *          3）如果不能组成，直接下一个
     *          4）如果能，则这三条边组成的三角形就是周长最长的
     */
    public int largestPerimeter(int[] A) {
        if(A==null||A.length<3){
            return 0;
        }
        Arrays.sort(A);
        int res=0;
        for (int i = A.length-1; i >=2 ; i--) {
            if(A[i-1]+A[i-2]>A[i]){
                res=A[i-1]+A[i-2]+A[i];
                break;
            }
        }
        return res;
    }
}
