package _其他._笔试题._华为;



/**
 * @Author: lerry_li
 * @CreateTime: 2021/09/15
 */
import java.util.Arrays;
import java.util.Scanner;
public class T1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        int len1 = arr1.length;
        int len2 = arr2.length;
        int[] works = new int[len1];
        int[] sters = new int[len2];
        for (int i = 0; i < len1; i++) {
            works[i] = Integer.parseInt(arr1[i]);
        }
        for (int i = 0; i < len2; i++) {
            sters[i] = Integer.parseInt(arr2[i]);
        }
        int res = 0;
        int works_i = 0, sters_i = 0;
        Arrays.sort(works);
        Arrays.sort(sters);
        while (works_i < len1 && sters_i < len2) {
            if (works[works_i] > sters[sters_i]) {
                if (res < Math.abs(sters[sters_i] - works[works_i])) sters_i++;
                else works_i++;
            } else {
                if (res < Math.abs(sters[sters_i] - works[works_i])) {
                    if (sters_i > 0 && (Math.abs(sters[sters_i - 1] - works[works_i]) < Math.abs(sters[sters_i] - works[works_i]))) {
                        res = Math.abs(sters[sters_i - 1] - works[works_i]);
                        works_i++;
                    } else {
                        res = Math.abs(sters[sters_i] - works[works_i]);
                    }
                } else {
                    works_i++;
                }
            }
        }
        res = works_i < len1 ? Math.abs(works[len1 - 1] - sters[len2 - 1]) : res;
        System.out.println(res);
    }
}

/*
1 3 5
2
 */