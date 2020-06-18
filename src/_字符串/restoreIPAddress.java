package _字符串;

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
public class restoreIPAddress {
    static String addr;
    static List<String> res;

    static List<String> temp;


    public static void main(String[] args) {
        func();
    }

    public static void func() {
        addr = "25525511135";
        addr = "010010";
        res = new ArrayList();
        temp = new ArrayList();
        backtrack(0, addr.length(), 4);
        System.out.println(res);
    }

    public static void backtrack(int l, int h, int k) {
        if (k == 0 && l == h) {
            res.add(String.join(".", temp));
        } else {
            for (int i = l; i < h && i < 3 + l; i++) {
                if (h >= k + l && h <= k * 3 + l) {
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
    }
}
