package nju.review1;

import java.util.Scanner;

/**
 * 能否通过考试，求出通过考试的所花费的最短时间
 * 背包问题
 *
 * 1
 * 5 40 21（任务数量n、考试时常h、通过分数p）
 * 耗时 得分
 * 12 10
 * 16 10
 * 20 10
 * 24 10
 * 8 3
 *
 * TODO 如何打印路径？
 */
public class dyp_5{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int rows = Integer.parseInt(s[0]);
            int time = Integer.parseInt(s[1]);
            int score = Integer.parseInt(s[2]);
            int[][] matrix = new int[rows][2];
            for (int i = 0; i < rows; i++) {
                String[] s1 = sc.nextLine().split(" ");
                int a = Integer.parseInt(s1[0]);
                int b = Integer.parseInt(s1[1]);
                matrix[i][0] = a;
                matrix[i][1] = b;
            }
            solve(matrix, time, score);
        }
    }

    private static void solve(int[][] A, int time, int score) {
        int n = A.length;
        int[][] dp = new int[n + 1][time + 1];

        for (int i = 0; i <= time; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= time; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= A[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1][0]] + A[i - 1][1]);
                }
            }
        }
        //找最短时间
        for (int i = 0; i <= time; i++) {
            if (dp[n][i] >= score) {
                System.out.println("YES " + i);     //注意大写
                return;

            }
        }
        System.out.println("NO");       //注意大写
    }

}
