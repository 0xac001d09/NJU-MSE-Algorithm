package nju.review1;
/**
 * 数组和窗口
 */
import java.util.Scanner;
public class array_2 {

    //必须得要写这种输入才能过，服了
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            int[] arr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                arr[i] = num;
            }
            int k = Integer.parseInt(sc.nextLine().trim());
            int i = solve(arr, k);
            System.out.println(i);
        }
    }

    //暴力
    private static int solve(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                if (nums[j] > max) {
                    max = nums[j];
                }
            }
            count += max;
        }
        return count;
    }


}
