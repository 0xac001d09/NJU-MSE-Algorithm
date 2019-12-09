package nju.review1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 最长公共子序列，双序列型dp
 * 假设字符串A的长度为m，字符串B的长度为n，s为A和B的LCS
 * 直接看做后一步，有三种情况
 *      A的最后一个字符不在s中，则直接看A的0～m-2位与B的0～n-1位
 *      B的最后一个字符不在s中，则直接看A的0～m-1位与B的0～n-2位
 *      都在里头，直接看A的0～m-2位与B的0～n-2位
 * dp[i][j] 代表A的前i位与B的前j位
 * dp[i][j]记录的是最长公共子序列的长度
 *
 */
public class string_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            solve(A, B);
        }
    }

    private static void solve(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m + 1][n + 1];
        //初始化
        int i, j;
        for (j = 0; j <= n; j++) {
            dp[0][j] = 0;
        }
        for (i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        for (i = 1; i <= m; i++) {
            for (j = 1; j <= n; j++) {
                //如果A的最后一个不在其中，或者是B的最后一个不在其中的情况
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                //如果最后一个都在其中
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);    //+1 ！！！
                }
            }
        }

        //获得了dp数组，dfs获取结果
        Set<String> set = new TreeSet<>();
        dfs("", m, n, A, B, dp, set);

        //打印结果
        for (String s : set) {
            System.out.println(s);
        }

    }

    private static void dfs(String temp, int i, int j, String A, String B, int[][] dp, Set<String> set) {
        if (temp.length() == dp[A.length()][B.length()]) {
            set.add(new StringBuilder(temp).reverse().toString());
            return;
        }
        if (A.charAt(i - 1) == B.charAt(j - 1)) {   //只有相等时才添加
            temp += A.charAt(i - 1);
            dfs(temp, i - 1, j - 1, A, B, dp, set);
        } else {
            //上边更大
            if (dp[i - 1][j] >= dp[i][j - 1]) {
                dfs(temp, i - 1, j, A, B, dp, set);
            }
            //左边更大
            if (dp[i][j - 1] >= dp[i - 1][j]) {
                dfs(temp, i, j - 1, A, B, dp, set);
            }
        }
    }
}
