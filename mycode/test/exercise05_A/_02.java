package nju.test.exercise05_A;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 时间分隔
 *
 * 1
 * 6
 * 900  940 950  1100 1500 1800
 * 910 1200 1120 1130 1900 2000
 *
 * 900  a +1     1
 * 910  d -1     0
 * 940  a +1     1
 * 950  a +1     2
 * 1100 a +1     3
 * 1120 d -1     2
 * 1130 d -1     1
 * 1200 d -1     0
 * 1500 a +1     1
 * 1800 a +1     2
 * 1900 d -1     1
 * 2000 d -1     0
 */
public class _02 {

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
            solve(arr, dep);
        }
    }

    private static void solve(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int need = 0;
        int res = 0;
        int i = 0, j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                need++;
                i++;

                if (need > res) {
                    res = need;
                }
            } else {        //arr[i] > dep[j]
                need--;
                j++;
            }
        }
        System.out.println(res);
    }
}
