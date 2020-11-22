package ByteDance._拓展练习;

/**
 * @author lerry-lee
 * @version 1.0
 * @create 2020/06/29 16:58
 * @description UTF-8编码验证
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * <p>
 * 对于 1 字节的字符，字节的第一位设为0，后面7位为这个符号的unicode码。
 * 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为0，后面字节的前两位一律设为10。剩下的没有提及的二进制位，全部为这个符号的unicode码。
 */
public class _UTF8编码验证 {
    public boolean validUtf8(int[] data) {
        int mask1 = 1 << 7;
        int mask2 = 1 << 6;
        int byte_nums = 0;
        for (int datum : data) {
            if (byte_nums == 0) {
                int mask = 1 << 7;
                while ((mask & datum) != 0) {
                    byte_nums += 1;
                    mask = mask >> 1;
                }
                //如果开头没有1，表示是1字节的字符
                if (byte_nums == 0) continue;
                //如果大于4个字节，退出;如果是1字节，并且开头还有1个1，退出
                if (byte_nums > 4 || byte_nums == 1) return false;
            } else {
                if (!((mask1 & datum) != 0 && (mask2 & datum) == 0)) return false;
            }
            byte_nums -= 1;
        }
        return byte_nums == 0;
    }
}
