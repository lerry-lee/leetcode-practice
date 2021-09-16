package _每日一题._2021年._21年9月;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/10
 */
public class _93_复原IP地址 {
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        //特判
        if (s == null || s.length() < 4 || s.length() > 12) {
            return res;
        }
        dfs(new ArrayList<>(), s, 0, 0);
        return res;
    }

    /**
     * 回溯
     *
     * @param addr 当前ip地址
     * @param s 待处理字符串
     * @param cursor 待处理下标
     * @param t 已经处理的部分
     */
    public void dfs(List<String> addr, String s, int cursor, int t) {
        //已经处理了4部分了
        if (t == 4) {
            //字符串都处理完了，下标到字符串末尾了
            if (cursor == s.length()) {
                //添加当前合法ip地址到res
                res.add(String.join(".", addr));
            }
            return;
        }
        //剪枝
        //1)如果剩余字符串的长度不够后面分配的最小值
        //2)如果剩余字符串的长度超过后面分配的最大值
        //直接返回
        if (s.length() - cursor < 4 - t || s.length() - cursor > (4 - t) * 3) {
            return;
        }
        //遍历字符串，每次取1~3个字符处理
        for (int i = cursor; i <s.length(); i++) {
            //超过3个字符直接返回
            if (i - cursor >= 3) {
                break;
            }
            //截取字符串，算一下数值
            String ipStr = s.substring(cursor, i + 1);
            int ipInt = Integer.parseInt(ipStr);
            //数值必须满足[0,255]
            if (ipInt < 0 || ipInt > 255) {
                break;
            }
            //数值必须不能有前导0，除非0
            if (ipStr.length() > String.valueOf(ipInt).length()) {
                break;
            }
            //都符合要求的，加入IP地址
            addr.add(ipStr);
            //递归
            dfs(addr, s, i + 1, t + 1);
            addr.remove(addr.size() - 1);
        }
    }
}
