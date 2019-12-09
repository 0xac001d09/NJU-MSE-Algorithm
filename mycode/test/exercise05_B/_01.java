package nju.test.exercise05_B;

import java.util.Scanner;

/**
 * 第五次作业，时间分隔和硬币最小数量在A班做过
 *
 * 路上的球
 *
 */
public class _01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i < m; i++) {
                b[i] = sc.nextInt();
            }
            solve(a, b);
        }
    }

    private static void solve(int[] a, int[] b) {
        long first = 0, second = 0, res = 0;
        int i = 0, j = 0;
        int n = a.length;
        int m = b.length;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                first += a[i++];
            } else if (a[i] > b[j]) {
                second += b[j++];
            } else {    //a[i] = b[
                res += Math.max(first, second) + a[i];
                first = 0;
                second = 0;
                i++;
                j++;
            }
        }
        while (i < n) {
            first += a[i++];
        }
        while (j < m) {
            second += b[j++];
        }
        res += Math.max(first, second);
        System.out.println(res);
    }
}
