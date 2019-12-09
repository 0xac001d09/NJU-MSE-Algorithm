package nju.test.exercise02_B;

import java.util.Arrays;
import java.util.Scanner;

class _01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOftest = sc.nextInt();

        for (int i = 0; i < numOftest; i++) {
            int numOfGroup = sc.nextInt();
            int numOfRank = sc.nextInt();

            long[][] group = new long[numOfGroup][2];
            for (int j = 0; j < numOfGroup; j++) {
                group[j][0] = sc.nextLong();
                group[j][1] = sc.nextLong();
            }

            long[] ranks = new long[numOfRank];
            for (int j = 0; j < numOfRank; j++) {
                ranks[j] = sc.nextLong();
            }

            findMarks(numOfGroup, numOfRank, group, ranks);

        }

    }

    private static void findMarks(int numOfGroup, int numOfRank, long[][] group, long[] ranks) {

        long[] newRank = new long[numOfGroup];

        newRank[0] = group[0][1];
        for (int i = 1; i < numOfGroup; i++) {
            newRank[i] = group[i][1] - (group[i][0] - newRank[i - 1] - 1);
        }

        for (int i = 0; i < numOfRank; i++) {
            long rnk = ranks[i];
            int val = Arrays.binarySearch(newRank, rnk);
            if (val < 0) {
                val = -(val + 1);
            }

            long ans;
            if (val < numOfGroup) {
                ans = newRank[val] - rnk;
                System.out.print(group[val][1] - ans);
            } else {
                ans = newRank[numOfGroup - 1] - rnk;
                System.out.print(group[numOfGroup - 1][1] - ans);
            }

            System.out.print(" ");

        }

        System.out.print("\n");

    }
}