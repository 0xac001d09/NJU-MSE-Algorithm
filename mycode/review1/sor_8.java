package nju.review1;

import java.util.Scanner;

/**
 * 倒置个数,如果一对元素A[i]和A[j]是倒序的，即i < j 但是A[i] > A[j]则称它们是一个倒置
 * 归并排序+计数
 */
public class sor_8 {
    static int count;   //计数

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            int[] nums = new int[size];
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            count = 0;
            mergeSort(nums);
            if (loop == 0) {
                System.out.print(count);
            } else {
                System.out.println(count);
            }
        }
    }

    private static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        sort(nums, temp, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(nums, temp, left, mid);
            sort(nums, temp, mid + 1, right);
            merge(nums, temp, left, mid, right);
        }
    }

    private static void merge(int[] nums, int[] temp, int left, int mid, int right) {
        int p = left;   //左指针
        int q = mid + 1;    //右指针
        int index = 0;
        while (p <= mid && q <= right) {
            if (nums[p] >= nums[q]) {           //相等的时候也是逆序的
                count += mid - p + 1;           //count += mid - p + 1; nums[p]后面一直到nums[mid]都是比nums[q]大的
                temp[index++] = nums[q++];      //先放小的
            } else {
                temp[index++] = nums[p++];
            }
        }

        while (p <= mid) {
            temp[index++] = nums[p++];
        }
        while (q <= right) {
            temp[index++] = nums[q++];
        }
        index = 0;
        //把temp中已经排序的搞进nums中
        while (left <= right) {
            nums[left++] = temp[index++];
        }
    }
}
