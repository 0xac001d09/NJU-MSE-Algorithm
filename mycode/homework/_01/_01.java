package nju.homework._01;

import java.util.Arrays;
import java.util.Scanner;

//子数组的取值范围
public class _01 {

    //正确答案
    public static void subArray(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // copyOfRange是左闭右开的
                int[] temp = Arrays.copyOfRange(arr, i, j+1);
                Arrays.sort(temp);
                if (temp[temp.length - 1] - temp[0] > k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 测试用例：
     * 1
     * 8 6 9
     * 2
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            String huiche = sc.nextLine();
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            int[] arr = new int[nums.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            int k = sc.nextInt();
            //在这修改方法
            subArray(arr, k);
        }
    }
}

