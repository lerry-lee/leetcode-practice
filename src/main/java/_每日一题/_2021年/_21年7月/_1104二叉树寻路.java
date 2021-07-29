package _每日一题._2021年._21年7月;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @ClassName: _1104二叉树寻路
 * @Author: lerry_li
 * @CreateDate: 2021/07/29
 * @Description
 */
public class _1104二叉树寻路 {
    /**
     * 解法1：数学推导
     * 思路：若不反转，每层都按顺序从左到右，则：
     *      1)第i层有2^(i-1)个节点，
     *      2)第1层到第i层共有2^i-1个节点,
     *      3)某个节点的父节点=val/2
     *      4)某个节点的子节点为2*val,2*val+1
     *      1.因此，从给的节点值开始，从底向上遍历，即可找到路径(最后反转)
     *      val,val/=2,val/=2,...,1
     *      2.偶数层反转后，只需要找到反转节点的对称节点（2^(val-1)+2^val-1-val）
     *      可以将偶数层都反转成正常顺序，然后每次去对称节点
     */
    public List<Integer> pathInZigZagTree(int label) {
        //特判
        List<Integer> res = new ArrayList<>();
        if (label <= 0) return res;
        //找到label在第几行
        //假设二叉树的根节点在第1行
        int row = 1;
        int val = 1;
        while (val * 2 <= label) {
            row++;
            val *= 2;
        }
        //若label所在层为偶数层，则将label反转成正常顺序
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        //然后从下向上找父节点,*2=父节点值
        //根据规律：每次循环前，当前节点值都是正常顺序的了
        while (row >= 1) {
            //若为偶数行,则找当前节点对称节点值
            if (row % 2 == 0) {
                //找对称节点
                res.add(getReverse(label, row));
            }
            //若行数为奇数，则当前节点值
            else {
                res.add(label);
            }
            label /= 2;
            row--;
        }
        Collections.reverse(res);
        return res;
    }

    //找对称节点
    private int getReverse(int label, int row) {
        return (int) (Math.pow(2, row - 1) + Math.pow(2, row) - 1 - label);
    }
}
