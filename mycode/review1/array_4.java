package nju.review1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 子数组的取值范围
 */
public class array_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int target = Integer.parseInt(sc.nextLine().trim());
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(nums,target));
        }
    }

    private static int solve(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int[] arr = Arrays.copyOfRange(nums, i, j + 1);   //左闭右开
                Arrays.sort(arr);
                if (arr[arr.length - 1] - arr[0] > k) {
                    count++;
                }
            }
        }
        return count;
    }
}
