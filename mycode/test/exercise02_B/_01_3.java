package nju.test.exercise02_B;

import java.util.Arrays;
import java.util.Scanner;

class _01_3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int nTests = sc.nextInt();
        while (nTests-->0) {
            int n = sc.nextInt();       //有几组
            int m = sc.nextInt();       //学生数
            long[][] vals = new long[2][n];
            long[] sizes = new long[n];
            for (int k = 0; k < n; k++) {
                vals[0][k] = sc.nextLong();
                vals[1][k] = sc.nextLong();
                sizes[k] = vals[1][k] - vals[0][k] + 1 + (k > 0 ? sizes[k-1] : (vals[0][k]-1));
            }
            for (int k = 0; k < m; k++) {
                long rank = sc.nextLong();
                int pos = Arrays.binarySearch(sizes, rank);
                if (pos < 0)
                    pos = -pos -1;
                if (pos == n)
                    pos--;
                System.out.print((vals[1][pos] - sizes[pos] + rank) + " ");
            }

            System.out.println();
        }
    }
}