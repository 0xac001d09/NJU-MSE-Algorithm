package nju.test.exercise04_A;

import java.util.Scanner;

/**
 * 如何花最少的钱购买蔬菜
 * paint house变形题
 * 不从相邻的商店购买相同的蔬菜。此外，Rahul将从一家商店购买一种蔬菜（仅1公斤）。拉胡尔希望使用这种策略花费最少的钱购买蔬菜。帮助拉胡尔确定他将花费的最低费用。
 *
 * 序列型dp
 *
 * 考虑最后一步，最后一步有三种情况，以ABC代指3种蔬菜
 *      买A，前一步只能买B或C，
 *      买B，前一步只能买A或C
 *      买C，前一步只能买A或B
 * dp[i][j] 代表在第几家商铺买哪种蔬菜
 */
public class _04 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int k = Integer.parseInt(sc.nextLine().trim());
            int[][] matrix = new int[k][3];
            for (int i = 0; i < k; i++) {
                String[] s = sc.nextLine().split(" ");
                matrix[i][0]= Integer.parseInt(s[0]);
                matrix[i][1]= Integer.parseInt(s[1]);
                matrix[i][2]= Integer.parseInt(s[2]);
            }
            System.out.println(solve(matrix));
        }
    }

    //runtime error
    private static int solve(int[][] matrix) {
        int n = matrix.length;

        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][3];

        for (int i = 0; i < 3; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l < 3; l++) {
                    if (j != l) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][l] + matrix[i - 1][j]);
                    }
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            res = Math.min(res,dp[n][i]);
        }
        return res;
    }

}
