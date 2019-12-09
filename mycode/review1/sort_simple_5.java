package nju.review1;

import java.util.Scanner;

/**
 * 归并排序 mergeSort
 * 递归
 * 调api过不去的
 */
public class sort_simple_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length - 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i + 1]);
        }
        mergeSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.println(nums[i]);
            } else {
                System.out.print(nums[i]+" ");
            }
        }
    }

    private static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];  //首先设置一个temp存放中间结果，再把中间结果覆盖到nums中的特定区域
        sort(nums, 0, nums.length - 1, temp);
    }

    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;       //加
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);       //+1
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int p = left;   //左区域指针
        int q = mid + 1;    //右区域指针
        int index = 0;
        while (p <= mid && q <= right) {        //注意p <= mid q <= right
            if (nums[p] <= nums[q]) {
                temp[index++] = nums[p++];
            } else {
                temp[index++] = nums[q++];
            }
        }
        while (p <= mid) {      //<= mid!!!!!!
            temp[index++] = nums[p++];
        }
        while (q <= right) {
            temp[index++] = nums[q++];
        }
        //把temp中的排好序的数组覆盖到nums中left到right区间
        index = 0;
        while (left <= right) {
            nums[left++] = temp[index++];
        }
    }
}
