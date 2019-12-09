package nju.homework._01;

import java.util.Scanner;

//数组和窗口
public class _03 {
    public static void test(){
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            String ss = sc.nextLine();       //读取第一行的回车
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            int[] arr = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                arr[i] = num;
            }
            int k = sc.nextInt();
            int i = manlifa(arr, k);
            System.out.println(i);
        }

    }

    //蛮力法
    public static int manlifa(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
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


    public static void main(String[] args){
        test();
    }
}
