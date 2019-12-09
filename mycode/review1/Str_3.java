package nju.review1;

import java.util.Scanner;

public class Str_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s1 = sc.nextLine();
            String[] split = s1.split(",");
            solve2(split[0],split[1]);
        }
    }
    private static void solve(String txt, String pat) {
        StringBuilder sb = new StringBuilder();
        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb.toString().trim());
    }

    /**
     * 更为简单的方法
     */
    private static void solve2(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i != -1) {
            i = A.indexOf(B, i);
            if (i != -1) {
                sb.append(i).append(" ");
                i++;
            }
        }
        System.out.println(sb.toString().trim());
    }

}
