package nju.homework._02;

import java.util.Scanner;

//计数排序
public class _06 {

    private static void countSort(int[] nums) {
        int max = max(nums);
        int min = min(nums);
        int[] countArray = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            countArray[nums[i] - min]++;
        }
        //输出结果
        int[] res = new int[nums.length];
        int index = 0;
        for (int i = 0; i < countArray.length; i++) {
            int times = countArray[i];
            for (int j = 0; j < times; j++) {
                res[index++] = i + min;
            }
        }

        //打印
        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                System.out.println(res[i]);
            } else {
                System.out.print(res[i] + " ");
            }
        }
    }

    //求数组中的最大值
    private static int max(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
    //求数组中的最小值
    private static int min(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();       ////这一行第一个数字是数组长度
            String[] s1 = s.split(" ");
            int[] nums = new int[s1.length - 1];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i + 1]);
            }
            countSort(nums);
        }
    }
}
