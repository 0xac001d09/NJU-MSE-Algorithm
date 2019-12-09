package nju.review1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 插入排序？ 不存在的
 */
public class sort_simple_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int[] nums = new int[s.length - 1];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.println(nums[i]);
                } else {
                    System.out.print(nums[i]+" ");
                }
            }
        }
    }
}
