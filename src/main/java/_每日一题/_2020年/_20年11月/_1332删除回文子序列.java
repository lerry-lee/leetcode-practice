package _每日一题._2020年._20年11月;

/**
 * @ClassName: _1332删除回文子序列
 * @Signature: Created by lerry_li on 2020/11/17
 * @Description:
 */
public class _1332删除回文子序列 {
    /**
     * 解法1：三种情况
     * 1.空串→返回0
     * 2.回文串→返回1
     * 3.非回文串→返回2
     * ①先删除a；②再删除b
     * tips：注意是回文子序列，而且字母仅有a和b！
     */
    public int removePalindromeSub(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.equals(new StringBuilder(s).reverse().toString())) {
            return 1;
        }
        return 2;
    }

    public static void main(String[] args) {
        _1332删除回文子序列 instance = new _1332删除回文子序列();
        System.out.println(instance.removePalindromeSub("bbaabaaa"));
    }
}
