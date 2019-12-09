package nju.review1;

import java.util.Scanner;

/**
 * 数组查询
 */
public class dyp_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            int[] nums = new int[size];
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(nums));
        }
    }

    private static int solve(int[] nums) {
        int n = nums.length;
        if (n == 1) { //由于我是在下面for循环内部找res的，而且循环从1开始，不是从0开始的，我需要现在这判断下数组长度是不是1，如果是1，则进不去循环，打印出的res是Integer.MIN_VALUE，就不对了
            return nums[0];
        }
        int[] f = new int[n];   // f(i) 表示不删除元素的情况下最大子数组和
        int[] g = new int[n];   // g(i) 表示删除元素的情况下最大自子数组的和

        //初始化
        f[0] = nums[0];
        g[0] = -200001;

        //遍历剩余元素
        int res = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i - 1] + nums[i], nums[i]);   //不删除的情况下，放和不放两种情况,对于这个不放的情况不要理解为Math.max(f[i - 1] + nums[i], nums[i])，不放就是只看当前元素了
            g[i] = Math.max(f[i - 1], g[i - 1] + nums[i]);   //删除当前元素和不删当前元素
            res = Math.max(res, Math.max(f[i], g[i]));
        }
        return res;
    }
}
