package _剑指Offer;

import java.util.Arrays;

/**
 * @ClassName: _05替换空格
 * @Author: lerry_li
 * @CreateDate: 2021/04/02
 * @Description
 */
public class _05替换空格 {
    public String replaceSpace(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            if (aChar == ' ') {
                sb.append("%20");
            } else {
                sb.append(aChar);
            }
        }
        return sb.toString();
    }
}
