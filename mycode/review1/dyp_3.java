package nju.review1;

import com.sun.org.apache.bcel.internal.generic.IUSHR;

import java.util.Scanner;

/**
 * 按照要求保留数组元素使得和最大
 *
 * 这个题目助教都没有出完整...
 *
 * dp思路： 考虑选不选这个数字
 *      选的情况：把A[i] - 1 和A[i] + 1的个数置为0，然后 dp[i] = dp[i-2] + A[i] * 它的个数
 *      不选的情况：dp[i] = dp[i-1]
 *      两者取最大
 *
 * 约束：1<=T<=100，1<=n<=50，1<=A[i]<=20
 */
public class dyp_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            int[] A = new int[size];
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < size; i++) {
                A[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(A));
        }
    }

    private static int solve(int[] A) {
        int n = A.length;
        if (n == 1) {
            return A[0];
        }
        //统计数组中每个数字出现的次数...由于给的数字范围为1～20，计数
        int[] dp = new int[21];
        for (int i = 0; i < A.length; i++) {
            dp[A[i]]++;
        }
        //一共20种数字
        // i = 1不用管，因为它的最大值就是他的个数
        for (int i = 2; i <= 20; i++) {
            dp[i] = Math.max(dp[i - 2] + dp[i] * i, dp[i - 1]);     //选和不选
        }

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;

    }

}
