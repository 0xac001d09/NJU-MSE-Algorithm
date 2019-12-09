package nju.test.exercise02_B;

import java.util.Arrays;
import java.util.Scanner;

class _01_5  {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            long[][] a = nextInts(sc, n, 2);
            long[] b = nextInts(sc, 1, m)[0];
            long[] c = new long[n];
            c[0] = a[0][1];
            int offset = 0;

            for (int i = 1; i < n; i++) {
                offset += a[i][0] - a[i - 1][1] - 1;
                c[i] = a[i][1] - offset;
            }

            for (long i : b) {
                int j = Arrays.binarySearch(c, i);
                if (j < 0)
                    j = -j - 1;
                // System.out.println(a[j][0]);
                System.out.print((j == n ? a[j - 1][1] + 1 : a[j][0]) + (j > 0 ? i - c[j - 1] - 1 : i - 1));
                System.out.print(' ');
            }
            System.out.println();

        }
    }

    private static long[][] nextInts(Scanner in, int n, int m) {
        long[][] ret = new long[n][m];
        for (int r = 0; r < n; r++)
            for (int c = 0; c < m; c++)
                ret[r][c] = in.nextLong();
        return ret;
    }
}