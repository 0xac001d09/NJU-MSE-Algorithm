package nju.test.exercise04_B;

import java.util.Scanner;

/**
 * 最小化初始点
 * 不能从左上角往右下角走，可能有中间值<=0，会中断
 */
public class _04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {

            String[] str = sc.nextLine().split(" ");
            int rows = Integer.parseInt(str[0]);
            int cols = Integer.parseInt(str[1]);
            String[] s = sc.nextLine().split(" ");
            int index = 0;
            int[][] points = new int[rows][cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    points[i][j] = Integer.parseInt(s[index++]);
                }
            }
            System.out.println(solve(points));
        }
    }

    private static int solve(int[][] points) {
        int n = points.length;
        int m = points[0].length;

        int[][] dp = new int[n][m];
        //从下往上推
        dp[n - 1][m - 1] = points[n - 1][m - 1] > 0 ? 1 : Math.abs(points[n - 1][m - 1]) + 1;

        //首先填充最后一列
        for (int i = n - 2; i >= 0; i--) {
            dp[i][m - 1] = Math.max(dp[i + 1][m - 1] - points[i][m - 1], 1);
        }

        //再填充最后一行
        for (int j = m - 2; j >= 0; j--) {
            dp[n - 1][j] = Math.max(dp[n - 1][j + 1] - points[n - 1][j], 1);
        }

        //填充剩下的
        for (int i = n - 2; i >= 0; i--) {
            for (int j = m - 2; j >= 0; j--) {
                dp[i][j] = Math.max(Math.min(dp[i + 1][j], dp[i][j + 1]) - points[i][j], 1);
            }
        }
        return dp[0][0];
    }

}
