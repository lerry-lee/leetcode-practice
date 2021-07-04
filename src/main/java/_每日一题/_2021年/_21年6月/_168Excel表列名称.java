package _每日一题._2021年._21年6月;

/**
 * @ClassName: _168Excel表列名称
 * @Author: lerry_li
 * @CreateDate: 2021/07/04
 * @Description
 * 解法1:十进制转换26进制
 */
public class _168Excel表列名称 {
    /**
     * 解法1:十进制转换26进制
     * tips：
     *      十进制转换可以用除余法
     *      例如：十进制转二进制，每次模2，余数放左边，除的商放下面，一直除到0
     *      最后拼接余数得到二进制结果
     */
    public String convertToTitle(int columnNumber) {
        //特判
        if (columnNumber <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            //注意这里columnNumber-1再取模
            //因为26进制的意思是缝26进1，即26=10，但是对于这道题来说，26对应的字母是Z
            //因此可以先-1，这样就可以拿到对应的数了
            columnNumber-=1;
            sb.append((char)( columnNumber% 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }
}
