package nju.homework._02;

import java.util.Scanner;

// 实现插入排序

public class _04 {

    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];     //先存这个数，后面while循环挪动时候会覆盖
            int left = i - 1;       //左边的
            while (left >= 0 && nums[left] > temp) {
                //与此同时挪动left上的数
                nums[left + 1] = nums[left];
                left--;
            }
            //此时到了这个left这个位置了，left上的数<=temp，那就得把temp放置到left+1
            nums[left + 1] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int[] nums = new int[s1.length - 1];        //第一个数字是数组长度
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i+1]);
            }
            //插入排序
            insertSort(nums);
            //打印
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.println(nums[i]);
                } else {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }
}
