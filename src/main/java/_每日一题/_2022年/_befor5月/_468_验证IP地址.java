package _每日一题._2022年._befor5月;

/**
 * @Author: lerry_li
 * @CreateDate: 2022/04/29
 * @Description
 */
public class _468_验证IP地址 {

    public static void main(String[] args) {
        _468_验证IP地址 instance=new _468_验证IP地址();
        System.out.println(instance.new Solution().validIPAddress("172.16.254.1"));
        System.out.println(instance.new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
        System.out.println(instance.new Solution().validIPAddress("256.256.256.256"));
        System.out.println(instance.new Solution().validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
        System.out.println(instance.new Solution().validIPAddress("1.1.1.1."));
        System.out.println(instance.new Solution().validIPAddress("2001:db8:85a3:0::8a2E:0370:7334"));
    }

    class Solution {
        public String validIPAddress(String queryIP) {
            if (queryIP == null || queryIP.length() == 0) return "Neither";
            if (isIPv4(queryIP)) return "IPv4";
            if (isIPv6(queryIP)) return "IPv6";
            return "Neither";
        }

        private boolean isIPv6(String queryIP) {
            if(queryIP.startsWith(":")||queryIP.endsWith(":")) return false;
            String[] nums = queryIP.split(":");
            if (nums.length != 8) return false;
            for (String num : nums) {
                if(num.length()>4||num.length()==0) return false;
                for(int i=0;i<num.length();i++){
                    char c=num.charAt(i);
                    if(!Character.isDigit(c)&&!((c>='a'&&c<='f')||(c>='A'&&c<='F'))) return false;
                }
            }
            return true;
        }

        private boolean isIPv4(String queryIP) {
            if(queryIP.startsWith(".")||queryIP.endsWith(".")) return false;
            String[] nums = queryIP.split("\\.");
            if (nums.length != 4) return false;
            for (String num : nums) {
                int number = 0;
                for (int i = 0; i < num.length(); i++) {
                    if (!Character.isDigit(num.charAt(i))) return false;
                    number = number * 10 + (num.charAt(i) - '0');
                }
                if (number < 0 || number > 255) return false;
                if (String.valueOf(number).length() != num.length()) return false;
            }
            return true;
        }
    }
}
