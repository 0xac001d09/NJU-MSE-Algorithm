package nju.test.exercise02_A;

import java.util.Scanner;

//漆狗屋
public class _03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            int k = Integer.parseInt(nums[0]);
            int board = Integer.parseInt(nums[1]);
            int[] arr = new int[board];
            String ss = sc.nextLine();
            String[] arrNum = ss.split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(arrNum[i]);
            }
            int best = partition(arr, k, board);
            System.out.println(best);
        }
    }

    //计算数组给定区间中的和
    public static int sum(int arr[], int from, int to) {
        int total = 0;
        for (int i = from; i <= to; i++)
            total += arr[i];
        return total;
    }

    //k个画家，n块板子，dp实现
    public static int findMax(int arr[], int k, int n) {
        int dp[][] = new int[k+1][n+1];
        // k=1
        for (int i = 1; i <= n; i++)
            dp[1][i] = sum(arr, 0, i - 1);

        // n=1
        for (int i = 1; i <= k; i++)
            dp[i][1] = arr[0];

        for (int i = 2; i <= k; i++) { // 2 to n boards
            for (int j = 2; j <= n; j++) {
                int best = Integer.MAX_VALUE;
                for (int p = 1; p <= j; p++)
                    best = Math.min(best, Math.max(dp[i - 1][p], sum(arr, p, j - 1)));

                dp[i][j] = best;
            }
        }
        return dp[k][n];
    }

    //递归实现

    /**
     *
     * @param arr
     * @param k     //k个画师
     * @param n     //n块板子
     * @return
     */
    public static int partition(int arr[], int k, int n) {
        if (k == 1) // one partition
            return sum(arr, 0, n - 1);
        if (n == 1)  // one board
            return arr[0];
        int best = Integer.MAX_VALUE;

        //在具有i个元素的情况下，找到arr [i]左侧所有可能的最大k-1个分区中的最小值，将第k-1个分隔符放在arr[i-1]和arr[i]之间以获取第k个分区
        for (int i = 1; i <= n; i++)
            best = Math.min(best, Math.max(partition(arr, k-1, i), sum(arr, i, n - 1)));
        return best;
    }
}