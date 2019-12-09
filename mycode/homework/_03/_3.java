package nju.homework._03;

import java.util.Scanner;

/**
 * 实现希尔排序
 */
public class _3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s1 = sc.nextLine().split(" ");
            String[] s2 = sc.nextLine().split(" ");
            int[] nums = new int[s1.length];
            int[] gaps = new int[s2.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i < gaps.length; i++) {
                gaps[i] = Integer.parseInt(s2[i]);
            }
            for (int i = 0; i < gaps.length; i++) {
                solve(nums, gaps[i]);
            }

            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.println(nums[i]);
                } else {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }

    private static void solve(int[] nums, int gap) {
        for (int i = gap; i < nums.length; i++) {
            int temp = nums[i];
            int j;
            for (j = i - gap; j >= 0; j -= gap) {
                if (nums[j] > temp) {
                    nums[j + gap] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + gap] = temp;
        }
    }

}
