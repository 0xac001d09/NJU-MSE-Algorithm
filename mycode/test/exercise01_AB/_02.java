package nju.test.exercise01_AB;

import java.util.HashMap;
import java.util.Scanner;

//最小交换次数
public class _02 {
    //这个题用例有问题..没过
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            minSwap(arr);
            System.out.println();
        }
    }

    //环
    public static void minSwap(int[] arr) {
        int swapNum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                Integer index = map.get(i + 1);//获取下标
                map.put(i, i + 1);//把正确的归位；
                map.put(arr[i], index);//把原来不正确的键的值变成要交换的那个键对应的值
                swap(arr, i, index);
                swapNum++;
            }
        }
        System.out.println(swapNum);
    }

    public static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        test();
    }

}
