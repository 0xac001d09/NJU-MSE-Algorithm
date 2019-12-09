package nju.review1;

import java.util.Scanner;

/**
 * 订单问题
 *
 * 序列型dp，一份订单只能由一个人做，两个人做第i份订单会得到各自的报酬A[i]、B[i]，且第一个人不能比第二个人多X份订单，第二个人不能比第一个人多Y份订单
 * 请问两人最多能拿多少小费
 *
 * 1        uc个数
 * 5 3 3    5份订单，X = 3，Y = 3
 * 1 2 3 4 5    A数组
 * 5 4 3 2 1    B数组
 *
 * 解决思路
 * 从最后一步出发，最后一个丁=订单要么第一个人做，要么第二个人做
 *      两个人都能做的情况下，看谁得到的前多
 *      有一方不能做就只能让另一方做
 */
public class dyp_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s = sc.nextLine().split(" ");
            String[] s1 = sc.nextLine().split(" ");
            String[] s2 = sc.nextLine().split(" ");
            int X = Integer.parseInt(s[1]);
            int Y = Integer.parseInt(s[2]);
            int[] A = new int[s1.length];
            int[] B = new int[s2.length];
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i < B.length; i++) {
                B[i] = Integer.parseInt(s2[i]);
            }

            System.out.println(solve(A, B, X, Y));
        }
    }

    private static int solve(int[] A, int[] B, int X, int Y) {
        int n = A.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;  //前0份订单能得到的小费为0

        int countX = 0;
        int countY = 0;
        for (int i = 1; i <= n; i++) {
            if (countX > X) {
                dp[i] = dp[i - 1] + B[i - 1];
                countY++;
            } else if (countY > Y) {
                dp[i] = dp[i - 1] + A[i - 1];
                countX++;
            } else {
                dp[i] = dp[i - 1] + Math.max(A[i - 1], B[i - 1]);
                if (dp[i] == dp[i - 1] + A[i - 1]) {
                    countX++;
                } else {
                    countY++;
                }
            }
        }
        return dp[n];
    }
}
