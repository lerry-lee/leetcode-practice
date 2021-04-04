package _其他._笔试题._美团;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(func(str));//aabc 12
    }

    private static int func(String str) {
        List<HashSet<Character>> dp = new ArrayList<>();
        HashSet<Character> cur = new HashSet<>();
        cur.add(' ');
        dp.add(cur);
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            int size = dp.size();
            for (int i = 0; i < size; i++) {
                HashSet<Character> dpi = dp.get(i);
                if (!dpi.contains(aChar)) {
                    cur = new HashSet<>(dpi);
                    cur.add(aChar);
                    dp.add(cur);
                }
            }
        }
        System.out.println(dp);
        return dp.size();
    }
}
