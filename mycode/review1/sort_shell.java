package nju.review1;

import java.util.Scanner;

/**
 * 希尔排序 https://www.cnblogs.com/chengxiao/p/6104371.html
 */
public class sort_shell {

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
            solve(nums, gaps);
        }
    }
    //里头是插入排序
    private static void solve(int[] nums, int[] gaps) {
        for (int i = 0; i < gaps.length; i++) {
            int gap = gaps[i];
            //根据gap能分成很多组，从每组的最后一个元素开始，执行插入排序
            for (int j = gap; j < nums.length; j++) {
                int k = j;
                while (k - gap >= 0 && nums[k] < nums[k - gap]) {
                    int temp = nums[k];
                    nums[k] = nums[k - gap];
                    nums[k - gap] = temp;
                    k -= gap;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i] + " ");
        }
        System.out.println(sb.toString().trim());
    }
}
