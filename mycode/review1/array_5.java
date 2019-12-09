package nju.review1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 区间第k小
 */
public class array_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine());
        while (loop-- > 0) {
            String[] s1 = sc.nextLine().split(" ");
            String[] s2 = sc.nextLine().split(" ");
            int k = Integer.parseInt(sc.nextLine());
            int[] nums = new int[s1.length];
            int[] region = new int[s2.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i]);
            }
            for (int i = 0; i < region.length; i++) {
                region[i] = Integer.parseInt(s2[i]);
            }
            System.out.println(solve(nums, region, k));
        }
    }

    private static int solve(int[] nums, int[] region, int k) {
        int[] arr = Arrays.copyOfRange(nums, region[0] - 1, region[1] - 1 + 1);  //注意左闭右开
        Arrays.sort(arr);
        return arr[k - 1];
    }
}
