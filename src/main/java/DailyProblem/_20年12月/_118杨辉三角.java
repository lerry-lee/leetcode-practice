package DailyProblem._20年12月;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: _118杨辉三角
 * @Author: lerry_li
 * @CreateDate: 2020/12/06
 * @Description
 */
public class _118杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        for (int i = 0; i < numRows; i++) {
            res.add(new ArrayList<>());
            List<Integer> curr = res.get(i);
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curr.add(1);
                } else {
                    List<Integer> prev = res.get(i - 1);
                    curr.add(prev.get(j - 1) + prev.get(j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _118杨辉三角 instance = new _118杨辉三角();
        System.out.println(instance.generate(5));
    }
}
