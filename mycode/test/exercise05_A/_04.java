package nju.test.exercise05_A;

import java.util.Scanner;

/**
 * 贪婪
 * 硬币最小数量
 *
 * 2    uc个数
 * 3 11 硬币数组长度 amount值
 * 1 2 5    硬币
 * 2 7
 * 2 6
 *
 * 考虑最后一步，最后一步就是前面所需最少的硬币+1
 */
public class _04 {

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
            System.out.println(solve(coins, amount));
        }
    }

    //用dp做
    private static int solve(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            //对于每一个硬币
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        } else {
            return dp[amount];
        }
    }
}
