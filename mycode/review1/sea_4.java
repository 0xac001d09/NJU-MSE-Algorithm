package nju.review1;

import java.util.Scanner;

/**
 * Magnet Array Problem
 *
 * 就是在一条线上放了很多个磁铁，让你在这条线上找受力为0的点？ 这条线上每个点受到距离为d的磁铁的力是 1/d
 *
 * 二分法
 *
 * 每两个点算出中间点的受力(受力为0的点必定在这条线段当中)，受力>0,则要向给出力小于0的方向移动，受力 < 0,则要向给出力大于0的方向移动
 * 规定这个点左边给出的力大于0，右边给出的力小于0
 *
 * 这个题有个小问题。。
 */
public class sea_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            int[] nums = new int[size];
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            solve(nums);
        }
    }

    private static void solve(int[] nums) {
        //从第一个相邻的两个点，到最后一段相邻的两个点
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < nums.length; i++) {
            double left = nums[i - 1];
            double right = nums[i];

            //找出这两个点内受力为0的点（如果有的话
            while (left < right) {
                double mid = (left + right) / 2;
                //计算这个点的受力,左正又负
                double sum = 0;
                for (int j = 0; j < nums.length; j++) {
                    sum += (1 / (mid - nums[j]));
                }
                //如果符合条件
                if (Math.abs(sum) < 0.000000001) {                          //！！！！！题目中是0.0000000000001，如果用这个的话会TLE，改成9个0的
                    sb.append(String.format("%.2f", mid)).append(" ");
                    break;      //一定别忘了break！找到了就停止
                }

                //如果sum > 0,向右移动，否则向左移动
                else if (sum > 0) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
