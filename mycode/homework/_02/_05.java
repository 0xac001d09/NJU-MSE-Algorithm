package nju.homework._02;

import java.util.Scanner;

//冒泡排序
public class _05 {

    private static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int[] nums = new int[s1.length - 1];    //第一个数字是数组长度
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i+1]);
            }
            //插入排序
            bubbleSort(nums);
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
