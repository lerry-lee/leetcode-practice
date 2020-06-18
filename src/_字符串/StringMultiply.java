package _字符串;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 示例：
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 */
public class StringMultiply {
    public static void main(String[] args) {
        String n1 = "123", n2 = "456";

        System.out.println(mul_add(n1, n2));
//        System.out.println(Character.getNumericValue('2'));
    }

    public static String mul_add(String n1, String n2) {
        if (n1.equals("0") || n2.equals("0")) return "0";
        String add1 = "", add2 = "";
        int k = 0;
        for (int i = n2.length() - 1; i >= 0; i--) {
            k = n2.length() - i - 1;
            add2 = mul(n1, n2.charAt(i), k);
//            System.out.print(n1 + "*" + n2.charAt(i) + "=" + add2 + "; ");
//            System.out.print(add1 + "+" + add2);
            add1 = add(add1, add2);
//            System.out.print("=" + add1 + '\n');
        }
        return add1;
    }

    public static String add(String n1, String n2) {
        String res = "";
        int jin = 0, sum = 0;
        int i = n1.length() - 1, j = n2.length() - 1;
        for (; i >= 0 && j >= 0; i--, j--) {
            sum = Character.getNumericValue(n1.charAt(i)) + Character.getNumericValue(n2.charAt(j)) + jin;

            jin = sum >= 10 ? sum / 10 : 0;
            sum = sum % 10;
            res += sum;
        }
        while (i >= 0) {
            sum = Character.getNumericValue(n1.charAt(i--)) + jin;

            jin = sum >= 10 ? sum / 10 : 0;
            sum = sum % 10;
            res += sum;
        }
        while (j >= 0) {
            sum = Character.getNumericValue(n2.charAt(j--)) + jin;

            jin = sum >= 10 ? sum / 10 : 0;
            sum = sum % 10;
            res += sum;
        }
        if (jin > 0) res += jin;
        return new StringBuffer(res).reverse().toString();
    }

    public static String mul(String n1, char c, int k) {
        String res = "";
        while (k > 0) {
            res += '0';
            k--;
        }
        int product = 0, jin = 0;
        for (int i = n1.length() - 1; i >= 0; i--) {
            product = Character.getNumericValue(c) * Character.getNumericValue(n1.charAt(i)) + jin;

            jin = product / 10;
            product = product % 10;

            res += product;
        }
        if (jin > 0) res += jin;

        return new StringBuffer(res).reverse().toString();
    }
}
