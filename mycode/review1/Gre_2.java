package nju.review1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 时间分隔，感觉必考，就是课上高岳上去画的
 * 碰到来的+1，碰到去的-1，记录一个最大值
 * 900 1
 * 940 1
 * 950 1
 * 1100 1
 * 1500 1
 * 1800 1
 * 910 -1
 * 1200 -1
 * 1130 -1
 * 1900 -1
 * 2000 -1
 * 然后按照时间排序
 *
 */
public class Gre_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            int[] dep = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < size; i++) {
                dep[i] = sc.nextInt();
            }
            solve2(arr, dep);
        }
    }

    //一个比较繁琐的操作
    private static void solve(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] matrix = new int[2 * n][2];
        for (int i = 0; i < n; i++) {
            matrix[i][0] = nums1[i];
            matrix[i][1] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[i + n][0] = nums2[i];
            matrix[i + n][1] = -1;
        }
        Arrays.sort(matrix, (o1, o2) -> o1[0] - o2[0]);

        int res = 0;
        int temp = 0;
        for (int i = 0; i < 2 * n; i++) {
            temp += matrix[i][1];
            if (temp > res) {
                res = temp;
            }
        }
        System.out.println(res);
    }

    //第二种写法
    private static void solve2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int count = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        int res = 0;
        int need = 0;
        while (i < n && j < n) {
            if (nums1[i] <= nums2[j]) {
                need++;
                i++;
                if (need > res) {
                    res = need;
                }
            } else {
                need--;
                j++;
            }
        }
        System.out.println(res);
    }
}
