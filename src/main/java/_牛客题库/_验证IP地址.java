package _牛客题库;

/**
 * @ClassName: _验证IP地址
 * @Author: lerry_li
 * @CreateDate: 2021/06/03
 * @Description
 */
public class _验证IP地址 {


    public static void main(String[] args) {
        _验证IP地址 instance = new _验证IP地址();
        System.out.println(instance.solve("172.16.254.1"));
        System.out.println(instance.solve("256.256.256.256"));
        System.out.println(instance.solve("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }

    /**
     * 解法1：拆分+判断 时间O(N) 空间O(1)
     */
    public String solve(String IP) {
        // write code here
        //特判
        if (IP == null || IP.length() == 0) return "Neither";
        if (checkIPV6(IP)) {
            return "IPv6";
        } else if (checkIPV4(IP)) {
            return "IPv4";
        } else {
            return "Neither";
        }
    }

    private boolean checkIPV4(String ip) {
        String[] arr = ip.split("\\.");
        if (arr.length != 4) return false;
        for (String addr : arr) {
            if (addr.length() > 3 || addr.length() == 0) return false;
            int value = Integer.parseInt(addr);
            if (value < 0 || value > 255) return false;
            if (String.valueOf(value).length() != addr.length()) return false;
        }
        return true;
    }

    private boolean checkIPV6(String ip) {
        String[] arr = ip.split(":");
        if (arr.length != 8) return false;
        for (String addr : arr) {
            if (addr.length() > 4 || addr.length() == 0) return false;
//            if (addr.charAt(0) == '0' && addr.length() > 1) return false;
            addr = addr.toLowerCase();
            for (int i = 0; i < addr.length(); i++) {
                char c = addr.charAt(i);
                if (c >= '0' && c <= '9') continue;
                if (c >= 'a' && c <= 'e') continue;
                return false;
            }
        }
        return true;
    }
}
