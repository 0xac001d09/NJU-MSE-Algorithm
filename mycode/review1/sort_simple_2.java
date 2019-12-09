package nju.review1;

import java.util.Scanner;

/**
 * 冒泡排序
 */
public class sort_simple_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int size = Integer.parseInt(s[0]);
        int[] nums = new int[size];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i + 1]);
        }
        solve(nums);
    }

    private static void solve(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.println(nums[i]);
            } else {
                System.out.print(nums[i]+" ");
            }
        }
    }
}
