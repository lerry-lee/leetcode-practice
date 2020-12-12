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
    static String addr;
    static List<String> res;
    static List<String> temp;

    public List<String> run(String s) {
        res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        addr = s;
        temp = new ArrayList<>();
//        System.out.println("start dfs");
        dfs(0, s.length(), 4);
        return res;
    }

    public void dfs(int l, int r, int t) {
        if (t == 0) {

            if (l == r) {
                res.add(String.join(".", temp));
            }
            return;
        }
        if (r - l > t * 3 || r - l < t) return;
        for (int i = l; i < r && i < l + 3; i++) {

            String tempS = addr.substring(l, i + 1);
            int tempI = Integer.parseInt(tempS);
            if (tempI < 0 || tempI > 255) break;
            if (tempS.length() != String.valueOf(tempI).length()) break;
            temp.add(tempS);
            dfs(i + 1, r, t - 1);
            temp.remove(temp.size() - 1);
        }
    }

    public void func() {
        addr = "25525511135";
//        addr = "010010";
        res = new ArrayList();
        temp = new ArrayList();
        backtrack(0, addr.length(), 4);
        System.out.println(res);
    }

    public void backtrack(int l, int h, int k) {
        if (k == 0 && l == h) {
            res.add(String.join(".", temp));
            return;
        }
        for (int i = l; i < h && i < 3 + l; i++) {
            if (h < k + l || h > k * 3 + l) break;
            String substr = addr.substring(l, i + 1);
            Integer subip = Integer.parseInt(substr);
            if (substr.length() == Integer.toString(subip).length() && subip < 256) {
                temp.add(substr);
                backtrack(i + 1, h, k - 1);
                temp.remove(temp.size() - 1);
            }

        }

    }
}
