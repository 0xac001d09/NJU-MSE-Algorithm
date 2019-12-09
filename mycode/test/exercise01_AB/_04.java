package nju.test.exercise01_AB;

import java.util.Scanner;

//倒置个数
public class _04 {
    static int count;

    //输入
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            count = 0;
            mergeSort(arr);
        }
    }

    //笨办法是使用归并排序

    public static void mergeSort(int[] arr) {
        //使用一个空的数组来放结果，免得后面反复开辟空间
        int[] temp = new int[arr.length];
        sort(arr,0,arr.length-1,temp);
        System.out.println(count);
    }

    public static void sort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            sort(arr,left,mid,temp);
            sort(arr, mid + 1, right, temp);
            mergeArray(arr, left, mid, right,temp);
        }
    }

    public static void mergeArray(int[] arr, int left, int mid, int right, int[] temp) {
        int p = left;   //左指针
        int q = mid+1;  //右指针不是right
        int index = 0;  //temp的指针

        //统计逆序数和给数组排序的过程
        while (p <= mid && q <= right) {
            if (arr[p] > arr[q]) {
                temp[index++] = arr[q++];
                count += mid - p + 1;
            } else {
                temp[index++] = arr[p++];
            }
        }

        //处理残余
        while (p <= mid) {
            temp[index++] = arr[p++];
        }
        while (q <= right) {
            temp[index++] = arr[q++];
        }

        //把temp中的顺序覆盖到arr中
        index = 0;
        while (left <= right) {
            arr[left++] = temp[index++];
        }
    }

    public static void main(String[] args) {
        test();
    }
}
