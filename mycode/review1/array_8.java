package nju.review1;


/**
 * 调整数组使差最小https://blog.csdn.net/qq_33935895/article/details/103029767
 * 这个题可以理解为背包问题：两个数组，每个数组长度为n，要使得两个数组内的和的差最小，可以这么想
 * 2n个数加起来的和是sum，要找出n个数，使其和最接近sum/2，，求出这个最接近sum/2的值，那么第二个数组的和就知道了，两个数组的最小差也就知道了
 *
 * 设f[i][j][k]表示前i个元素中选取j个元素，使得其和不超过k且最接近k,那就氛围两种情况
 *      第一种：第i个元素不选：f[i][j][k] = f[i-1][j][k]
 *      第二种：第i个元素选：k>A[i] f[i][j][k] = f[i-1][j-1][k - A[i]]
 *      这两种情况需要选择一个较大值
 *
 * 这边必须非常小心的是，题目中说数组中的元素为任意整数，也就是说可以有负数，当全部都是负数时，f[i][j][k]，k都是负数，这就不好处理
 * 解决思路是，求出两个数组中的最小值，大家都减去最小值，那减后所有的数一定是大于等于0的数了，但并不会对结果有影响
 */
import java.util.Arrays;
import java.util.Scanner;

public class array_8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int[] nums1 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int[] nums2 = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).toArray();
            int res = solve2(nums1, nums2);
            System.out.println(res);
        }
    }

    //方法一，开三维数组,考试时写这个
    private static int solve1(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int sum = 0;
        int min = nums1[0]; //必须要求出最小值，才能避免负数
        int[] A = new int[2 * n];

        for (int i = 0; i < n; i++) {
            A[i] = nums1[i];
            A[i + n] = nums2[i];
            min = Math.min(min, Math.min(nums1[i], nums2[i]));
        }
        //计算sum，并求出sum/2
        for (int i = 0; i < A.length; i++) {
            A[i] -= min;  //A中每个元素必须变化
            sum += A[i];
        }

        int[][][] f = new int[2 * n + 1][n + 1][sum / 2 + 1];
        //初始化操作，0个元素的时候，后面怎样都是0

        //前i个元素
        for (int i = 1; i <= 2 * n; i++) {
            //前i个元素选几个，至多n个
            for (int j = 1; j <= Math.min(i, n); j++) {
                //背包容量
                for (int k = 0; k <= sum / 2; k++) {
                    //不放
                    f[i][j][k] = f[i - 1][j][k];
                    //放
                    if (k >= A[i-1]) {
                        f[i][j][k] = Math.max(f[i][j][k], f[i - 1][j - 1][k - A[i - 1]] + A[i - 1]);
                    }
                }
            }

        }
        return sum - 2 * f[2 * n][n][sum / 2];
    }


    //方法二，优化
    private static int solve2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int sum = 0;
        int min = nums1[0]; //必须要求出最小值，才能避免负数
        int[] A = new int[2 * n];

        for (int i = 0; i < n; i++) {
            A[i] = nums1[i];
            A[i + n] = nums2[i];
            min = Math.min(min, Math.min(nums1[i], nums2[i]));
        }
        //计算sum，并求出sum/2
        for (int i = 0; i < A.length; i++) {
            A[i] -= min;
            sum += A[i];
        }

        int i, j;
        int[][] dp = new int[n + 1][sum / 2 + 1];    //就取n件物品
        //初始化,取0件物品，重量都是0
        for (j = 0; j <= sum/2; j++) {
            dp[0][j] = 0;
        }
        //前i个，i = 1...2n
        for (int k = 1; k <= 2 * n; k++) {
            //选取,少于n个就都选，多于n个只能选n个
            for (i = Math.min(k, n); i >= 1; i--) {     //三维压缩成二维需要逆序更新
                for (j = sum / 2; j >= 1; j--) {
                    if (j >= A[k - 1]) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[k - 1]] + A[k - 1]);
                    }
                }

            }
        }
        return sum - 2 * dp[n][sum / 2];
    }

}
