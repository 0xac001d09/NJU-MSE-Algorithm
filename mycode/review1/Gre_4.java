package nju.review1;

import java.util.Scanner;

/**
 * 硬币最小数量
 */
public class Gre_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int size = sc.nextInt();
            int amount = sc.nextInt();
            int[] coins = new int[size];
            for (int i = 0; i < size; i++) {
                coins[i] = sc.nextInt();
            }
            solve(coins, amount);
        }
    }

    private static void solve(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            //初始化
            dp[i] = Integer.MAX_VALUE;
            //对于每个硬币
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {       //这个要双重条件！！！！
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[amount]);
        }
    }
}
