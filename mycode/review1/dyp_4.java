package nju.review1;


import java.util.Scanner;

/**
 * 花最少的钱购买蔬菜
 * paint house变形题
 *
 * 一共三种蔬菜，三个状态
 */
public class dyp_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int k = Integer.parseInt(sc.nextLine().trim());
            int[][] A = new int[k][3];
            for (int i = 0; i < k; i++) {
                String[] s = sc.nextLine().split(" ");
                A[i][0]= Integer.parseInt(s[0]);
                A[i][1]= Integer.parseInt(s[1]);
                A[i][2]= Integer.parseInt(s[2]);
            }
            solve(A);
        }
    }

    private static void solve(int[][] A) {
        int n = A.length;   //有多少家店
        int[][] dp = new int[n + 1][3];
        //第0家店，三种状态花费都是0
        for (int i = 0; i <= 2; i++) {
            dp[0][i] = 0;
        }

        //前i家店
        for (int i = 1; i <= n; i++) {
            //第i家店买哪种蔬菜
            for (int j = 0; j <= 2; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                // 在第i-1家店买哪种蔬菜
                for (int k = 0; k <= 2; k++) {
                    if (j != k) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + A[i - 1][j]);
                    }
                }
            }
        }
        int res = Math.min(dp[n][0], Math.min(dp[n][1], dp[n][2]));
        System.out.println(res);
    }
}
