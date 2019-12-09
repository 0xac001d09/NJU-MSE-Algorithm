package nju.review1;

import java.util.Scanner;

/**
 * 路上的球
 */
public class Gre_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] nums1 = new int[n];
            int[] nums2 = new int[m];

            for (int i = 0; i < n; i++) {
                nums1[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                nums2[i] = sc.nextInt();
            }
            solve(nums1, nums2);
        }
    }

    private static void solve(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0, j = 0;
        int first = 0;  //统计第一条路
        int second = 0; //统计第二条路
        int res = 0;

        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                first += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                second += nums2[j++];
            } else {        //碰到交点了
                res += Math.max(first, second) + nums1[i];  //千万别忘了加交点
                first = 0;
                second = 0;
                i++;
                j++;
            }
        }
        while (i < n) {
            first += nums1[i++];
        }
        while (j < m) {
            second += nums2[j++];
        }
        res += Math.max(first, second);
        System.out.println(res);
    }
}
