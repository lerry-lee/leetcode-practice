package _字节推荐._字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 有效的 IP 地址正好由四个整数（每个整数位于 0 到 255 之间组成），整数之间用 '.' 分隔。
 * 示例
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 * 回溯？
 */
public class _复原IP地址 {
    /**
     * 解法1：回溯+剪枝
     */

    public List<String> run(String s) {
        List<String> res = new ArrayList<>();
        // 特判
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(res, new ArrayList<>(), s, 0, s.length() - 1, 0);
        return res;
    }

    public void dfs(List<String> res, List<String> cur, String s, int l, int r, int t) {
        //字符串s已经分出了4个部分，进入递归出口的判断
        if (t == 4) {
            //字符串s全部遍历完，则添加合法的ip
            if (l > r) {
                res.add(String.join(".", cur));
            }
            return;
        }

        //剪枝2：未遍历的字符串不能太短或者太长了，得刚好能够分的
        if (r - l+1 < 4 - t || r - l+1 > (4 - t) * 3) {
            return;
        }

        for (int i = l; i <= r; i++) {
            //剪枝1：每部分0~255，所以长度不能超过3
            if (i - l >= 3) {
                break;
            }
            String ipStr = s.substring(l, i + 1);
            int ipInt = Integer.parseInt(ipStr);
            //有效值判断，0~255
            if (ipInt < 0 || ipInt > 255) {
                break;
            }
            //0开头的数字判断，0开头的数字无效(0除外)
            if (ipStr.length() > String.valueOf(ipInt).length()) {
                break;
            }
            cur.add(ipStr);
            dfs(res, cur, s, i + 1, r, t + 1);
            cur.remove(cur.size() - 1);
        }
    }

}
