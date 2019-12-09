package nju.homework._02;

import java.util.Arrays;
import java.util.Scanner;

public class _03 {

    private static void solve(String[] strs, int k) {
        int times = strs.length / k;        //翻转次数
        for (int i = 0; i < times; i++) {
            int from = i * k;
            int to = (i + 1) * k - 1;
            reverse(strs, from, to);
        }
        //打印
        for (int i = 0; i < strs.length; i++) {
            if (i == strs.length - 1) {
                System.out.println(strs[i]);
            } else {
                System.out.print(strs[i] + " ");
            }
        }
    }

    private static void reverse(String[] strs, int from, int to) {
        while (from < to) {
            String temp = strs[from];
            strs[from] = strs[to];
            strs[to] = temp;
            from++;
            to--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");

            int k = Integer.parseInt(nums[nums.length - 1]);
            solve(Arrays.copyOfRange(nums,1,nums.length-1),k);      //左闭右开
        }
    }

}
