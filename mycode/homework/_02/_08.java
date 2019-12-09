package nju.homework._02;

import java.util.Scanner;

//归并排序
public class _08 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int[] nums = new int[s1.length - 1];    //这个是正确答案（测试用例不对，测试用例把第一个也算进去了，ac的时候要算上第一个，在这里把-1去掉）
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i + 1]);  //这个是正确答案（测试用例不对，测试用例把第一个也算进去了，ac的时候要算上第一个，在这里把-1去掉）
            }
            mergeSort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.println(nums[i]);
                } else {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }

    private static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, 0, nums.length - 1, temp);
    }

    private static void sort(int[] nums, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, left, mid, temp);
            sort(nums, mid + 1, right, temp);
            merge(nums, left, mid, right, temp);
        }
    }

    private static void merge(int[] nums, int left, int mid, int right, int[] temp) {
        int p = left;  //左边数组的指针
        int q = mid + 1;  //右边数组的指针
        int index = 0;      //temp数组指针
        while (p <= mid && q <= right) {
            if (nums[p] < nums[q]) {
                temp[index++] = nums[p++];
            } else {
                temp[index++] = nums[q++];
            }
        }
        while (p <= mid) {
            temp[index++] = nums[p++];
        }
        while (q <= right) {
            temp[index++] = nums[q++];
        }
        index = 0;
        while (left <= right) {
            nums[left++] = temp[index++];
        }
    }
}
