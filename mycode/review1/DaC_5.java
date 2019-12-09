package nju.review1;

/**
 * 书本分发，区间型dp
 * 假设一共n本书，由k个抄写员来抄写，每个人抄的都是连续的，问最短的抄写时间是多少
 * 解决思路从最后一个人开始看，最后一个人可能抄0本、1本、2本...n本书，有两种情况
 *      第一种情况：最后一个人抄书耗费时间比之前抄书耗费的时间少，那就跟他没关系了
 *      第二种情况：最后一个人抄书耗费的时间比前面抄书耗费的时间多，那就是这个时间
 * 我们要找的是 每个人抄完自己那段和的最大值（这是完成任务的最短时间） 中的最小值
 * dp[i][j] 代表第i个人要抄写j本书
 * 根据这两种情况可得出公式
 * dp[i][j] = max{dp[i-1][l],sum},sum是第i个抄写员抄写书花费的时间，
 */
import java.util.Scanner;

public class DaC_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int len = Integer.parseInt(sc.nextLine().trim());
            int[] nums = new int[len];

            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            for (int i = 0; i < len; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }

            int k = Integer.parseInt(sc.nextLine().trim());

            int res = solve(nums, k);
            System.out.println(res);
        }
    }

    //k个抄写员
    private static int solve(int[] nums, int k) {
        int n = nums.length;    //一共几本书
        if (n == 0) {
            return 0;
        }
        int[][] dp = new int[k + 1][n + 1];
        //初始化：k个抄写员抄写0本书，花费时间都是0
        for (int i = 0; i <= k; i++) {
            dp[i][0] = 0;
        }
        //初始化：0个抄写员抄写0本书，花费时间是0，o个抄写员抄写1本、2本。。。花费时间无穷大
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        //一共前i个抄写员
        for (int i = 1; i <= k; i++) {

            //前i个抄写员一共抄写j本书
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                int sum = 0;
                //前i-1个抄写员抄写l本书，l从j开始，也就是先让最后一个人从0本开始，然后累加，这样就不用额外去计算这个人抄写花费的时间
                for (int l = j; l >= 0; l--) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][l], sum));
                    if (l > 0) {
                        sum += nums[l-1];
                    }
                }
            }
        }
        return dp[k][n];
    }

}
