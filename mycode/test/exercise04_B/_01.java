package nju.test.exercise04_B;

import java.util.Scanner;

/**
 * 是否能通过考试
 *  backpack
 */
public class _01 {

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

    private static void solve(int[][] matrix, int time, int score) {
        int n = matrix.length;

        int[][] dp = new int[n + 1][time + 1];
        for (int i = 0; i <= time; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] =0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= time; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= matrix[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - matrix[i - 1][0]] + matrix[i - 1][1]);
                }
            }
        }
        for (int i = 0; i <= time; i++) {
            if (dp[n][i] >= score) {
                System.out.println("YES " + i);
                return;
            }
        }
        System.out.println("NO");
    }
}
