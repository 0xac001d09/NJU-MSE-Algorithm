package nju.test.exercise02_B;

import java.util.Arrays;
import java.util.Scanner;

class _01_4 {
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int loop = in.nextInt();
        while (loop-- > 0) {
            int n = in.nextInt();
            int q = in.nextInt();

            long[] ranks = new long[n];
            long[] marks = new long[n];
            long low = in.nextLong();
            long high = in.nextLong();
            ranks[0] = high;
            marks[0] = high;
            for (int i = 1; i < n; i++) {
                low = in.nextLong();
                high = in.nextLong();
                ranks[i] = ranks[i-1] + high - low + 1;
                marks[i] = high;
            }

            for (int i = 0; i < q; i++) {
                long rank = in.nextLong();
                if (i != q - 1) {
                    System.out.print(solve(n, marks, ranks, rank) + " ");
                } else {
                    System.out.print(solve(n, marks, ranks, rank));

                }

            }
            System.out.println();
        }
    }

    private static long solve(int n, long[] marks, long[] ranks, long rank) {
        int index = Arrays.binarySearch(ranks, rank);
        if (index < 0) {
            index = -(index + 1);
        }
        if (index == n) {
            return rank - ranks[n-1] + marks[n-1];
        }
        long nthFromEnd = ranks[index] - rank;
        return marks[index] - nthFromEnd;
    }
}