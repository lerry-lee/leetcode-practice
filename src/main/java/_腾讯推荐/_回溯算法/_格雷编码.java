package _腾讯推荐._回溯算法;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _格雷编码
 * @Signature: Created by lerry_li on 2020/10/29
 * @Description:
 */
public class _格雷编码 {
    /**
     * 解法1：参考图解 时间O(2^N) 空间O(1)
     */
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            //计算对应位数，给逆序遍历的res[i]的最前面位加1
            int head = 1 << i;
            //倒序遍历，并且加上一个值添加到结果中
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(head + res.get(j));
            }
        }
        return res;

    }

    public static void main(String[] args) {
        _格雷编码 instance = new _格雷编码();
        System.out.println(instance.grayCode(2));
    }
}
