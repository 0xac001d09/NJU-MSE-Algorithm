package nju.review1;

import java.util.Scanner;

/**
 * 漆狗屋，区间型动态规划，这个题和抄书（书本分发）是一样的
 */
public class sea_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s1 = sc.nextLine();
            String[] ss1 = s1.split(" ");
            int k = Integer.parseInt(ss1[0]);
            int len = Integer.parseInt(ss1[1]);
            String s2 = sc.nextLine();
            String[] ss2 = s2.split(" ");

            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(ss2[i]);
            }
            int res = solve(nums, k);
            System.out.println(res);
        }
    }

    private static int solve(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[k + 1][n + 1];
        //初始化：k个人漆0块板子，耗费时间都是0
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
        }
        //初始化：0个人漆多于0块板子，时间都是无穷大
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        //前i个人去漆板子
        for (int i = 1; i <= k; i++) {

            //前i个人漆j块板子，0块板子已经处理过了，从第一块开始
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                //前i-1个人漆l块，最后一个人耗费时间为sum,l从j开始，代表最后一个人先漆最后的0块开始，然后然后一块，最后两块，这样累加
                int sum = 0;
                for (int l = j; l >= 0; l--) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][l], sum));
                    if (l > 0) {
                        //sum = nums[l] +。。。+nums[j-1]
                        sum += nums[l - 1];
                    }
                }
            }
        }
        return dp[k][n];

    }

}
