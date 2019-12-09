package nju.review1;

import java.util.Scanner;

/**
 * 最小化初始点
 */
public class dyp_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());

        while (loop-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int rows = Integer.parseInt(s[0]);
            int cols = Integer.parseInt(s[1]);
            int[][] A = new int[rows][cols];
            String[] s1 = sc.nextLine().split(" ");
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    A[i][j] = Integer.parseInt(s1[index++]);
                }
            }
            System.out.println(solve(A));
        }
    }

    private static int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];
        dp[n - 1][m - 1] = A[n - 1][m - 1] < 0 ? Math.abs(A[n - 1][m - 1]) + 1 : 1;

        //初始化最后一列
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = Math.max(dp[i + 1][m - 1] - A[i][m - 1], 1);
        }
        //初始化最后一行
        for (int i = m - 2; i >= 0; i--) {
            dp[n - 1][i] = Math.max(dp[n - 1][i + 1] - A[n - 1][i], 1);
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                //从左边来还是右边来
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - A[i][j], 1);
            }
        }
        return dp[0][0];
    }


}
